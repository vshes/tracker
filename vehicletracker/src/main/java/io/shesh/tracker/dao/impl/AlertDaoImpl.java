package io.shesh.tracker.dao.impl;

import io.shesh.tracker.dao.AlertDao;
import io.shesh.tracker.model.Alert;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by shesh on 5/28/17.
 */
@Repository
public class AlertDaoImpl implements AlertDao{

    @PersistenceContext
   private EntityManager entityManager;

    @Override
    public Alert create(Alert alert) {
        entityManager.persist(alert);
        return alert;
    }

    @Override
    public List<Alert> findAllByVehicle(String id) {

       return entityManager.createNamedQuery("Alert.findByVin").getResultList();


    }

    @Override
    public void delete(Alert alert) {

    }

    @Override
    public void update(Alert alert) {


    }

    @Override
    public List<Alert> findAll() {
        return entityManager.createNamedQuery("Alert.findAll").getResultList();

    }
}
