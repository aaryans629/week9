package week9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Staff {
    private String name;

    public Staff(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculatePay();
}

class FullTimeStaff extends Staff {
    private double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    @Override
    public double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends Staff {
    private double hours;
    private double rate;

    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    public double getHours() {
        return hours;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public double calculatePay() {
        if (hours <= 40.0) {
            return hours * rate;
        } else {
            return (40.0 * rate) + ((hours - 40.0) * 1.5 * rate);
        }
    }
}

class InternStaff extends Staff {
    private double stipend;

    public InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    public double getStipend() {
        return stipend;
    }

    @Override
    public double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        List<Staff> staffList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();

            Staff staff;
            if (type.equalsIgnoreCase("FULLTIME")) {
                double salary = scanner.nextDouble();
                staff = new FullTimeStaff(name, salary);
            } else if (type.equalsIgnoreCase("HOURLY")) {
                double hours = scanner.nextDouble();
                double rate = scanner.nextDouble();
                staff = new HourlyStaff(name, hours, rate);
            } else {
                double stipend = scanner.nextDouble();
                staff = new InternStaff(name, stipend);
            }
            staffList.add(staff);
        }

        double totalPayroll = 0.0;
        for (Staff s : staffList) {
            double pay = s.calculatePay();
            System.out.printf("%s: %.2f%n", s.getName(), pay);
            totalPayroll += pay;
        }

        System.out.printf("Total Payroll: %.2f%n", totalPayroll);
        scanner.close();
    }
}
