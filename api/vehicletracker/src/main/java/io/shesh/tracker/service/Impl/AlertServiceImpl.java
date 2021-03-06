package io.shesh.tracker.service.Impl;

import io.shesh.tracker.dao.AlertDao;
import io.shesh.tracker.dao.VehicleDao;
import io.shesh.tracker.model.Alert;
import io.shesh.tracker.model.Readings;
import io.shesh.tracker.service.AlertService;
import io.shesh.tracker.utils.AlertMsgType;
import io.shesh.tracker.utils.JavaMailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shesh on 5/28/17.
 */
@Service
public class AlertServiceImpl implements AlertService{

    @Autowired
    private AlertDao alertDao;

    @Autowired
    private VehicleDao vehicleDao;

    @Autowired
    private JavaMailerService javaMailerService;

    public Alert create(Alert alert) {
        return null;
    }



    @Override
    public List<Alert> findAllByVehicle(String id) {
        return alertDao.findAllByVehicle(id);
    }

    @Override
    public void delete(String vin) {

    }

    @Override
    public Alert findById(String id) {
        return null;
    }

    @Override
    public List<Alert> findAll() {
        return alertDao.findAll();
    }

    @Override
    @Transactional
    public List<Alert> createAlertsForReading(Readings readings) {

        List<Alert> alerts = createAlerts(readings);
        javaMailerService.send(alerts,readings.getVin());
        return alerts;

    }

    @Override
    public void update(Alert alert) {

    }


    @Transactional
    private List<Alert> createAlerts(Readings readings){
        List<Alert> alerts = new ArrayList<>();

        if(readings.isCheckEngineLightOn()){
            Alert alert = new Alert();
            alert.setAlertmsg(AlertMsgType.CHECK_ENGINE_LIGHT.getAlertMsg());
            alert.setVin(readings.getVin());
            alert.setPriority("LOW");
            alert.setLatitude(readings.getLatitude());
            alert.setLongitude(readings.getLongitude());
            alert.setTimestamp(new Timestamp(System.currentTimeMillis()));
            alertDao.create(alert);
            alerts.add(alert);
            System.out.println(alert.toString());
        }
        if(readings.isEngineCoolantLow()){
            Alert alert = new Alert();
            alert.setLatitude(readings.getLatitude());
            alert.setLongitude(readings.getLongitude());
            alert.setAlertmsg(AlertMsgType.LOW_COOLANT_ALERT.getAlertMsg());
            alert.setVin(readings.getVin());
            alert.setPriority("LOW");
            alert.setTimestamp(new Timestamp(System.currentTimeMillis()));
            alertDao.create(alert);
            alerts.add(alert);
            System.out.println(alert.toString());
        }
        if((readings.getTires().getFrontLeft() < 32 ) || (readings.getTires().getFrontLeft() > 36)){
            Alert alert = new Alert();
            alert.setLatitude(readings.getLatitude());
            alert.setLongitude(readings.getLongitude());
            alert.setAlertmsg(AlertMsgType.PRESSURE_FRONTLEFT_TYRE_ALERT.getAlertMsg());
            alert.setVin(readings.getVin());
            alert.setPriority("LOW");
            alert.setTimestamp(new Timestamp(System.currentTimeMillis()));
            alertDao.create(alert);
            alerts.add(alert);
            System.out.println("Alert Mail sent !");
            System.out.println(alert.toString());
        }
        if((readings.getTires().getFrontRight() < 32 ) || (readings.getTires().getFrontRight() > 36)){
            Alert alert = new Alert();
            alert.setLatitude(readings.getLatitude());
            alert.setLongitude(readings.getLongitude());
            alert.setAlertmsg(AlertMsgType.PRESSURE_FRONTRIGHT_TYRE_ALERT.getAlertMsg());
            alert.setVin(readings.getVin());
            alert.setPriority("LOW");
            alert.setTimestamp(new Timestamp(System.currentTimeMillis()));
            alertDao.create(alert);
            alerts.add(alert);
            System.out.println("Alert Mail sent !");
            System.out.println(alert.toString());
        }
        if((readings.getTires().getRearLeft() < 32 ) || (readings.getTires().getRearLeft() > 36)){
            Alert alert = new Alert();
            alert.setLatitude(readings.getLatitude());
            alert.setLongitude(readings.getLongitude());
            alert.setAlertmsg(AlertMsgType.PRESSURE_BACKLEFT_TYRE_ALERT.getAlertMsg());
            alert.setVin(readings.getVin());
            alert.setPriority("LOW");
            alert.setTimestamp(new Timestamp(System.currentTimeMillis()));
            alertDao.create(alert);
            alerts.add(alert);
            System.out.println("Alert Mail sent !");
            System.out.println(alert.toString());
        }
        if((readings.getTires().getRearRight() < 32 ) || (readings.getTires().getRearRight() > 36)){
            Alert alert = new Alert();
            alert.setLatitude(readings.getLatitude());
            alert.setLongitude(readings.getLongitude());
            alert.setAlertmsg(AlertMsgType.PRESSURE_BACKRIGHT_TYRE_ALERT.getAlertMsg());
            alert.setVin(readings.getVin());
            alert.setPriority("LOW");
            alert.setTimestamp(new Timestamp(System.currentTimeMillis()));
            alertDao.create(alert);
            alerts.add(alert);
            System.out.println(alert.toString());
        }
        if((readings.getEngineRpm() > vehicleDao.findById(readings.getVin()).getRedlineRpm())){
            Alert alert = new Alert();
            alert.setLatitude(readings.getLatitude());
            alert.setLongitude(readings.getLongitude());
            alert.setAlertmsg(AlertMsgType.HIGH_REDLINERPM_ALERT.getAlertMsg());
            alert.setVin(readings.getVin());
            alert.setPriority("HIGH");
            alert.setTimestamp(new Timestamp(System.currentTimeMillis()));
            alertDao.create(alert);
            alerts.add(alert);
            System.out.println("Alert Mail sent !");
            System.out.println(alert.toString());
        }

        if((( readings.getFuelVolume() / vehicleDao.findById(readings.getVin()).getMaxFuelVolume() ) * 100 ) < 10){
            Alert alert = new Alert();
            alert.setLatitude(readings.getLatitude());
            alert.setLongitude(readings.getLongitude());
            alert.setAlertmsg(AlertMsgType.LOW_FUEL_ALERT.getAlertMsg());
            alert.setVin(readings.getVin());
            alert.setPriority("MEDIUM");
            alert.setTimestamp(new Timestamp(System.currentTimeMillis()));
            alertDao.create(alert);
            alerts.add(alert);
            System.out.println("Alert Mail sent !");
            System.out.println(alert.toString());
        }

        return alerts;
    }


}
