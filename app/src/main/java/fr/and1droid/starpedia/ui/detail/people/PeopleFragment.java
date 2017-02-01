package fr.and1droid.starpedia.ui.detail.people;

import com.swapi.model.People;

import fr.and1droid.starpedia.R;
import fr.and1droid.starpedia.ui.detail.BaseFragment;

public class PeopleFragment extends BaseFragment<People, PeopleDetailView> {
    @Override
    protected int getLayoutId() {
        return R.layout.detail_people_fragment;
    }
}
