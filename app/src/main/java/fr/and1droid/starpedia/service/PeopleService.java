package fr.and1droid.starpedia.service;

import com.swapi.http.PeopleApi;
import com.swapi.http.PlanetApi;
import com.swapi.model.People;
import com.swapi.model.Planet;

import java.io.IOException;
import java.util.List;

public class PeopleService extends BaseService<List<People>> {

    private final PeopleApi peopleApi;

    public PeopleService() {
        super();
        peopleApi = new PeopleApi();
    }

    @Override
    protected List<People> invoke() throws IOException {
        return peopleApi.listPeople();
    }
}
