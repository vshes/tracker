package io.shesh.tracker.model;

import javax.persistence.Embeddable;
import java.sql.Date;

/**
 * Created by shesh on 5/28/17.
 */
@Embeddable
public class Tires {

    private int frontLeft;
    private int frontRight;
    private int rearLeft;
    private int rearRight;

    public int getFrontLeft() {
        return frontLeft;
    }

    public void setFrontLeft(int frontLeft) {
        this.frontLeft = frontLeft;
    }

    public int getFrontRight() {
        return frontRight;
    }

    public void setFrontRight(int frontRight) {
        this.frontRight = frontRight;
    }

    public int getRearLeft() {
        return rearLeft;
    }

    public void setRearLeft(int rearLeft) {
        this.rearLeft = rearLeft;
    }

    public int getRearRight() {
        return rearRight;
    }

    public void setRearRight(int rearRight) {
        this.rearRight = rearRight;
    }


    @Override
    public String toString() {
        return "Tyres{" +
                "frontLeft=" + frontLeft +
                ", frontRight=" + frontRight +
                ", rearLeft=" + rearLeft +
                ", rearRight=" + rearRight +
                '}';
    }
}
