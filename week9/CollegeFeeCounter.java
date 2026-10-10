package week9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface BusTransportUser {
    default double getTransportFee() {
        return 12000.0;
    }
}

abstract class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateTotalFee();
}

class DayScholarStudent extends Student implements BusTransportUser {
    public DayScholarStudent(String name) {
        super(name);
    }

    @Override
    public double calculateTotalFee() {
        return 40000.0 + getTransportFee();
    }
}

class HostellerStudent extends Student {
    public HostellerStudent(String name) {
        super(name);
    }

    @Override
    public double calculateTotalFee() {
        return 40000.0 + 60000.0;
    }
}

class ScholarshipStudent extends Student implements BusTransportUser {
    public ScholarshipStudent(String name) {
        super(name);
    }

    @Override
    public double calculateTotalFee() {
        return 20000.0 + getTransportFee();
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();

            Student student;
            if (type.equalsIgnoreCase("DAY_SCHOLAR")) {
                student = new DayScholarStudent(name);
            } else if (type.equalsIgnoreCase("HOSTELLER")) {
                student = new HostellerStudent(name);
            } else {
                student = new ScholarshipStudent(name);
            }
            students.add(student);
        }

        double totalCollected = 0.0;
        for (Student s : students) {
            double fee = s.calculateTotalFee();
            System.out.printf("%s: %.2f%n", s.getName(), fee);
            totalCollected += fee;
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);
        scanner.close();
    }
}
