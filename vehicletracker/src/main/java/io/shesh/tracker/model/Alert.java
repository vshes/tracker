package io.shesh.tracker.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * Created by shesh on 5/28/17.
 */
public class Alert {

    private String alertid;
    private String vid;
    private String alertmsg;
    private Timestamp timestamp;

    public String getAlertid() {
        return alertid;
    }

    public void setAlertid(String alertid) {
        this.alertid = alertid;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getAlertmsg() {
        return alertmsg;
    }

    public void setAlertmsg(String alertmsg) {
        this.alertmsg = alertmsg;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Alert() {
        this.alertid = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "Alert{" +
                "alertid='" + alertid + '\'' +
                ", vid='" + vid + '\'' +
                ", alertmsg='" + alertmsg + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
