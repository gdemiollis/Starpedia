package fr.and1droid.starpedia.service;

import com.swapi.model.Film;

import java.util.ArrayList;
import java.util.List;

public class FilmServiceImpl implements FilmService {

    @Override
    public void execute(RequestCallback<List<Film>> requestCallback) {
        List<Film> result = new ArrayList<>();
        result.add(buildFilm(1));
        result.add(buildFilm(2));
        result.add(buildFilm(3));
        result.add(buildFilm(4));
        requestCallback.onSuccess(result);
    }

    private Film buildFilm(int i) {
        Film film = new Film();
        film.title = "Film " + i;
        film.release_date = "2016/06/0" + i;
        film.director = "Director " + i;
        film.openingCrawl = "Opening crawl " + i;
        return film;
    }
}
