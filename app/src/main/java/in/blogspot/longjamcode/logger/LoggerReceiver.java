package in.blogspot.longjamcode.logger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by sumanta on 26/5/15.
 */
public class LoggerReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String loggerData = intent.getStringExtra("LOGGER_DATA");
        if(loggerData!=null) {
            DataHandler.insertError(context, loggerData);
        }
    }

}
