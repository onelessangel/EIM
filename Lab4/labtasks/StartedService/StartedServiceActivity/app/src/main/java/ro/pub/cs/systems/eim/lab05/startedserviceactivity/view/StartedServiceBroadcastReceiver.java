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
//        String dataString = null;
//        int dataInteger = Integer.parseInt(null);

        if (action != null) {
            switch (action) {
                case Constants.ACTION_STRING:
                    String stringData = intent.getStringExtra(Constants.DATA);
                    Log.d("DATA", stringData);
                    break;
                case Constants.ACTION_INTEGER:
                    int integerData = intent.getIntExtra(Constants.DATA, 0);
                    Log.d("DATA", String.valueOf(integerData));
                    break;
                case Constants.ACTION_ARRAY_LIST:
                    ArrayList<String> arrayListData = intent.getStringArrayListExtra(Constants.DATA);

                    StringBuilder sb = new StringBuilder();
                    for (String s : arrayListData) {
                        sb.append(s + " ");
                    }

                    Log.d("DATA", sb.toString());
                    break;
                default:
                    break;
            }
        }


//        if (Constants.ACTION_STRING.equals(action)) {
//            dataString = intent.getStringExtra(Constants.DATA);
//        }

        // and set the text on the messageTextView
//        if (messageTextView != null) {
//            messageTextView.setText(messageTextView.getText().toString() + "\n" + dataString);
//        }

        // TODO: exercise 9 - restart the activity through an intent
        // if the messageTextView is not available
    }
}
