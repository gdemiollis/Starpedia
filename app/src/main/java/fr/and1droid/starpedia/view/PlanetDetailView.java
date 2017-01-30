package fr.and1droid.starpedia.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.swapi.models.Planet;

import fr.and1droid.starpedia.R;


public class PlanetDetailView extends LinearLayout {

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

    public void setPlanet(Planet planet) {
        PlanetRowView gravityRow = (PlanetRowView) findViewById(R.id.gravity);
        gravityRow.setKey(R.string.gravity);
        gravityRow.setValue(String.format(getContext().getString(R.string._km), planet.gravity));
        gravityRow.setIcon(R.drawable.ic_gravity);

        PlanetRowView diameterRow = (PlanetRowView) findViewById(R.id.diameter);
        diameterRow.setKey(R.string.diameter);
        diameterRow.setValue(String.format(getContext().getString(R.string._ms2), planet.diameter));
        diameterRow.setIcon(R.drawable.ic_diameter);

        PlanetRowView populationRow = (PlanetRowView) findViewById(R.id.population);
        populationRow.setKey(R.string.population);
        populationRow.setValue(planet.population);
        populationRow.setIcon(R.drawable.ic_population);

        PlanetRowView terrainRow = (PlanetRowView) findViewById(R.id.terrain);
        terrainRow.setKey(R.string.terrain);
        terrainRow.setValue(planet.terrain);
        terrainRow.setIcon(R.drawable.ic_terrain);

        PlanetRowView climateRow = (PlanetRowView) findViewById(R.id.climate);
        climateRow.setKey(R.string.climate);
        climateRow.setValue(planet.climate);
        climateRow.setIcon(R.drawable.ic_climate);

        PlanetRowView orbitalPeriodRow = (PlanetRowView) findViewById(R.id.orbital_period);
        orbitalPeriodRow.setKey(R.string.orbital_period);
        orbitalPeriodRow.setValue(planet.orbitalPeriod);
        orbitalPeriodRow.setIcon(R.drawable.ic_orbital_period);
    }
}
