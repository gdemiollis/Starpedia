package fr.and1droid.starpedia.ui.detail.planet;

import com.swapi.model.Planet;

import fr.and1droid.starpedia.R;
import fr.and1droid.starpedia.ui.detail.BaseFragment;

public class PlanetFragment extends BaseFragment<Planet, PlanetDetailView> {

    @Override
    protected int getLayoutId() {
        return R.layout.detail_planet_fragment;
    }

}
