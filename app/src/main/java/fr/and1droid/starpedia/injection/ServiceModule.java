package fr.and1droid.starpedia.injection;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import fr.and1droid.starpedia.service.FilmService;
import fr.and1droid.starpedia.service.FilmServiceImpl;
import fr.and1droid.starpedia.service.PeopleService;
import fr.and1droid.starpedia.service.PeopleServiceImpl;
import fr.and1droid.starpedia.service.PlanetService;
import fr.and1droid.starpedia.service.PlanetServiceImpl;
import fr.and1droid.starpedia.service.ServiceFactory;
import fr.and1droid.starpedia.service.SpaceshipService;
import fr.and1droid.starpedia.service.SpaceshipServiceImpl;
import fr.and1droid.starpedia.ui.detail.FragmentFactory;

@Module
class ServiceModule {

    @Provides
    @Singleton
    PlanetService providePlanetService() {
        return new PlanetServiceImpl();
    }

    @Provides
    @Singleton
    PeopleService providePeopleService() {
        return new PeopleServiceImpl();
    }

    @Provides
    @Singleton
    FilmService provideFilmService() {
        return new FilmServiceImpl();
    }

    @Provides
    @Singleton
    SpaceshipService provideSpaceshipService() {
        return new SpaceshipServiceImpl();
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
