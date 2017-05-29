package io.shesh.tracker.service.serviceImpl;

import io.shesh.tracker.model.Alert;
import io.shesh.tracker.service.AlertService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shesh on 5/28/17.
 */
@Service
public class AlertServiceImpl implements AlertService{

    @Override
    public Alert create(Alert alert) {
        return null;
    }

    @Override
    public List<Alert> findAllByVehicle(String id) {
        return null;
    }

    @Override
    public void delete(Alert alert) {

    }

    @Override
    public void update(Alert alert) {

    }

    @Override
    public void findById(Alert alert) {

    }
}
