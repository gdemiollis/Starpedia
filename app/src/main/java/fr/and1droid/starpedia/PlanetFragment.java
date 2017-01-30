package fr.and1droid.starpedia;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.swapi.models.Planet;
import com.swapi.models.SWEntity;

import fr.and1droid.starpedia.view.PlanetDetailView;

public class PlanetFragment extends Fragment {

    private static final String EXTRA_ENTITY = "EXTRA_ENTITY";
    private Planet planet;

    public PlanetFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(EXTRA_ENTITY)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            planet = (Planet) getArguments().getSerializable(EXTRA_ENTITY);

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(planet.getName());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        PlanetDetailView planetDetailView = (PlanetDetailView) inflater.inflate(R.layout.detail_planet_fragment, container, false);
        planetDetailView.setPlanet(planet);
        return planetDetailView;
    }

    public static Bundle getBundle(SWEntity entity) {
        Bundle arguments = new Bundle();
        arguments.putSerializable(EXTRA_ENTITY, entity);
        return arguments;
    }

}
