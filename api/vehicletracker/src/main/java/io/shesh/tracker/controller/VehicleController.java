package io.shesh.tracker.controller;

import io.shesh.tracker.exception.ResourceNotFoundException;
import io.shesh.tracker.model.Vehicle;
import io.shesh.tracker.service.VehicleService;
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
@Api(value = "Vehicles", tags = "Vehicles",description = "Vehicles End Point")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @RequestMapping(method = RequestMethod.GET,value = "vehicles")
    @ApiOperation(value = "Find all Vehicles",notes = "Displays all the Vehicles in the DB")

    List<Vehicle>  findAllVehicle(){
        return vehicleService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET,value = "vehicle/{id}")
    @ApiOperation(value = "Find Vehicle By Id",notes = "Displays the Vehicle for the ID provided from the DB")

    Vehicle  findVehicleById(@PathVariable("id") String id){
       Vehicle vehicle =vehicleService.findById(id);
       if(vehicle == null){
           throw new ResourceNotFoundException("Vehicle Not Found");
       }
       else{
           return vehicle;
       }

    }

    @RequestMapping(value = "vehicle",method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    @ApiOperation(value = "Create new Vehicle",notes = "Displays the Vehicle created ")

    Vehicle create(@RequestBody Vehicle vehicle){
        return vehicleService.create(vehicle);
    }

    @RequestMapping(value = "vehicles",method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    @ApiOperation(value = "Update the Vehicle",notes = "Displays the Vehicle Updated ")

    Vehicle[] create(@RequestBody Vehicle[] vehicle){
        return vehicleService.create(vehicle);
    }

    @RequestMapping(value = "vehicles",method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )

    Vehicle[] update(@RequestBody Vehicle[] vehicle){
      return    vehicleService.update(vehicle);
    }

    @RequestMapping(value = "vehicle/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete Vehicle",notes = "Removes the Vehicle identified by VIN ")

    void update(@PathVariable("id") String  id){
        vehicleService.delete(id);
    }

}
