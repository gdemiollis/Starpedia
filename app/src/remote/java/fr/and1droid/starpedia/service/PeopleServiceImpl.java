package fr.and1droid.starpedia.service;

import com.swapi.http.PeopleApi;
import com.swapi.model.People;

import java.io.IOException;
import java.util.List;

public class PeopleServiceImpl extends BaseServiceImpl<List<People>> implements PeopleService {

    private final PeopleApi peopleApi;

    public PeopleServiceImpl() {
        super();
        peopleApi = new PeopleApi();
    }

    @Override
    protected List<People> invoke() throws IOException {
        return peopleApi.listPeople();
    }
}
