package fr.and1droid.starpedia.service;

import com.swapi.http.FilmApi;
import com.swapi.model.Film;

import java.io.IOException;
import java.util.List;

public class FilmServiceImpl extends BaseServiceImpl<List<Film>> implements FilmService {

    private final FilmApi filmApi;

    public FilmServiceImpl() {
        super();
        filmApi = new FilmApi();
    }

    @Override
    protected List<Film> invoke() throws IOException {
        return filmApi.listFilms();
    }
}
