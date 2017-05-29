package io.shesh.tracker.dao;

/**
 * Created by shesh on 5/28/17.
 */
import io.shesh.tracker.model.Vehicle;
import java.util.List;

public interface VehicleDao {

     Vehicle findById();
     List<Vehicle> findAll();
     Vehicle create(Vehicle vehicle);
     Vehicle update(Vehicle vehicle);
     Vehicle delete(Vehicle vehicle);

}
