package io.shesh.tracker.controller;

import io.shesh.tracker.model.Readings;
import io.shesh.tracker.model.Alert;
import io.shesh.tracker.service.AlertService;
import io.shesh.tracker.service.ReadingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by shesh on 5/28/17.
 */
@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
public class ReadingsController {

    @Autowired
    ReadingsService readingsService;

    @Autowired
    AlertService alertService;



    @RequestMapping(method = RequestMethod.GET,value = "readings")
    List<Readings> findAllReadings(){
        return readingsService.findAll();
    }
    @RequestMapping(method = RequestMethod.GET,value = "readings/{vid}")
    List<Readings> findReadingsByVehicleId(@PathVariable("vid") String id){
        System.out.println("ID IS"+id);
        return readingsService.findReadingByVehicleId(id);
    }

    @RequestMapping(value = "readings",method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    List<Alert> create(@RequestBody Readings readings){
        readingsService.create(readings);
        return alertService.createAlertsForReading(readings);
    }

    @RequestMapping(value = "readings",method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    Readings update(@RequestBody Readings readings){
        return   readingsService.update(readings);
    }

    @RequestMapping(value = "reading/{vid}",method = RequestMethod.DELETE)
    void update(@PathVariable("vid") String  id){
        readingsService.delete(id);
    }

}
