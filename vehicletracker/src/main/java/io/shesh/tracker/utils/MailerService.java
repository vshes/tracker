package io.shesh.tracker.utils;
import io.shesh.tracker.model.Alert;
/**
 * Created by shesh on 5/30/17.
 */
import java.util.List;
public interface MailerService {

    void send(List<Alert> msg, String id);


}
