package io.shesh.tracker.service;

import io.shesh.tracker.model.Alert;

import java.util.List;

/**
 * Created by shesh on 5/28/17.
 */
public interface AlertService {
    Alert create(Alert alert);
    List<Alert> findAllByVehicle(String id);
    void delete(Alert alert);
    void update(Alert alert);
    void findById(Alert alert);
}
