/**
 * Created by daxxon on 9/13/17.
 */
public class TelematicsService {

  public static void report (VehicleInfo vehicleInfo) {
    System.out.println("VIN: " + vehicleInfo.getVIN() + "\n" + "ODO: " + vehicleInfo.getOdometer() + "\n" + "Gas used: " + vehicleInfo.getConsumption() + "\n" + "Trip: " + vehicleInfo.getTripMeter() + "\n" + "Displacement: " + vehicleInfo.getDisplacement() + "L" + "\n");
  }
}
