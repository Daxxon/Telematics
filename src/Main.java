/**
 * Created by daxxon on 9/13/17.
 */
import com.fasterxml.jackson.core.JsonProcessingException;
// import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Scanner;
import java.io.File;

import static java.lang.String.valueOf;
// import java.io.FileWriter;
// import java.io.IOException;

public class Main {

  private static Scanner scanner = new Scanner(System.in);
  //private static ObjectMapper mapper = new ObjectMapper();

  public static void main(String[] args) {

    VehicleInfo vehicle = new VehicleInfo();

    System.out.print("Enter the Vehicle Identification Number: ");
    vehicle.setVIN(scanner.next());

    System.out.print("Enter the Odometer reading: ");
    vehicle.setOdometer(scanner.nextDouble());

    System.out.print("Enter gallons of gas used: ");
    vehicle.setConsumption(scanner.nextDouble());

    System.out.print("Enter miles since last oil change: ");
    vehicle.setTripMeter(scanner.nextDouble());

    System.out.print("Enter engine displacement: ");
    vehicle.setDisplacement(scanner.nextDouble());

    TelematicsService.report(vehicle);

    TelematicsService.renderAverage("src");
    TelematicsService.renderEachVehicle("src");

    System.out.println("Would you like to enter another vehicle? ");
    System.out.print("y or n: ");
    if (scanner.next().equals("y")) {
      main(args);
    }
  }
}
