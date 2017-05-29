package io.shesh.tracker.dao.impl;

import io.shesh.tracker.dao.VehicleDao;
import io.shesh.tracker.model.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by shesh on 5/28/17.
 */
@Repository


public class VehicleDaoImpl implements VehicleDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Vehicle findById(String id) {
        Query vehicleById =entityManager.createNamedQuery("Vehicle.findById").setParameter("id",id);
            Vehicle vehicle = (Vehicle) vehicleById.getResultList().get(0);
            return  vehicle;
    }

    @Override
    public Vehicle[] create(Vehicle[] vehicle) {
        for(Vehicle v : vehicle)
            entityManager.persist(v);
        return vehicle;
    }

    @Override
    public List<Vehicle> findAll() {

       return entityManager.createNamedQuery("Vehicle.findAll").getResultList();

    }

    @Override
    public Vehicle[] update(Vehicle[] vehicles) {
        for(Vehicle vehicle : vehicles)
        entityManager.merge(vehicle);
        return vehicles;
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        entityManager.persist(vehicle);
        return vehicle;
    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        return entityManager.merge(vehicle);
    }

    @Override
    public void delete(String  id) {
        Query query = entityManager.createNamedQuery("Vehicle.deleteById").setParameter("id",id);
        query.executeUpdate();
    }
}
