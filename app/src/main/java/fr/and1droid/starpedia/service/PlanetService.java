package fr.and1droid.starpedia.service;

import com.swapi.http.PlanetApi;
import com.swapi.models.Planet;

import java.io.IOException;
import java.util.List;

import fr.and1droid.starpedia.BaseService;

public class PlanetService extends BaseService<List<Planet>> {

    private final PlanetApi planetApi;

    public PlanetService() {
        super();
        planetApi = new PlanetApi();
    }

    @Override
    protected List<Planet> invoke() throws IOException {
        return planetApi.listPlanets();
    }
}
