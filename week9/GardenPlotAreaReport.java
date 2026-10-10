package week9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Plot {
    private String shape;
    private String owner;

    public Plot(String shape, String owner) {
        this.shape = shape;
        this.owner = owner;
    }

    public String getShape() {
        return shape;
    }

    public String getOwner() {
        return owner;
    }

    public abstract double calculateArea();
}

class CirclePlot extends Plot {
    private double radius;

    public CirclePlot(String owner, double radius) {
        super("CIRCLE", owner);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class RectanglePlot extends Plot {
    private double length;
    private double width;

    public RectanglePlot(String owner, double length, double width) {
        super("RECTANGLE", owner);
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

class TrianglePlot extends Plot {
    private double base;
    private double height;

    public TrianglePlot(String owner, double base, double height) {
        super("TRIANGLE", owner);
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

public class GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        List<Plot> plots = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String shape = scanner.next();
            String owner = scanner.next();

            Plot plot;
            if (shape.equalsIgnoreCase("CIRCLE")) {
                double radius = scanner.nextDouble();
                plot = new CirclePlot(owner, radius);
            } else if (shape.equalsIgnoreCase("RECTANGLE")) {
                double length = scanner.nextDouble();
                double width = scanner.nextDouble();
                plot = new RectanglePlot(owner, length, width);
            } else {
                double base = scanner.nextDouble();
                double height = scanner.nextDouble();
                plot = new TrianglePlot(owner, base, height);
            }
            plots.add(plot);
        }

        double totalArea = 0.0;
        for (Plot p : plots) {
            double area = p.calculateArea();
            System.out.printf("%s (%s): %.2f%n", p.getOwner(), p.getShape(), area);
            totalArea += area;
        }

        System.out.printf("Total Area: %.2f%n", totalArea);
        scanner.close();
    }
}
