package cinema;

import java.util.Scanner;

public class Cinema {
    
    public static final Scanner scanner = new Scanner(System.in);
    
    char[][] seats;
    
    int cinc = 0;
    
    int nopt = 0;
    
    public Cinema(int r, int c) {
        seats = new char[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                seats[i][j] = 'S';
            }
        }
    }

    public static void main(String[] args) {
        // Write your code here
        boolean isloop = true;
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int columns = scanner.nextInt();
        Cinema a = new Cinema(rows, columns);
        while (isloop) {
            fs();
            String input = scanner.next();
            if ("0".equals(input)) {
                isloop = false;
                break;
            } else if ("1".equals(input)) {
                a.tickets();
            } else if ("2".equals(input)) {
                a.bticket();
            } else if ("3".equals(input)) {
                a.statistcs();
            }
        }
    }
    
    public static void fs() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }
    
    public void tickets() {
        System.out.print("\nCinema:\n  ");
        for (int i = 1; i <= seats[0].length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        for (int i = 0; i < seats.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < seats[0].length; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public void bticket() {
        boolean isloop = true;
        while(isloop) {
            System.out.println("Enter a row number:");
            int cr = scanner.nextInt() - 1;
            System.out.println("Enter a seat number in that row:");
            int cc = scanner.nextInt() - 1;
            int m = seats[0].length * seats.length;
            if (cr < 0 || cc < 0 || cr >= seats.length || cc >= seats[0].length) {
                System.out.println("Wrong input!");
            } else if (seats[cr][cc] == 'B') {
                System.out.println("That ticket has already been purchased!");
            } else {
                seats[cr][cc] = 'B';
                if (m > 60) {
                    if (cr + 1 > seats.length / 2) {
                        System.out.println("Ticket price: $8");
                        cinc += 8;
                        nopt++;
                        isloop = false;
                        break;
                    } else {
                        System.out.println("Ticket price: $10");
                        cinc += 10;
                        nopt++;
                        isloop = false;
                        break;
                    }
                } else {
                    System.out.println("Ticket price: $10");
                    cinc += 10;
                    nopt++;
                    isloop = false;
                    break;
                }
            }
        }
    }
    
    public void statistcs() {
        System.out.println("Number of purchased tickets: " + nopt);
        int aseats = seats.length * seats[0].length;
        double percnt = 100.0 * nopt / aseats;
        System.out.printf("Percentage: %.2f%%%n", percnt);
        int total = 0;
        if (aseats > 60) {
           total = seats.length / 2 * seats[0].length * 10 + (seats.length / 2 + seats.length % 2) * seats[0].length * 8;
        } else {
            total = aseats * 10;
        }
        System.out.println("Current income: $" + cinc);
        System.out.println("Total income: $" + total);
    }
    
}
