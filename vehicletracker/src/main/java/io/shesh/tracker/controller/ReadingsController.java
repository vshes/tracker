package io.shesh.tracker.controller;

import io.shesh.tracker.model.Readings;
import io.shesh.tracker.model.Vehicle;
import io.shesh.tracker.service.ReadingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by shesh on 5/28/17.
 */
@RestController
public class ReadingsController {

    @Autowired
    ReadingsService readingsService;

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
    Readings create(@RequestBody Readings readings){
        return readingsService.create(readings);
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
