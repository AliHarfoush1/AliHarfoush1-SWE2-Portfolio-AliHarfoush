public interface RepairService {
    double getCost();
    String getDescription();
    void perform(Car car);
}
 class oilchange implements RepairService{
    public String getDescription (){ return "oil change";}
    public double getCost(){return 200;};
    public void perform(Car car) {
        System.out.println("Changing oil for " + car.getPlate());
    }
}
 class tirecheck implements RepairService{
    public String getDescription (){ return "tire check";}
    public double getCost(){return 50;};
    public void perform(Car car) {
        System.out.println("Checking tires for " + car.getPlate());
    }
}
class ServiceFactory {
    public static RepairService createService(String type) {
        switch (type.toLowerCase()) {
            case "oil": return new oilchange();
            case "tire": return new tirecheck();
            default: throw new IllegalArgumentException("Unknown service type");
        }
    }
}