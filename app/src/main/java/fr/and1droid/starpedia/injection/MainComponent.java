package fr.and1droid.starpedia.injection;

import javax.inject.Singleton;

import dagger.Component;
import fr.and1droid.starpedia.ListActivity;

@Singleton
@Component(modules = ServiceModule.class)
public interface MainComponent {

    void inject(ListActivity target);
}
