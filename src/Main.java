/**
 * Created by daxxon on 9/13/17.
 */
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Scanner;
import java.io.File;

public class Main {

  private static Scanner scanner = new Scanner(System.in);
  //private static ObjectMapper mapper = new ObjectMapper();

  public static void main(String[] args) {

    VehicleInfo danielGolf = new VehicleInfo();

    System.out.print("Enter the Vehicle Identification Number: ");
    danielGolf.setVIN(scanner.nextInt());

    System.out.print("Enter the Odometer reading: ");
    danielGolf.setOdometer(scanner.nextDouble());

    System.out.print("Enter gallons of gase used: ");
    danielGolf.setConsumption(scanner.nextDouble());

    System.out.print("Enter miles since last oil change: ");
    danielGolf.setTripMeter(scanner.nextDouble());

    System.out.print("Enter engine displacement: ");
    danielGolf.setDisplacement(scanner.nextDouble());

    TelematicsService.report(danielGolf);

    ObjectMapper mapper = new ObjectMapper();


    try {

      String json = mapper.writeValueAsString(danielGolf);
      System.out.println(json);

    } catch (JsonProcessingException ex) {

      ex.printStackTrace();

    }
  }
}
