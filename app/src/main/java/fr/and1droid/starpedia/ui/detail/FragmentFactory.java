package fr.and1droid.starpedia.ui.detail;

import android.support.v4.app.Fragment;

import com.swapi.model.SWEntity;

import fr.and1droid.starpedia.ui.detail.film.FilmFragment;
import fr.and1droid.starpedia.ui.detail.people.PeopleFragment;
import fr.and1droid.starpedia.ui.detail.planet.PlanetFragment;
import fr.and1droid.starpedia.ui.detail.spaceship.SpaceshipFragment;

public class FragmentFactory {

    public FragmentFactory() {
    }

    public Fragment getFragment(SWEntity entity) {
        switch (entity.getCategory()) {
            case Planet:
                return new PlanetFragment();
            case People:
                return new PeopleFragment();
            case Starship:
                return new SpaceshipFragment();
            case Film:
                return new FilmFragment();
        }
        throw new IllegalArgumentException("No Fragment found for " + entity.getCategory());
    }
}
