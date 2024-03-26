package ro.pub.cs.systems.eim.lab05.startedserviceactivity.view;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ro.pub.cs.systems.eim.lab05.startedserviceactivity.R;
import ro.pub.cs.systems.eim.lab05.startedserviceactivity.general.Constants;

public class StartedServiceActivity extends AppCompatActivity {

    private TextView messageTextView;
    private StartedServiceBroadcastReceiver startedServiceBroadcastReceiver;
    private IntentFilter startedServiceIntentFilter;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_started_service);

        messageTextView = findViewById(R.id.message_text_view);

        // ex 4
        // create intent which explicitly indicates the service to be started
        intent = new Intent();
        intent.setComponent(new ComponentName(Constants.SERVICE_PACKAGE, Constants.SERVICE_CLASS));

        // start service depending on SDK version
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.startForegroundService(intent);    // for versions higher than Oreo
        } else {
            this.startService(intent);
        }

        // ex 6
        startedServiceBroadcastReceiver = new StartedServiceBroadcastReceiver(messageTextView);

        // intent filter for watching certain actions in intents
        startedServiceIntentFilter = new IntentFilter();
        startedServiceIntentFilter.addAction(Constants.ACTION_STRING);
        startedServiceIntentFilter.addAction(Constants.ACTION_INTEGER);
        startedServiceIntentFilter.addAction(Constants.ACTION_ARRAY_LIST);

        // TODO: exercise 8a - create an instance of the StartedServiceBroadcastReceiver broadcast receiver

        // TODO: exercise 8b - create an instance of an IntentFilter
        // with all available actions contained within the broadcast intents sent by the service

    }

    // ex 6 - register the broadcast receiver with the corresponding intent filter
    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(startedServiceBroadcastReceiver, startedServiceIntentFilter);
    }

    // ex 6 - unregister the broadcast receiver
    @Override
    protected void onPause() {
        unregisterReceiver(startedServiceBroadcastReceiver);
        super.onPause();
    }

    // ex 6 - stop the service
    @Override
    protected void onDestroy() {
        stopService(intent);
        super.onDestroy();
    }

    // TODO: exercise 9 - implement the onNewIntent callback method
    // get the message from the extra field of the intent
    // and display it in the messageTextView

}
