package week9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface NightServiceCapable {
}

abstract class Cab {
    private static final double MINIMUM_FARE = 100.0;
    private String type;
    private double distance;

    public Cab(String type, double distance) {
        this.type = type;
        this.distance = distance;
    }

    public String getType() {
        return type;
    }

    public double getDistance() {
        return distance;
    }

    public abstract double getRatePerKm();

    public double calculateBaseFare() {
        return Math.max(MINIMUM_FARE, distance * getRatePerKm());
    }

    public double calculateFare(boolean isNight) {
        double base = calculateBaseFare();
        return isNight ? base * 1.20 : base;
    }
}

class MiniCab extends Cab {
    public MiniCab(double distance) {
        super("MINI", distance);
    }

    @Override
    public double getRatePerKm() {
        return 10.0;
    }
}

class SedanCab extends Cab implements NightServiceCapable {
    public SedanCab(double distance) {
        super("SEDAN", distance);
    }

    @Override
    public double getRatePerKm() {
        return 14.0;
    }
}

class SUVCab extends Cab implements NightServiceCapable {
    public SUVCab(double distance) {
        super("SUV", distance);
    }

    @Override
    public double getRatePerKm() {
        return 18.0;
    }
}

class CabBooking {
    private Cab cab;
    private boolean isNight;

    public CabBooking(Cab cab, boolean isNight) {
        this.cab = cab;
        this.isNight = isNight;
    }

    public Cab getCab() {
        return cab;
    }

    public boolean isNight() {
        return isNight;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        List<CabBooking> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double km = scanner.nextDouble();
            String time = scanner.next();
            boolean isNight = time.equalsIgnoreCase("NIGHT");

            Cab cab;
            if (type.equalsIgnoreCase("MINI")) {
                cab = new MiniCab(km);
            } else if (type.equalsIgnoreCase("SEDAN")) {
                cab = new SedanCab(km);
            } else {
                cab = new SUVCab(km);
            }
            bookings.add(new CabBooking(cab, isNight));
        }

        double total = 0.0;
        for (CabBooking booking : bookings) {
            Cab cab = booking.getCab();
            boolean isNight = booking.isNight();

            if (isNight && !(cab instanceof NightServiceCapable)) {
                System.out.printf("%s: night service not available%n", cab.getType());
            } else {
                double fare = cab.calculateFare(isNight);
                System.out.printf("%s: %.2f%n", cab.getType(), fare);
                total += fare;
            }
        }

        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}
