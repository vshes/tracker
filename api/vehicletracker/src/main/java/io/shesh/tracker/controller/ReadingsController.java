package io.shesh.tracker.controller;

import io.shesh.tracker.model.Readings;
import io.shesh.tracker.model.Alert;
import io.shesh.tracker.service.AlertService;
import io.shesh.tracker.service.ReadingsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by shesh on 5/28/17.
 */
@RestController
@CrossOrigin(origins = {"http://localhost:63342","http://localhost:3000","http://mocker.egen.io"},maxAge = 3600)
@Api(tags = "Readings",description = "Readings End Point")
public class ReadingsController {

    @Autowired
    private ReadingsService readingsService;

    @Autowired
    private AlertService alertService;

    @RequestMapping(method = RequestMethod.GET,value = "readings")
    @ApiOperation(value = "Find all Readings",notes = "Displays all the Readings received for all Vehicles")
    public List<Readings> findAllReadings(){
        return readingsService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET,value = "readings/{vid}")
    @ApiOperation(value = "Find readings for particular VIN",notes = "Displays all the Readings received for for a Vehicle identified by VIN")
    public List<Readings> findReadingsByVehicleId(@PathVariable("vid") String id){
        System.out.println("ID IS"+id);
        return readingsService.findReadingByVehicleId(id);
    }

    @RequestMapping(value = "readings",method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    @ApiOperation(value = "Return the Alerts for Reading Received",notes = "Displays all the Alerts generated for the Reading")

    public List<Alert> create(@RequestBody Readings readings){
        readingsService.create(readings);
        return alertService.createAlertsForReading(readings);
    }

    @RequestMapping(value = "readings",method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    @ApiOperation(value = "Update Readings",notes = "Update the readings")
    public Readings update(@RequestBody Readings readings){
        return   readingsService.update(readings);
    }

    @RequestMapping(value = "reading/{vid}",method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete all Readings for a Vehicle",notes = "Deletes all the Readings received for a Vehicle identified by VIN")

    public void update(@PathVariable("vid") String  id){
        readingsService.delete(id);
    }

}
