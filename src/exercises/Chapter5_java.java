package exercises;

public class Chapter5_java {
//    java implementation of Chapter5.Car, #8, Car class
    public static class Car {
      public final String make;
      public final String model;
      public final Integer year;
      public String plate = "";

      // defaults
      private final static Integer DEF_MODEL_YEAR = -1;
      private final static String DEF_PLATE = "";

      // constructors
      public Car(String make, String model, Integer year, String plate) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.plate = plate;
      }

      // no plate given
      public Car(String make, String model, String plate) {
        this(make, model, DEF_MODEL_YEAR, plate);
      }

      // no year given
      public Car(String make, String model, Integer year) {
        this(make, model, year, DEF_PLATE);
      }

      // year & plate both missing
      public Car(String make, String model) {
        this(make, model, DEF_MODEL_YEAR, DEF_PLATE);
      }

      @Override
      public String toString() {
        return "Make: " + make + "\nModel: " + model + "\nYear: " + year + "\nPlate: " + plate;
      }
    }
}
