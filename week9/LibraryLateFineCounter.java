package week9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class LibraryItem {
    private String type;
    private String title;
    private int daysLate;

    public LibraryItem(String type, String title, int daysLate) {
        this.type = type;
        this.title = title;
        this.daysLate = daysLate;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public int getDaysLate() {
        return daysLate;
    }

    public abstract double calculateFine();
}

class BookItem extends LibraryItem {
    public BookItem(String title, int daysLate) {
        super("BOOK", title, daysLate);
    }

    @Override
    public double calculateFine() {
        return 2.0 * getDaysLate();
    }
}

class DVDItem extends LibraryItem {
    public DVDItem(String title, int daysLate) {
        super("DVD", title, daysLate);
    }

    @Override
    public double calculateFine() {
        return Math.min(50.0, 5.0 * getDaysLate());
    }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title, int daysLate) {
        super("MAGAZINE", title, daysLate);
    }

    @Override
    public double calculateFine() {
        return 1.0 * getDaysLate();
    }
}

public class LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        List<LibraryItem> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String title = scanner.next();
            int daysLate = scanner.nextInt();

            LibraryItem item;
            if (type.equalsIgnoreCase("BOOK")) {
                item = new BookItem(title, daysLate);
            } else if (type.equalsIgnoreCase("DVD")) {
                item = new DVDItem(title, daysLate);
            } else {
                item = new MagazineItem(title, daysLate);
            }
            items.add(item);
        }

        double totalFines = 0.0;
        for (LibraryItem item : items) {
            double fine = item.calculateFine();
            System.out.printf("%s: %.2f%n", item.getTitle(), fine);
            totalFines += fine;
        }

        System.out.printf("Total Fines: %.2f%n", totalFines);
        scanner.close();
    }
}
