package ro.pub.cs.systems.eim.lab05.startedserviceactivity.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import ro.pub.cs.systems.eim.lab05.startedserviceactivity.general.Constants;

public class StartedServiceBroadcastReceiver extends BroadcastReceiver {

    private TextView messageTextView;

    public StartedServiceBroadcastReceiver(TextView messageTextView) {
        this.messageTextView = messageTextView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // get the action and the extra information from the intent
        String action = intent.getAction();
        String data = null;
        if (Constants.ACTION_STRING.equals(action)) {
            data = intent.getStringExtra(Constants.DATA);
        }

        // and set the text on the messageTextView
        if (messageTextView != null) {
            messageTextView.setText(messageTextView.getText().toString() + "\n" + data);
        }

        // TODO: exercise 9 - restart the activity through an intent
        // if the messageTextView is not available
    }
}
