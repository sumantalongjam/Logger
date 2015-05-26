package in.blogspot.longjamcode.logger;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class LoggerActivity extends Activity {

    private TextView loggerTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logger);
        loggerTextView = (TextView) findViewById(R.id.logTextView);

        String errorData = DataHandler.getAllError(LoggerActivity.this);
        loggerTextView.setText(errorData);
    }
    public void clearData(View view) {
        DataHandler.clearAll(LoggerActivity.this);
        loggerTextView.setText("");
    }
}
