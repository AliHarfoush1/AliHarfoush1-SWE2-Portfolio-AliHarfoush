public class Workshop {
    private static Workshop instance;

    private Workshop() {}

    public static Workshop getInstance() {
        if (instance == null) {
            instance = new Workshop();
        }
        return instance;
    }

    public void doService(Car car, RepairService service, paymentservice payment, Notificationservice notify) {
        System.out.println("Doing: " + service.getDescription() + " for car: " + car.getModel()+car.getPlate());
        payment.pay(service.getCost());
        notify.send("Your car service (" + service.getDescription() + ") is finished!");
    }
}
