package io.shesh.tracker.dao.impl;

import io.shesh.tracker.dao.ReadingsDao;
import io.shesh.tracker.model.Readings;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by shesh on 5/28/17.
 */
@Repository
public class ReadingsDaoImpl implements ReadingsDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Readings create(Readings readings) {
        entityManager.persist(readings);
        return readings;
    }

    @Override
    public Readings update(Readings readings) {
        entityManager.merge(readings);
        return readings;
    }

    @Override
    public void delete(String vid) {
        Query query = entityManager.createNamedQuery("Readings.deleteByVid").setParameter("vin",vid);
        query.executeUpdate();
    }

    @Override
    public List<Readings> findAll() {
        Query query = entityManager.createNamedQuery("Readings.findByVid");
        return query.getResultList();

    }

    @Override
    public List<Readings> findReadingByVehicleId(String id) {
        Query query = entityManager.createNamedQuery("Readings.findAll").setParameter("vid",id);
        return query.getResultList();


    }
}
