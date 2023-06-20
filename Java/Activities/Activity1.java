package activities;

public class Activity1 {

        public static void main(String[] args) {
            Car toyota = new Car();
            toyota.make = 2021;
            toyota.color = "White";
            toyota.transmission = "Automatic";

            //Using Car class method
            toyota.displayCharacterstics();
            toyota.accelerate();
            toyota.brake();

    }
}
