package fr.and1droid.starpedia.service;

import com.swapi.http.FilmApi;
import com.swapi.http.PeopleApi;
import com.swapi.model.Film;
import com.swapi.model.People;

import java.io.IOException;
import java.util.List;

public class FilmService extends BaseService<List<Film>> {

    private final FilmApi filmApi;

    public FilmService() {
        super();
        filmApi = new FilmApi();
    }

    @Override
    protected List<Film> invoke() throws IOException {
        return filmApi.listFilms();
    }
}
