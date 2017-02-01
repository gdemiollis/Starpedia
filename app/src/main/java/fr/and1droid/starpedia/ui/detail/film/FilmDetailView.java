package fr.and1droid.starpedia.ui.detail.film;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

import com.swapi.model.Film;
import com.swapi.model.People;

import fr.and1droid.starpedia.ui.detail.DetailView;

public class FilmDetailView extends DetailView<Film> {
    public FilmDetailView(Context context) {
        super(context);
    }

    public FilmDetailView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FilmDetailView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public FilmDetailView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void setEntity(Film entity) {

    }
}
