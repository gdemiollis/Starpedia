package fr.and1droid.starpedia;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import fr.and1droid.starpedia.injection.GraphProvider;


public class SWApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        GraphProvider.init();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
}
