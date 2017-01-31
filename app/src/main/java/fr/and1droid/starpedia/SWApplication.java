package fr.and1droid.starpedia;

import android.app.Application;

import fr.and1droid.starpedia.injection.GraphProvider;


public class SWApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        GraphProvider.init();
    }
}
