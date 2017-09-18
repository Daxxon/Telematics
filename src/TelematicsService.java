/**
 * Created by daxxon on 9/13/17.
 */
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TelematicsService {

  public static void report (VehicleInfo vehicle) {
    // System.out.println("VIN: " + vehicleInfo.getVIN() + "\n" + "ODO: " + vehicleInfo.getOdometer() + "\n" + "Gas used: " + vehicleInfo.getConsumption() + "\n" + "Trip: " + vehicleInfo.getTripMeter() + "\n" + "Displacement: " + vehicleInfo.getDisplacement() + "L" + "\n");
    ObjectMapper mapper = new ObjectMapper();

    try {
      System.out.println(mapper.writeValueAsString(vehicle));
      File file = new File("./src/" + vehicle.getVIN() + ".json");
      FileWriter fileWriter = new FileWriter(file);
      fileWriter.write(mapper.writeValueAsString(vehicle));
      fileWriter.close();
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }

  public static void renderAverage (String myDirectory) {
    ObjectMapper mapper = new ObjectMapper();
    double averageOdometer = 0;
    double averageConsumption = 0;
    double averageTripMeter = 0;
    double averageDisplacement = 0;
    int vehicleCounter = 0;
    File folder = new File(myDirectory);

    try {
      FileWriter fileWriter = new FileWriter("src/index.html", false);
      for (File jsonFile : folder.listFiles()) {
        if (jsonFile.getName().endsWith(".json")) {
          System.out.println("found file: " + jsonFile.getName());
          VehicleInfo vehicle = mapper.readValue(jsonFile, VehicleInfo.class);
          averageOdometer += vehicle.getOdometer();
          averageConsumption += vehicle.getConsumption();
          averageTripMeter += vehicle.getTripMeter();
          averageDisplacement += vehicle.getDisplacement();
          vehicleCounter++;
        }
      }
      fileWriter.write("<html>\n\t<title>Vehicle Telematics Dashboard</title>\n\t<body>\n\t\t<h1 align=\"center\">Averages for # vehicles</h1>\n\t\t<table align=\"center\">\n\t\t\t<tr>\n\t\t\t\t<th>Odometer (miles) |</th><th>Consumption (gallons) |</th><th>Last Oil Change |</th><th>Engine Size (liters)</th>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td align=\"center\">" + averageOdometer/vehicleCounter + "</td><td align=\"center\">" + averageConsumption/vehicleCounter + "</td><td align=\"center\">" + averageTripMeter/vehicleCounter + "</td align=\"center\"><td align=\"center\">" + averageDisplacement/vehicleCounter + "</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t<h1 align=\"center\">History</h1>\n\t\t<table align=\"center\" border=\"1\">\n\t\t\t<tr>\n\t\t\t\t<th>VIN</th><th>Odometer (miles)</th><th>Consumption (gallons)</th><th>Last Oil Change</th><th>Engine Size (liters)</th>\n\t\t\t</tr>");
      fileWriter.close();
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }

  public static void renderEachVehicle (String myDirectory) {
    ObjectMapper mapper = new ObjectMapper();
    File folder = new File(myDirectory);

    try {
      FileWriter fileWriter = new FileWriter("src/index.html", true);
      for (File jsonFile : folder.listFiles()) {
        if (jsonFile.getName().endsWith(".json")) {
          VehicleInfo vehicle = mapper.readValue(jsonFile, VehicleInfo.class);
          fileWriter.write("\n\t\t\t<tr>\n\t\t\t\t<td align=\"center\">" + vehicle.getVIN() + "</td><td align=\"center\">" + vehicle.getOdometer() + "</td><td align=\"center\">" + vehicle.getConsumption() + "</td><td align=\"center\">" + vehicle.getTripMeter() + "</td align=\"center\"><td align=\"center\">" + vehicle.getDisplacement() + "</td>\n\t\t\t</tr>");
        }
      }
      fileWriter.write("\n\t\t</table>\n\t</body></html>");
      fileWriter.close();
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }
}
