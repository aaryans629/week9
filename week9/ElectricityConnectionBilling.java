package week9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class ElectricityConnection {
    private String type;
    private double units;

    public ElectricityConnection(String type, double units) {
        this.type = type;
        this.units = units;
    }

    public String getType() {
        return type;
    }

    public double getUnits() {
        return units;
    }

    public abstract double calculateBill();
}

class HomeConnection extends ElectricityConnection {
    public HomeConnection(double units) {
        super("HOME", units);
    }

    @Override
    public double calculateBill() {
        if (getUnits() <= 100.0) {
            return getUnits() * 5.0;
        } else {
            return (100.0 * 5.0) + ((getUnits() - 100.0) * 7.0);
        }
    }
}

class ShopConnection extends ElectricityConnection {
    public ShopConnection(double units) {
        super("SHOP", units);
    }

    @Override
    public double calculateBill() {
        return (getUnits() * 8.0) + 100.0;
    }
}

class FactoryConnection extends ElectricityConnection {
    public FactoryConnection(double units) {
        super("FACTORY", units);
    }

    @Override
    public double calculateBill() {
        return Math.max(1000.0, getUnits() * 6.0);
    }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        List<ElectricityConnection> connections = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double units = scanner.nextDouble();

            ElectricityConnection conn;
            if (type.equalsIgnoreCase("HOME")) {
                conn = new HomeConnection(units);
            } else if (type.equalsIgnoreCase("SHOP")) {
                conn = new ShopConnection(units);
            } else {
                conn = new FactoryConnection(units);
            }
            connections.add(conn);
        }

        double total = 0.0;
        for (ElectricityConnection conn : connections) {
            double bill = conn.calculateBill();
            System.out.printf("%s: %.2f%n", conn.getType(), bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}
