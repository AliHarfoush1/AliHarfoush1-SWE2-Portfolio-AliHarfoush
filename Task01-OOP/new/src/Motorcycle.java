public class Motorcycle extends Vehicle implements move{

    Motorcycle(String name, int wheels) {
        super(name, wheels);
    }

    @Override
    void accelrate() {
        System.out.println("bike is moving");
    }
    @Override
    void brakes() {
        System.out.println("bike is stopping");
    }

    @Override
    public void move_forward(int x) {
        System.out.println("bike is moving forward by "+ x);
    }

    @Override
    public void move_backward(float x) {
        System.out.println("bike is moving backward");
    }
    boolean is_helmet_on(boolean x)
    {
        return x == true ;
    }
}
