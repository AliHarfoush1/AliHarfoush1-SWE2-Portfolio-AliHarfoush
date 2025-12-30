  class Car extends Vehicle implements move{

      boolean  is_diesel ;
      Car(String name, int wheels,boolean diesel) {
          super(name, wheels);
          this.is_diesel=diesel ;
      }

      @Override
      void accelrate() {
          System.out.println("car is moving");
      }

      @Override
      void brakes() {
          System.out.println("car is stopping");
      }
      public void shut_all_windows()
      {
          System.out.println("all windows are shutting");
      }

      @Override
      public void move_forward(int x) {
          System.out.println("Car is moving forward by " + x);
      }

      @Override
      public void move_backward(float x) {
          System.out.println("car moving backward by "+x);
      }
  }
