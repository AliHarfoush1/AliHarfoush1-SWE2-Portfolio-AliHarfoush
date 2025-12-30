public class Truck extends Vehicle implements move {


    @Override
    public void move_forward(int x) {
        System.out.println("truck is moving forward by "+ x);

    }

    @Override
    public void move_backward(float x) {
        System.out.println("truck is moving backward by "+ x);

    }

    Truck(String name, int wheels) {
        super(name, wheels);
    }

    @Override
    void accelrate() {
        System.out.println("truck is moving");
    }

    @Override
    void brakes() {
        System.out.println("truck is stopping");
    }
    int max_weight = 1000;
    void puton (int weight){
      if (weight>max_weight)
        System.out.println("can't puton this");
      else
          System.out.println("cargo is carrying "+weight+"KG");
    }
}
