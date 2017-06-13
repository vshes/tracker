package io.shesh.tracker.service;

import io.shesh.tracker.model.Readings;

import java.util.List;

/**
 * Created by shesh on 5/28/17.
 */
public interface ReadingsService {
    Readings create(Readings readings);
    Readings update(Readings readings);
    void delete(String id);
    List<Readings> findReadingByVehicleId(String id);
    List<Readings> findAll();
}
