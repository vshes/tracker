package io.shesh.tracker.utils;

/**
 * Created by shesh on 5/28/17.
 */
public enum AlertMsgType {
    //Alerts for tyres - Low and High Pressure
    PRESSURE_FRONTLEFT_TYRE_ALERT("FRONT LEFT PRESSURE CHECK ALERT"),
    PRESSURE_FRONTRIGHT_TYRE_ALERT("FRONT RIGHT PRESSURE CHECK ALERT"),
    PRESSURE_BACKLEFT_TYRE_ALERT("BACK  LEFT PRESSURE CHECK ALERT"),
    PRESSURE_BACKRIGHT_TYRE_ALERT("BACK RIGHT PRESSURE CHECK ALERT"),


    //alert on Engine
    HIGH_REDLINERPM_ALERT("RPM ALERT CHECK ABOVE RED-LINE: HIGH"),
    LOW_COOLANT_ALERT("COOLANT IS LOW : LOW"),
    LOW_FUEL_ALERT("FUEL IS BELOW 10% : MEDIUM"),
    CHECK_ENGINE_LIGHT("CHECK ENGINE LIGHT IS ON : LOW");


    private String alertMsg;

    AlertMsgType(String alertMsg) {
        this.alertMsg = alertMsg;
    }

    public String getAlertMsg() {
        return alertMsg;
    }
}
