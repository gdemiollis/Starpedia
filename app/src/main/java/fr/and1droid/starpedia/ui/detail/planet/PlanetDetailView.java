package fr.and1droid.starpedia.ui.detail.planet;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

import com.swapi.model.Planet;

import fr.and1droid.starpedia.R;
import fr.and1droid.starpedia.ui.detail.DetailView;


public class PlanetDetailView extends DetailView<Planet> {

    public PlanetDetailView(Context context) {
        super(context);
    }

    public PlanetDetailView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PlanetDetailView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PlanetDetailView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void setEntity(Planet planet) {
        initRow(R.id.gravity, R.string.gravity, String.format(getContext().getString(R.string._km), planet.gravity), R.drawable.ic_gravity);
        initRow(R.id.diameter, R.string.diameter, String.format(getContext().getString(R.string._ms2), planet.diameter), R.drawable.ic_diameter);
        initRow(R.id.population, R.string.population, planet.population, R.drawable.ic_population);
        initRow(R.id.terrain, R.string.terrain, planet.terrain, R.drawable.ic_terrain);
        initRow(R.id.climate, R.string.climate, planet.climate, R.drawable.ic_climate);
        initRow(R.id.orbital_period, R.string.orbital_period, planet.orbitalPeriod, R.drawable.ic_orbital_period);
    }

}
