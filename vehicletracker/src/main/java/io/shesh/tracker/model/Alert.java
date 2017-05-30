package io.shesh.tracker.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * Created by shesh on 5/28/17.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Alert.findByVin",query = "select a from Alert a where a.vin = :vin"),
        @NamedQuery(name = "Alert.deleteByVin",query = "delete from Alert a where a.vin = :vin"),
        @NamedQuery(name = "Alert.findAll",query = "select a from Alert a")
})
public class Alert {

    @Id
    private String alertid;
    private String vin;
    private String alertmsg;
    private Date timestamp;
    private String priority;



    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }


    public void setAlertid(String alertid) {
        this.alertid = alertid;
    }


    public String getAlertmsg() {
        return alertmsg;
    }

    public void setAlertmsg(String alertmsg) {
        this.alertmsg = alertmsg;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Alert() {

        this.alertid = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "Alert{" +
                "alertid='" + alertid + '\'' +
                ", vin='" + vin + '\'' +
                ", alertmsg='" + alertmsg + '\'' +
                ", timestamp=" + timestamp +
                ", priority='" + priority + '\'' +
                '}';
    }
}
