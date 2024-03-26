package ro.pub.cs.systems.eim.lab05.startedservice.service;

import android.content.Context;
import android.content.Intent;

import ro.pub.cs.systems.eim.lab05.startedservice.general.Constants;

public class ProcessingThread extends Thread {
    private Context context;

    public ProcessingThread(Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        while(true) {
            sendMessage(Constants.MESSAGE_STRING);
            sleep();
            sendMessage(Constants.MESSAGE_INTEGER);
            sleep();
            sendMessage(Constants.MESSAGE_ARRAY_LIST);
            sleep();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(Constants.SLEEP_TIME);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    // uses setAction and putExtra for each message type
    private void sendMessage(int messageType) {
        Intent intent = new Intent();
        switch (messageType) {
            case Constants.MESSAGE_STRING:
                intent.setAction(Constants.ACTION_STRING);
                intent.putExtra(Constants.DATA, Constants.STRING_DATA);
                break;
            case Constants.MESSAGE_INTEGER:
                intent.setAction(Constants.ACTION_INTEGER);
                intent.putExtra(Constants.DATA, Constants.INTEGER_DATA);
                break;
            case Constants.MESSAGE_ARRAY_LIST:
                intent.setAction(Constants.ACTION_ARRAY_LIST);
                intent.putExtra(Constants.DATA, Constants.ARRAY_LIST_DATA);
                break;
            default:
                break;
        }
        context.sendBroadcast(intent);
    }
}
