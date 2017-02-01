package fr.and1droid.starpedia.ui.detail;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.swapi.model.SWEntity;

import fr.and1droid.starpedia.R;

public abstract class BaseFragment<E extends SWEntity, V extends DetailView<E>> extends Fragment {

    protected E entity;

    protected static final String EXTRA_ENTITY = "EXTRA_ENTITY";

    public static Bundle getBundle(SWEntity entity) {
        Bundle arguments = new Bundle();
        arguments.putSerializable(EXTRA_ENTITY, entity);
        return arguments;
    }

    public static SWEntity getEntity(Bundle extras) {
        return (SWEntity) extras.getSerializable(EXTRA_ENTITY);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(EXTRA_ENTITY)) {
            entity = (E) getArguments().getSerializable(EXTRA_ENTITY);

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(entity.getName());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        V detailView = (V) inflater.inflate(getLayoutId(), container, false);
        detailView.setEntity(entity);
        return detailView;
    }

    protected abstract int getLayoutId();

}
