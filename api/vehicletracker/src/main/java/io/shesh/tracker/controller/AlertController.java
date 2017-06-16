package io.shesh.tracker.controller;

import io.shesh.tracker.model.Alert;
import io.shesh.tracker.model.Readings;
import io.shesh.tracker.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by shesh on 5/28/17.
 */
@RestController
@CrossOrigin(origins = {"http://localhost:63342","http://localhost:3000","http://mocker.egen.io"},maxAge = 3600)

public class AlertController {

    @Autowired
    private AlertService alertService;

    @RequestMapping(method = RequestMethod.GET,value = "alerts/{vin}")
    List<Alert> findAllByVehicleId(@PathVariable("vin") String id){
        return alertService.findAllByVehicle(id);
    }

//    @RequestMapping(method = RequestMethod.GET,value = "alerts/{aid}")
//    Alert findAll(@PathVariable("aid") String id){
//        return alertService.findById(id);
//    }

    @RequestMapping(method = RequestMethod.GET,value = "alerts")
    List<Alert> findAll(){
        return alertService.findAll();
    }

    @RequestMapping(value = "alerts",method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    void update(@RequestBody Alert alert){
        alertService.update(alert);
    }

    @RequestMapping(value = "alert/{vid}",method = RequestMethod.DELETE)
    void update(@PathVariable("vid") String  id){
        alertService.delete(id);
    }

}
