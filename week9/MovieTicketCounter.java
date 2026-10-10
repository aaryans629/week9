package week9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Ticket {
    private static final double CONVENIENCE_FEE = 20.0;
    private String seatType;
    private int count;

    public Ticket(String seatType, int count) {
        this.seatType = seatType;
        this.count = count;
    }

    public String getSeatType() {
        return seatType;
    }

    public int getCount() {
        return count;
    }

    public abstract double getPricePerTicket();

    public double calculateTotal() {
        return (getPricePerTicket() + CONVENIENCE_FEE) * count;
    }
}

class RegularTicket extends Ticket {
    public RegularTicket(int count) {
        super("REGULAR", count);
    }

    @Override
    public double getPricePerTicket() {
        return 150.0;
    }
}

class PremiumTicket extends Ticket {
    public PremiumTicket(int count) {
        super("PREMIUM", count);
    }

    @Override
    public double getPricePerTicket() {
        return 250.0;
    }
}

class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) {
        super("RECLINER", count);
    }

    @Override
    public double getPricePerTicket() {
        return 400.0;
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        List<Ticket> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String seat = scanner.next();
            int count = scanner.nextInt();

            Ticket ticket;
            if (seat.equalsIgnoreCase("REGULAR")) {
                ticket = new RegularTicket(count);
            } else if (seat.equalsIgnoreCase("PREMIUM")) {
                ticket = new PremiumTicket(count);
            } else {
                ticket = new ReclinerTicket(count);
            }
            bookings.add(ticket);
        }

        double grandTotal = 0.0;
        for (Ticket t : bookings) {
            double amount = t.calculateTotal();
            System.out.printf("%s: %.2f%n", t.getSeatType(), amount);
            grandTotal += amount;
        }

        System.out.printf("Total: %.2f%n", grandTotal);
        scanner.close();
    }
}
