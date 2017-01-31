package fr.and1droid.starpedia.injection;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import fr.and1droid.starpedia.service.PlanetService;

@Module
class ServiceModule {

    @Provides
    @Singleton
    PlanetService providePlanetService() {
        return new PlanetService();
    }

}
