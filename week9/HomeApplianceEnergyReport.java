package week9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface SaverModeCapable {
}

abstract class Appliance {
    private String type;
    private double hours;

    public Appliance(String type, double hours) {
        this.type = type;
        this.hours = hours;
    }

    public String getType() {
        return type;
    }

    public double getHours() {
        return hours;
    }

    public abstract double getPowerRating();

    public double calculateUnits(boolean saver) {
        double units = (getPowerRating() * hours) / 1000.0;
        if (saver) {
            units *= 0.75;
        }
        return units;
    }

    public double calculateCost(double units) {
        return units * 8.0;
    }
}

class FridgeAppliance extends Appliance {
    public FridgeAppliance(double hours) {
        super("FRIDGE", hours);
    }

    @Override
    public double getPowerRating() {
        return 150.0;
    }
}

class ACAppliance extends Appliance implements SaverModeCapable {
    public ACAppliance(double hours) {
        super("AC", hours);
    }

    @Override
    public double getPowerRating() {
        return 1500.0;
    }
}

class TVAppliance extends Appliance {
    public TVAppliance(double hours) {
        super("TV", hours);
    }

    @Override
    public double getPowerRating() {
        return 100.0;
    }
}

class WasherAppliance extends Appliance implements SaverModeCapable {
    public WasherAppliance(double hours) {
        super("WASHER", hours);
    }

    @Override
    public double getPowerRating() {
        return 500.0;
    }
}

class ApplianceRequest {
    private Appliance appliance;
    private boolean saverRequested;

    public ApplianceRequest(Appliance appliance, boolean saverRequested) {
        this.appliance = appliance;
        this.saverRequested = saverRequested;
    }

    public Appliance getAppliance() {
        return appliance;
    }

    public boolean isSaverRequested() {
        return saverRequested;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) {
            scanner.close();
            return;
        }

        String firstLine = scanner.nextLine().trim();
        while (firstLine.isEmpty() && scanner.hasNextLine()) {
            firstLine = scanner.nextLine().trim();
        }
        if (firstLine.isEmpty()) {
            scanner.close();
            return;
        }

        int n = Integer.parseInt(firstLine);
        List<ApplianceRequest> requests = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextLine()) break;
            String line = scanner.nextLine().trim();
            while (line.isEmpty() && scanner.hasNextLine()) {
                line = scanner.nextLine().trim();
            }

            String[] tokens = line.split("\\s+");
            if (tokens.length < 2) continue;

            String type = tokens[0];
            double hours = Double.parseDouble(tokens[1]);
            boolean saver = tokens.length > 2 && tokens[2].equalsIgnoreCase("SAVER");

            Appliance appliance;
            if (type.equalsIgnoreCase("FRIDGE")) {
                appliance = new FridgeAppliance(hours);
            } else if (type.equalsIgnoreCase("AC")) {
                appliance = new ACAppliance(hours);
            } else if (type.equalsIgnoreCase("TV")) {
                appliance = new TVAppliance(hours);
            } else {
                appliance = new WasherAppliance(hours);
            }
            requests.add(new ApplianceRequest(appliance, saver));
        }

        double totalCost = 0.0;
        for (ApplianceRequest req : requests) {
            Appliance a = req.getAppliance();
            boolean saver = req.isSaverRequested();

            if (saver && !(a instanceof SaverModeCapable)) {
                System.out.printf("%s: saver mode not supported%n", a.getType());
            } else {
                double units = a.calculateUnits(saver);
                double cost = a.calculateCost(units);
                System.out.printf("%s: Units=%.2f Cost=%.2f%n", a.getType(), units, cost);
                totalCost += cost;
            }
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        scanner.close();
    }
}
