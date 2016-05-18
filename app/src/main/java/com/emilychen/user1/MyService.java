package com.emilychen.user1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MyService extends Service {
    public MyService() {
    }

    final class MyThread implements Runnable{
        Firebase mref;
        int startId;

        public MyThread(int startId) {
            this.startId = startId;
        }

        @Override
        public void run() {
            /*final TextView textView = (TextView) findViewById(R.id.textView);
            Button b1 = (Button) findViewById(R.id.button);
            //User 1 Reading from /first*/
            synchronized (this) {
                try {
                    mref = new Firebase("https://emily-110.firebaseio.com/second");
                    mref.setValue("hello");
                    wait(3000);
                    mref.setValue("from");
                    wait(3000);
                    mref.setValue("user");
                    wait(3000);
                    mref.setValue("1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                stopSelf(startId);
            }
            /*
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //User 1 Writing to /second
                    mref = new Firebase("https://emily-110.firebaseio.com/second");
                    EditText editText = (EditText) findViewById(R.id.editText);
                    String edit = editText.getText().toString();
                    mref.setValue(edit);
                }
            });*/
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Toast.makeText(getApplicationContext(),"Service Started", Toast.LENGTH_SHORT).show();
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
        Toast.makeText(getApplicationContext(), "Service Stopped", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
