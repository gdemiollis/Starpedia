package fr.and1droid.starpedia.service;

import com.swapi.http.SpaceshipApi;
import com.swapi.model.Starship;

import java.io.IOException;
import java.util.List;

public class SpaceshipServiceImpl extends BaseServiceImpl<List<Starship>> implements SpaceshipService {

    private final SpaceshipApi spaceshipApi;

    public SpaceshipServiceImpl() {
        super();
        spaceshipApi = new SpaceshipApi();
    }

    @Override
    protected List<Starship> invoke() throws IOException {
        return spaceshipApi.listSpaceship();
    }
}
