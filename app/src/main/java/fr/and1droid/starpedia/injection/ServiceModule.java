package fr.and1droid.starpedia.injection;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import fr.and1droid.starpedia.service.FilmService;
import fr.and1droid.starpedia.service.PeopleService;
import fr.and1droid.starpedia.service.PlanetService;
import fr.and1droid.starpedia.service.ServiceFactory;
import fr.and1droid.starpedia.service.SpaceshipService;
import fr.and1droid.starpedia.ui.detail.FragmentFactory;

@Module
class ServiceModule {

    @Provides
    @Singleton
    PlanetService providePlanetService() {
        return new PlanetService();
    }

    @Provides
    @Singleton
    PeopleService providePeopleService() {
        return new PeopleService();
    }

    @Provides
    @Singleton
    FilmService provideFilmService() {
        return new FilmService();
    }

    @Provides
    @Singleton
    SpaceshipService provideSpaceshipService() {
        return new SpaceshipService();
    }

    @Provides
    @Singleton
    ServiceFactory provideServiceFactory() {
        return new ServiceFactory();
    }

    @Provides
    @Singleton
    FragmentFactory proviceFragmentFactory() {
        return new FragmentFactory();
    }

}
