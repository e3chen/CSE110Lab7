package com.emilychen.user1;

import com.firebase.client.Firebase;

/**
 * Created by emilychen on 5/18/16.
 */
public class FirebaseContext extends android.app.Application {
    public void onCreate() {
        
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
