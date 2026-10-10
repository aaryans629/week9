package week9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class TravelBooking {
    private static final double BOOKING_FEE = 50.0;
    private String mode;
    private double distanceKm;

    public TravelBooking(String mode, double distanceKm) {
        this.mode = mode;
        this.distanceKm = distanceKm;
    }

    public String getMode() {
        return mode;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    public abstract double calculateBaseFare();

    public double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {
    public BusBooking(double distanceKm) {
        super("BUS", distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return 2.0 * getDistanceKm();
    }
}

class TrainBooking extends TravelBooking {
    public TrainBooking(double distanceKm) {
        super("TRAIN", distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return 1.5 * getDistanceKm();
    }
}

class FlightBooking extends TravelBooking {
    public FlightBooking(double distanceKm) {
        super("FLIGHT", distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return 2500.0 + (4.0 * getDistanceKm());
    }
}

public class TravelBookingWithCommonFee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        List<TravelBooking> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String mode = scanner.next();
            double distanceKm = scanner.nextDouble();

            TravelBooking booking;
            if (mode.equalsIgnoreCase("BUS")) {
                booking = new BusBooking(distanceKm);
            } else if (mode.equalsIgnoreCase("TRAIN")) {
                booking = new TrainBooking(distanceKm);
            } else {
                booking = new FlightBooking(distanceKm);
            }
            bookings.add(booking);
        }

        for (TravelBooking b : bookings) {
            double total = b.calculateTotalFare();
            System.out.printf("%s: %.2f%n", b.getMode(), total);
        }

        scanner.close();
    }
}
