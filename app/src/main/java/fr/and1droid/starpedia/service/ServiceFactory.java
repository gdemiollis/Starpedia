package fr.and1droid.starpedia.service;

import com.swapi.model.Category;

import javax.inject.Inject;

import fr.and1droid.starpedia.injection.GraphProvider;

public class ServiceFactory {

    @Inject
    PlanetService planetService;
    @Inject
    PeopleService peopleService;
    @Inject
    FilmService filmService;
    @Inject
    SpaceshipService spaceshipService;

    public ServiceFactory() {
        GraphProvider.injectIn(this);
    }

    public BaseService getService(Category category) {
        switch (category) {
            case Planet:
                return planetService;
            case People:
                return peopleService;
            case Film:
                return filmService;
            case Starship:
                return spaceshipService;
        }
        throw new IllegalArgumentException("No service found for category " + category.name());
    }


}
