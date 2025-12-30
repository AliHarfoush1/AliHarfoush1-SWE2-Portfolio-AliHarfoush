// =====================================================
// SOLID Principles: Library Management System
// =====================================================

// =====================================================
// S - Single Responsibility Principle
// Each class has ONE responsibility
// =====================================================

class Book {
    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}

// =====================================================
// I - Interface Segregation
// Small, focused interfaces
// =====================================================

interface Notifiable {
    void sendNotification(String message);
}

interface Borrowable {
    void borrowBook(Book book);
    void returnBook(Book book);
}

// =====================================================
// O - Open/Closed & L - Liskov Substitution
// Can add new user types without modifying existing code
// =====================================================

abstract class User implements Borrowable {
    protected String name;
    protected String id;

    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() { return name; }
    public String getId() { return id; }
}

class Student extends User {
    public Student(String name, String id) {
        super(name, id);
    }

    @Override
    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Student " + name + " borrowed: " + book.getTitle());
        }
    }

    @Override
    public void returnBook(Book book) {
        book.setAvailable(true);
        System.out.println("Student " + name + " returned: " + book.getTitle());
    }
}

class Teacher extends User {
    public Teacher(String name, String id) {
        super(name, id);
    }

    @Override
    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Teacher " + name + " borrowed: " + book.getTitle());
        }
    }

    @Override
    public void returnBook(Book book) {
        book.setAvailable(true);
        System.out.println("Teacher " + name + " returned: " + book.getTitle());
    }
}

// =====================================================
// O - Open/Closed
// Can add new notification methods easily
// =====================================================

class EmailNotifier implements Notifiable {
    @Override
    public void sendNotification(String message) {
        System.out.println("📧 Email: " + message);
    }
}

class SMSNotifier implements Notifiable {
    @Override
    public void sendNotification(String message) {
        System.out.println("📱 SMS: " + message);
    }
}

// =====================================================
// D - Dependency Inversion
// Library depends on interfaces, not concrete classes
// =====================================================

class Library {
    private String name;
    private Notifiable notifier;

    public Library(String name, Notifiable notifier) {
        this.name = name;
        this.notifier = notifier;
    }

    public void processReturn(User user, Book book) {
        user.returnBook(book);
        notifier.sendNotification(user.getName() + " returned " + book.getTitle());
    }

    public void processBorrow(User user, Book book) {
        user.borrowBook(book);
        notifier.sendNotification(user.getName() + " borrowed " + book.getTitle());
    }
}

// =====================================================
// S - Single Responsibility
// Report generation is separate responsibility
// =====================================================

class ReportGenerator {
    public void generateReport(Book[] books) {
        System.out.println("\n=== Library Report ===");
        for (Book book : books) {
            System.out.println(book.getTitle() + " - " +
                    (book.isAvailable() ? "Available" : "Borrowed"));
        }
    }
}

// =====================================================
// Main - Demo
// =====================================================

public class LibrarySystemm {
    public static void main(String[] args) {
        System.out.println("=== SOLID Principles Demo ===\n");

        // Create books
        Book book1 = new Book("Clean Code", "Robert Martin");
        Book book2 = new Book("Design Patterns", "Gang of Four");

        // D - Dependency Inversion: use interface
        Notifiable emailNotifier = new EmailNotifier();
        Library library = new Library("City Library", emailNotifier);

        // L - Liskov Substitution: any user type works
        User student = new Student("Ahmed", "S001");
        User teacher = new Teacher("Dr. Sara", "T001");

        // Process borrowing
        library.processBorrow(student, book1);
        library.processBorrow(teacher, book2);

        System.out.println();

        // Process returns
        library.processReturn(student, book1);

        // O - Open/Closed: easily switch notifier
        System.out.println("\n--- Switching to SMS ---");
        Notifiable smsNotifier = new SMSNotifier();
        Library library2 = new Library("City Library", smsNotifier);
        library2.processReturn(teacher, book2);

        // S - Single Responsibility: separate report
        ReportGenerator reporter = new ReportGenerator();
        Book[] books = {book1, book2};
        reporter.generateReport(books);

        System.out.println("\n=== SOLID Principles Applied ===");
        System.out.println("✓ S: Each class has one job");
        System.out.println("✓ O: Can add new users/notifiers easily");
        System.out.println("✓ L: Student/Teacher interchangeable");
        System.out.println("✓ I: Small focused interfaces");
        System.out.println("✓ D: Library uses interfaces not concrete classes");
    }
}