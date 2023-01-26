public class TicTacToe {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[][] gameBored = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBored[i][j] = ' ';
            }
        }
        printGameBoard(gameBored);
        String row = in.next();
        String column = in.next();
        int indicateSymbol = 0;
        int countX = 0;
        int countO = 0;
        while (true) {
            if (inputValid(row,column)) {
                row = in.next();
                column = in.next();
            } else {


                if (isFilled(row,column,gameBored)) {
                    //System.out.println("This cell is occupied! Choose another one!");
                    row = in.next();
                    column = in.next();
                } else {
                    char temp = getSymbol(indicateSymbol) ;
                    gameBored[Integer.parseInt(row)-1][Integer.parseInt(column)-1] = temp ;


                    if (temp == 'X') {
                        countX++;
                    } else {
                        countO++;
                    }


                    indicateSymbol++;
                    printGameBoard(gameBored);
                }
            }

            if(getState(gameBored,countX,countO)) {
                break;
            } else {
                row = in.next();
                column = in.next();
            }



        }
    }
    public static void printGameBoard (char[][] gameBored) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + gameBored[i][j]);
            }
            System.out.print(" |");
            System.out.println();
        }
        System.out.println("---------");
    }
    public static boolean inputValid (String r , String c) {
        if (r.charAt(0) >= 'a' && r.charAt(0) <= 'z'){
            System.out.println("You should enter numbers!");
            return true;
        } else  if (Integer.parseInt(r) > 3 || Integer.parseInt(c) > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return true;
        } else {
            return false;
        }
    }
    public static boolean isFilled (String r , String c , char[][] g) {
        if(g[Integer.parseInt(r)-1][Integer.parseInt(c)-1] == ' '){
            return false;
        } else if (g[Integer.parseInt(r)-1][Integer.parseInt(c)-1] == 'X' || g[Integer.parseInt(r)-1][Integer.parseInt(c)-1] == 'O' ) {
            System.out.println("This cell is occupied! Choose another one!");

        }
        return  true;
    }
    public static char getSymbol ( int x) {
        if (x % 2 == 0) {
            return 'X';
        } else {
            return 'O';
        }
    }
    public static boolean getState (char[][] matrix , int cX , int cO) {
        boolean xWin = matrix[0][0] == 'X' && matrix[0][1] == 'X' && matrix[0][2] == 'X'
                || matrix[1][0] == 'X' && matrix[1][1] == 'X' && matrix[1][2] == 'X'
                || matrix[2][0] == 'X' && matrix[2][1] == 'X' && matrix[2][2] == 'X'
                || matrix[0][0] == 'X' && matrix[1][0] == 'X' && matrix[2][0] == 'X'
                || matrix[0][1] == 'X' && matrix[1][1] == 'X' && matrix[2][1] == 'X'
                || matrix[0][2] == 'X' && matrix[1][2] == 'X' && matrix[2][2] == 'X'
                || matrix[0][0] == 'X' && matrix[1][1] == 'X' && matrix[2][2] == 'X'
                || matrix[0][2] == 'X' && matrix[1][1] == 'X' && matrix[2][0] == 'X';
        boolean winO =  matrix[0][0] == 'O' && matrix[0][1] == 'O' && matrix[0][2] == 'O'
                || matrix[1][0] == 'O' && matrix[1][1] == 'O' && matrix[1][2] == 'O'
                || matrix[2][0] == 'O' && matrix[2][1] == 'O' && matrix[2][2] == 'O'
                || matrix[0][0] == 'O' && matrix[1][0] == 'O' && matrix[2][0] == 'O'
                || matrix[0][1] == 'O' && matrix[1][1] == 'O' && matrix[2][1] == 'O'
                || matrix[0][2] == 'O' && matrix[1][2] == 'O' && matrix[2][2] == 'O'
                || matrix[0][0] == 'O' && matrix[1][1] == 'O' && matrix[2][2] == 'O'
                || matrix[0][2] == 'O' && matrix[1][1] == 'O' && matrix[2][0] == 'O';
        boolean draw = cX + cO == 9;
        if (xWin) {
            System.out.println("X wins");
        } else if (winO) {
            System.out.println("O wins");
        } else if (draw) {
            System.out.println("Draw");
        }
        return xWin || winO || draw;
    }
}