package fr.and1droid.starpedia.service;

import com.swapi.http.PlanetApi;
import com.swapi.model.Planet;

import java.io.IOException;
import java.util.List;

public class PlanetServiceImpl extends BaseServiceImpl<List<Planet>> implements PlanetService {

    private final PlanetApi planetApi;

    public PlanetServiceImpl() {
        super();
        planetApi = new PlanetApi();
    }

    @Override
    protected List<Planet> invoke() throws IOException {
        return planetApi.listPlanets();
    }
}
