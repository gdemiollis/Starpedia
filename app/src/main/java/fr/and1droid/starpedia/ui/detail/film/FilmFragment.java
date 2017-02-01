package fr.and1droid.starpedia.ui.detail.film;

import com.swapi.model.Film;

import fr.and1droid.starpedia.R;
import fr.and1droid.starpedia.ui.detail.BaseFragment;

public class FilmFragment extends BaseFragment<Film, FilmDetailView> {
    @Override
    protected int getLayoutId() {
        return R.layout.detail_film_fragment;
    }
}
