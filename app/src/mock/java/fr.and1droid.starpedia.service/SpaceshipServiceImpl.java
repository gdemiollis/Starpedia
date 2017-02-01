package fr.and1droid.starpedia.service;

import com.swapi.model.Starship;

import java.util.ArrayList;
import java.util.List;

public class SpaceshipServiceImpl implements SpaceshipService {

    @Override
    public void execute(RequestCallback<List<Starship>> requestCallback) {
        List<Starship> result = new ArrayList<>();
        result.add(buildStarShip(1));
        result.add(buildStarShip(2));
        result.add(buildStarShip(3));
        result.add(buildStarShip(4));
        requestCallback.onSuccess(result);
    }

    private Starship buildStarShip(int i) {
        Starship starship = new Starship();
        starship.name = "Starship " + i;
        starship.costInCredits = "" + i * 10000;
        starship.length = "" + i * 45;
        starship.crew = "" + i * 567;
        return starship;
    }
}
