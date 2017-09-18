import java.io.Serializable;

/**
 * Created by daxxon on 9/13/17.
 */
public class VehicleInfo implements Serializable {
  private String VIN;
  private double odometer;
  private double consumption;
  private double tripMeter;
  private double displacement;

  public VehicleInfo () {
  }

  public String getVIN () {
    return this.VIN;
  }

  public void setVIN(String VIN) {
    this.VIN = VIN;
  }

  public double getOdometer() {
    return this.odometer;
  }

  public void setOdometer(double odometer) {
    this.odometer = odometer;
  }

  public double getConsumption() {
    return this.consumption;
  }

  public void setConsumption(double consumption) {
    this.consumption = consumption;
  }

  public double getTripMeter() {
    return this.tripMeter;
  }

  public void setTripMeter(double tripMeter) {
    this.tripMeter = tripMeter;
  }

  public double getDisplacement() {
    return this.displacement;
  }

  public void setDisplacement(double displacement) {
    this.displacement = displacement;
  }
}



