package io.shesh.tracker.dao;

import io.shesh.tracker.model.Alert;
import java.util.List;

/**
 * Created by shesh on 5/28/17.
 */
public interface AlertDao {
     Alert create(Alert alert);
     List<Alert> findAllByVehicle(String id);
     void delete(Alert alert);
     void update(Alert alert);
     List<Alert> findAll();

}
