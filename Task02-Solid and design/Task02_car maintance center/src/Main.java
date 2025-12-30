public class Main {
    public static void main(String[] args) {

        Car car = new Car("Toyota","abc-129");

        // Factory Pattern
        RepairService service = ServiceFactory.createService("oil");

        // Strategy Pattern
        paymentservice payment = new VisaPayment();

        // Notification (SMS + Decorator)
        Notificationservice notify =
                new TimestampNotification(new SMSNotification());

        // Adapter Pattern (استخدام نظام قديم)
        Notificationservice emailNotify =
                new EmailAdapter(new OldEmailSystem());

        // Singleton
        Workshop workshop = Workshop.getInstance();

        // Execute service
        workshop.doService(car, service, payment, notify);

        // Using the adapter
        emailNotify.send("Your invoice is ready.");
    }
}
