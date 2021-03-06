package io.shesh.tracker.dao;

/**
 * Created by shesh on 5/28/17.
 */
import io.shesh.tracker.model.Vehicle;
import java.util.List;

public interface VehicleDao {

     Vehicle findById(String id);
     List<Vehicle> findAll();
     Vehicle create(Vehicle vehicle);
     Vehicle update(Vehicle vehicle);
     void delete(String id);
     Vehicle[] create(Vehicle[] vehicle);
     Vehicle[] update(Vehicle[] vehicle);
     float findvehiceFuelVolume(String vin);
     int findvehicleRedlineRpm(String vin);
}
