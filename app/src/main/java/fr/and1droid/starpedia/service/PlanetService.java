package fr.and1droid.starpedia.service;

import com.swapi.http.PlanetApi;
import com.swapi.models.Planet;

import java.io.IOException;
import java.util.List;

import fr.and1droid.starpedia.BaseService;
import fr.and1droid.starpedia.RequestCallback;

public class PlanetService extends BaseService<List<Planet>>{

    private final PlanetApi planetApi;

    public PlanetService(RequestCallback<List<Planet>> callback) {
        super(callback);
        planetApi = new PlanetApi();
    }

    @Override
    protected List<Planet> execute() throws IOException {
        return planetApi.listPlanets();
    }
}
