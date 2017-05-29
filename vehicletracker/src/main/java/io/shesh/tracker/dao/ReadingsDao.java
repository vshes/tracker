package io.shesh.tracker.dao;

import com.sun.org.apache.regexp.internal.RE;
import io.shesh.tracker.model.Readings;
import java.util.List;
/**
 * Created by shesh on 5/28/17.
 */
public interface ReadingsDao {
    Readings create(Readings readings);
    Readings update(Readings readings);
    void delete(Readings readings);
    List<Readings> findAll(String id);
    List<Readings> findReadingByVehicleId(String id);

}
