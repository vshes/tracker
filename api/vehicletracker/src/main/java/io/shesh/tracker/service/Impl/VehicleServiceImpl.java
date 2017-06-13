package io.shesh.tracker.service.Impl;

import io.shesh.tracker.dao.VehicleDao;
import io.shesh.tracker.model.Vehicle;
import io.shesh.tracker.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by shesh on 5/28/17.
 */
@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    VehicleDao vehicleDao;

    @Override
    public Vehicle findById(String id) {
        return vehicleDao.findById(id);
    }

    @Override
    @Transactional
    public List<Vehicle> findAll() {
        return vehicleDao.findAll();
    }

    @Override
    @Transactional
    public Vehicle[] create(Vehicle[] vehicle) {
        vehicleDao.create(vehicle);
        return new Vehicle[0];
    }

    @Override
    @Transactional
    public Vehicle[] update(Vehicle[] vehicle) {
       return vehicleDao.update(vehicle);
    }

    @Override
    @Transactional
    public Vehicle create(Vehicle vehicle) {
        return vehicleDao.create(vehicle);
    }

    @Override
    @Transactional
    public Vehicle update(Vehicle vehicle) {
        return null;
    }

    @Override
    @Transactional
    public void delete(String id) {
        vehicleDao.delete(id);
    }
}
