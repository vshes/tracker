package io.shesh.tracker.controller;

import io.shesh.tracker.model.Alert;
import io.shesh.tracker.model.Readings;
import io.shesh.tracker.service.AlertService;
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
@Api(tags = "Alerts",description = "Alerts End Point")
public class AlertController {

    @Autowired
    private AlertService alertService;

    @RequestMapping(method = RequestMethod.GET,value = "alerts/{vin}")
    @ApiOperation(value = "Find all Alerts by VIN",notes = "Displays the Alerts generated for Vehicles breaking the threshold")
    List<Alert> findAllByVehicleId(@PathVariable("vin") String id){
        return alertService.findAllByVehicle(id);
    }

    @RequestMapping(method = RequestMethod.GET,value = "alerts")
    @ApiOperation(value = "Find all Alerts in DB",notes = "Displays the Alerts generated for all Vehicles breaking the threshold")

    List<Alert> findAll(){
        return alertService.findAll();
    }

    @ApiOperation(value = "Update Alerts",notes = "Displays the Alerts generated for Vehicles breaking the threshold")
    @RequestMapping(value = "alerts",method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    void update(@RequestBody Alert alert){
        alertService.update(alert);
    }

    @RequestMapping(value = "alert/{vid}",method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete the Alert for VIN",notes = "Deletes all Alerts for the Given VIN")

    void delete(@PathVariable("vid") String  id){
        alertService.delete(id);
    }

}
