package fr.and1droid.starpedia.service;

import com.swapi.model.Planet;

import java.util.ArrayList;
import java.util.List;

public class PlanetServiceImpl implements PlanetService {

    @Override
    public void execute(RequestCallback<List<Planet>> requestCallback) {
        List<Planet> result = new ArrayList<>();
        result.add(buildPlanet(1));
        result.add(buildPlanet(2));
        result.add(buildPlanet(3));
        result.add(buildPlanet(4));
        requestCallback.onSuccess(result);
    }

    private Planet buildPlanet(int i) {
        Planet planet = new Planet();
        planet.name = "Planet " + i;
        planet.gravity = "" + i * 10;
        planet.diameter = "" + i * 100;
        planet.population = "" + i * 1000;
        planet.terrain = i % 2 == 0 ? "Wood" : "Desert";
        planet.climate = i % 2 == 0 ? "temperate" : "tropical";
        planet.orbitalPeriod = "" + i * 24;
        return planet;
    }
}
