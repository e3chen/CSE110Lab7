package com.emilychen.user2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.firebase.client.Firebase;

public class MyService extends Service {
    public MyService() {
    }

    final class MyThread implements Runnable {
        Firebase mref;
        int startId;

        public MyThread(int startId) {
            this.startId = startId;
        }

        @Override
        public void run() {
            synchronized (this) {
                try {
                    mref = new Firebase("https://emily-110.firebaseio.com/first");
                    mref.setValue("hey");
                    wait(4000);
                    mref.setValue("there");
                    wait(4000);
                    mref.setValue("from");
                    wait(4000);
                    mref.setValue("user");
                    wait(4000);
                    mref.setValue("2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                stopSelf(startId);
            }
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Thread thread = new Thread(new MyThread(startId));
        thread.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
