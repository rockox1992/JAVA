import java.util.*;

public class Main {
    private static final int[] l = {0};
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("-b"))) + formatDiv("-c");
    private static final String midl10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("-e"))) + formatDiv("-f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("-h"))) + formatDiv("-i");
    private static final List<BaseHero> darkSide = new ArrayList<>();
    private static final List<BaseHero> whiteSide = new ArrayList<>();
    private static final int MAX_BAND = 50;

    public static void main(String[] args) {
        int step = 1;
        init();
        Scanner in = new Scanner(System.in);
        System.out.print("Press Enter to begin.");
        in.nextLine();

        System.out.print(AnsiColors.ANSI_RED + "First step" + AnsiColors.ANSI_RESET);
        view();
        in.nextLine();

        boolean flag = true;
        while (flag) {
            System.out.print(AnsiColors.ANSI_RED + "Step" + step++ + AnsiColors.ANSI_RESET);


            darkSide.forEach((s) -> s.step(whiteSide));
            whiteSide.forEach((s) -> s.step(darkSide));
            view();

            //String lost = lostHero();

            String tmp = isGameOver();
            if(tmp.length() > 0){
                System.out.println(tmp);
                flag = false;
            }

            in.nextLine();
        }
    }
//    private static String lostHero(){
//        int cnt = darkSide.size();
//        for(BaseHero hero: darkSide){
//            if (hero.getStatus().equals("Die")) cnt--;
//        }
//        System.out.println(cnt);
//        if (cnt == 0) return "";
//        return null;
//    }
    private static String isGameOver(){
        int cnt = darkSide.size();
        for(BaseHero hero: darkSide){
            if (hero.getStatus().equals("Die")) cnt--;
        }
        System.out.println("Blue live " + cnt);
        if (cnt == 0) return "Green side is WIN!";

        cnt = whiteSide.size();
        for(BaseHero hero: whiteSide){
            if (hero.getStatus().equals("Die")) cnt--;
        }
            System.out.println("Green live " + cnt);
        if (cnt == 0) return "Blue side is WIN!";
            return "";
    }
    public static void init() {
        int x = 1;
        int y = 1;

        Random rnd = new Random();
        int max = MAX_BAND;
        for (int i = 0; i < 10; i++) {
            int cal = max > 0 ? new Random().nextInt(15) + 1 : 1;
            switch (rnd.nextInt(4)) {
                case 0:
                    darkSide.add(new Peasant(darkSide, x++, y, cal));
                    break;
                case 1:
                    darkSide.add(new Robber(darkSide, x++, y, cal));
                    break;
                case 2:
                    darkSide.add(new Sniper(darkSide, x++, y, cal));
                    break;
                default:
                    darkSide.add(new Magician(darkSide, x++, y, cal));
            }
            max -= cal;
        }


        x = 1;
        y = 10;

        max = MAX_BAND;
        for (int i = 0; i < 10; i++) {
            int cal = max > 0 ? new Random().nextInt(15) + 1 : 1;
            switch (rnd.nextInt(4)) {
                case 0:
                    whiteSide.add(new Peasant(whiteSide, x++, y, cal));
                    break;
                case 1:
                    whiteSide.add(new Monk(whiteSide, x++, y, cal));
                    break;
                case 2:
                    whiteSide.add(new Crossbowman(whiteSide, x++, y, cal));
                    break;
                default:
                    whiteSide.add(new Spearman(whiteSide, x++, y, cal));
            }
            max -= cal;
        }

    }

    private static void tabSetter(int cnt, int max) {
        int dif = max - cnt + 2;
        if (dif > 0) System.out.printf("%" + dif + "s", ":\t");
        else System.out.print(":\t");
    }

    private static String formatDiv(String str) {
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }

    private static String getChar(int x, int y) {
        String out = "| ";
        boolean flag = false;
        for (int cnt = 0; cnt < darkSide.size(); cnt++) {
            if (darkSide.get(cnt).getPosition().x == x && darkSide.get(cnt).getPosition().y == y) {
                flag = true;
                out = "|" + ((darkSide.get(cnt).getStatus().equals("Die") ? AnsiColors.ANSI_RED : AnsiColors.ANSI_BLUE) + darkSide.get(cnt).getName().charAt(0) + AnsiColors.ANSI_RESET);
            } else if (whiteSide.get(cnt).getPosition().x == x && whiteSide.get(cnt).getPosition().y == y) {
                if (!flag | darkSide.get(cnt).getStatus().equals("Die")) {
                    out = "|" + ((whiteSide.get(cnt).getStatus().equals("Die") ? AnsiColors.ANSI_RED : AnsiColors.ANSI_GREEN) + whiteSide.get(cnt).getName().charAt(0) + AnsiColors.ANSI_RESET);
                }
            }
        }
        return out;
    }

    private static void view() {
        darkSide.forEach((v) -> l[0] = Math.max(l[0], v.returnCondition().length()));
        for (int i = 0; i < l[0] * 2; i++) System.out.print("_");
        System.out.println("");
        System.out.print(top10 + "    ");
        System.out.print("Blue side");
        for (int i = 0; i < l[0] - 9; i++) System.out.print(" ");
        System.out.println(":\tGreen side");
        for (int i = 1; i < 11; i++) {
            System.out.print(getChar(1, i));
        }
        System.out.print("|    ");
        System.out.print(darkSide.get(0).returnCondition());
        tabSetter(darkSide.get(0).returnCondition().length(), l[0]);
        System.out.println(whiteSide.get(0).returnCondition());
        System.out.println(midl10);

        for (int i = 2; i < 9; i++) {
            for (int j = 1; j < 11; j++) {
                System.out.print(getChar(i, j));
            }
            System.out.print("|    ");
            System.out.print(darkSide.get(i - 1).returnCondition());
            tabSetter(darkSide.get(i - 1).returnCondition().length(), l[0]);

            System.out.println(whiteSide.get(i - 1).returnCondition());
            System.out.println(midl10);
        }
        for (int j = 1; j < 11; j++) {
            System.out.print(getChar(10, j));
        }
        System.out.print("|    ");
        System.out.print(darkSide.get(9).returnCondition());
        tabSetter(darkSide.get(9).returnCondition().length(), l[0]);
        System.out.println(whiteSide.get(9).returnCondition());
        System.out.println(bottom10);
    }
}


