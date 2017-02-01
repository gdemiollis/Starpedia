package fr.and1droid.starpedia.ui.detail.spaceship;

import com.swapi.model.Starship;

import fr.and1droid.starpedia.R;
import fr.and1droid.starpedia.ui.detail.BaseFragment;

public class SpaceshipFragment extends BaseFragment<Starship, SpaceshipDetailView> {
    @Override
    protected int getLayoutId() {
        return R.layout.detail_spaceship_fragment;
    }
}
