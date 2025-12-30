abstract class Vehicle {
    private String name;
    private int no_of_tyres;

    public void setNo_of_tyres(int no_of_tyres) {
        this.no_of_tyres = no_of_tyres;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNo_of_tyres() {
        return no_of_tyres;
    }
    Vehicle (String name,int wheels){
        this.name = name;
        this.no_of_tyres=wheels;
    }
    abstract void accelrate();
    abstract void brakes();


}
