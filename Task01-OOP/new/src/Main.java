//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       Car c1 = new Car("mazda",4,true);
       c1.accelrate();
       c1.brakes();
       c1.move_forward(30);
       c1.move_backward(-90);
       c1.shut_all_windows();
        System.out.println("___________________________________");
        Motorcycle m1 = new Motorcycle("harly",2);
        m1.accelrate();
        m1.brakes();
        System.out.println(m1.is_helmet_on(true));
        m1.move_forward(30);
        m1.move_backward(-90);
        System.out.println("_____________________________________");
        Truck t1 = new Truck("MAN",8);
        t1.accelrate();
        t1.brakes();
        t1.move_forward(50);
        t1.move_backward(-90);
        t1.puton(9999);
        t1.puton(999);
    }
}