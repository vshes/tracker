package io.shesh.tracker.utils;
import io.shesh.tracker.model.Alert;
/**
 * Created by shesh on 5/30/17.
 */
public interface MailerService {

    void send(Alert msg);


}
