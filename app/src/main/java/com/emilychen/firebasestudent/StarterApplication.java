package com.emilychen.firebasestudent;

import com.firebase.client.Firebase;

/**
 * Created by emilychen on 5/18/16.
 */
public class StarterApplication extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}
