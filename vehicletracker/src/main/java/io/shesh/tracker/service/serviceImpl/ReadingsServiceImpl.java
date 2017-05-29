package io.shesh.tracker.service.serviceImpl;

import io.shesh.tracker.model.Readings;
import io.shesh.tracker.service.ReadingsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shesh on 5/28/17.
 */
@Service
public class ReadingsServiceImpl implements ReadingsService {

    @Override
    public Readings create(Readings readings) {
        return null;
    }

    @Override
    public Readings update(Readings readings) {
        return null;
    }

    @Override
    public void delete(Readings readings) {

    }

    @Override
    public List<Readings> findAll(String id) {
        return null;
    }

    @Override
    public List<Readings> findReadingByVehicleId(String id) {
        return null;
    }
}
