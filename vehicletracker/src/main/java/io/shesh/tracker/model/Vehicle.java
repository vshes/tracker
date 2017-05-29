package io.shesh.tracker.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.sql.Date;

/**
 * Created by shesh on 5/28/17.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Vehicle.findAll", query = "SELECT v from Vehicle v"),
        @NamedQuery(name = "Vehicle.findById", query = "select v from Vehicle v where v.vin = :id"),
        @NamedQuery(name = "Vehicle.deleteById",query = "delete from Vehicle v where v.vin = :id")
})
public class Vehicle {

    @Id
    private String vin;
    private String model;
    private String make;
    private int year;
    private int redlineRpm;
    private int maxFuelVolume;
    private Date lastServiceDate;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(int redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public int getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(int maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public Date getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(Date lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vin='" + vin + '\'' +
                ", model='" + model + '\'' +
                ", make='" + make + '\'' +
                ", year=" + year +
                ", redlineRpm=" + redlineRpm +
                ", maxFuelVolume=" + maxFuelVolume +
                ", lastServiceDate=" + lastServiceDate +
                '}';
    }
}
