import java.util.Arrays;
import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int numOfRows = in.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numOfColumns = in.nextInt();
        char[][] seats = new char[numOfRows][numOfColumns];
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfColumns; j++) {
                seats[i][j] = 'S';
            }
        }

        while (true) {
            menu();

            int c = in.nextInt();
            if (c == 1) {
                printSeats(seats);

            } else if (c == 2) {
                makeRes(seats);

            } else if (c == 3) {
                getStatistics(seats);
            } else {
                break;
            }
        }




    }
    public static void printSeats (char[][] s) {
        System.out.println();
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 0; i <s[0].length; i++) {
            System.out.print((i+1) + " ");
        }
        System.out.println();
        for (int i = 0; i < s.length; i++) {
            System.out.print(i+1+" ");
            for (int j = 0; j < s[0].length; j++) {
                System.out.print(s[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void getTicketPrice (int rows, int columns , int row) {
        if(rows * columns <= 60) {
            System.out.println("Ticket price: $10");
        } else {
            if (row <= rows / 2) {
                System.out.println("Ticket price: $10");
            } else {
                System.out.println("Ticket price: $8");
            }
        }
    }
    public static void makeRes(char[][] g) {
        Scanner in = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter a row number:");
        int row = in.nextInt();
        System.out.println("Enter a seat number in that row:");
        int column = in.nextInt();
        if (row > g.length || column > g[0].length) {
            System.out.println();
            System.out.println("Wrong input!");
            makeRes(g);
        } else if (g[row-1][column-1] == 'S') {
            g[row - 1][column - 1] = 'B';
            getTicketPrice(g.length, g[0].length, row);
        } else {
            System.out.println();
            System.out.println("That ticket has already been purchased!");
            makeRes(g);
        }
    }
    public static void menu() {
        System.out.println();
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }
    public static void getStatistics(char[][] g) {
        System.out.println();
        int numOfTickets = 0;
        float precentage = 0;
        int currentIncome = 0;
        int totalIncome = 0;
        if (g.length * g[0].length <= 60) {
            totalIncome = g.length * g[0].length * 10;
            for (int i = 0; i < g.length; i++) {
                for (int j = 0; j < g[0].length; j++) {
                    if (g[i][j] == 'B') {
                        numOfTickets++;

                    }
                }
            }
            currentIncome = numOfTickets * 10;
            precentage = (((float) numOfTickets / (g.length * g[0].length))) * 100;

        } else {
            int halfRows = g.length / 2;
            int rest = g.length - halfRows;
            totalIncome = halfRows * g[0].length * 10 + rest * g[0].length * 8;
            for (int i = 0; i < g.length; i++) {
                for (int j = 0; j < g[0].length; j++) {
                    if (g[i][j] == 'B') {
                        numOfTickets++;
                        if (i <= halfRows-1) {
                            currentIncome += 10;
                        } else {
                            currentIncome += 8;
                        }
                    }
                }
            }
            precentage = (((float) numOfTickets / (g.length * g[0].length))) * 100;
        }
        System.out.println("Number of purchased tickets: "+numOfTickets);
        System.out.printf("Percentage: %.2f" , precentage);
        System.out.println("%");
        System.out.println("Current income: "+"$"+currentIncome);
        System.out.println("Total income: $"+totalIncome);

    }
}
