package ro.pub.cs.systems.eim.lab05.startedserviceactivity.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

import ro.pub.cs.systems.eim.lab05.startedserviceactivity.general.Constants;

public class StartedServiceBroadcastReceiver extends BroadcastReceiver {

    private TextView messageTextView;

    public StartedServiceBroadcastReceiver() {
    }

    public StartedServiceBroadcastReceiver(TextView messageTextView) {
        this.messageTextView = messageTextView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // ex 5
        // get the action and the extra information from the intent
        String action = intent.getAction();
        String data = null;

        if (action != null) {
            switch (action) {
                case Constants.ACTION_STRING:
                    data = intent.getStringExtra(Constants.DATA);
                    break;
                case Constants.ACTION_INTEGER:
                    data = String.valueOf(intent.getIntExtra(Constants.DATA, 0));
                    break;
                case Constants.ACTION_ARRAY_LIST:
                    data = intent.getStringArrayListExtra(Constants.DATA).toString();
                    break;
                default:
                    break;
            }
        }

//        Log.d("DATA", data);
//        messageTextView.setText(messageTextView.getText().toString() + "\n" + data);


        // ex 7
        // restart the activity through an intent if the messageTextView is not available
        Intent startedServiceActivityIntent = new Intent(context, StartedServiceActivity.class);
        startedServiceActivityIntent.putExtra(Constants.MESSAGE, data);
        startedServiceActivityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(startedServiceActivityIntent);
    }
}
