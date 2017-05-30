package io.shesh.tracker.service;

import io.shesh.tracker.model.Alert;
import io.shesh.tracker.model.Readings;

import java.util.List;

/**
 * Created by shesh on 5/28/17.
 */
public interface AlertService {
    List<Alert> createAlertsForReading(Readings readings);
    List<Alert> findAllByVehicle(String id);
    void delete(String vin);
    void update(Alert alert);
    Alert findById(String id);
    List<Alert> findAll();
}
