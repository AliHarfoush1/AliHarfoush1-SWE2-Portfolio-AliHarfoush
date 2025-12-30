class MaintenanceService {
    private Car car;
    private RepairService service;
    private paymentservice payment;
    private Notificationservice notification;

    public MaintenanceService(Car car, RepairService service,
                              paymentservice payment, Notificationservice notification) {
        this.car = car;
        this.service = service;
        this.payment = payment;
        this.notification = notification;
    }

    public void complete() {
        System.out.println("\nRepair Order");
        System.out.println("Car: " + car.getModel());

        service.perform(car);
        payment.pay(service.getCost());
        notification.send("Your car is ready!");
    }
}