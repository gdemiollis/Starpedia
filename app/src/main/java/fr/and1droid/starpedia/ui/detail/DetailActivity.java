package fr.and1droid.starpedia.ui.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import com.swapi.model.SWEntity;

import javax.inject.Inject;

import fr.and1droid.starpedia.R;
import fr.and1droid.starpedia.injection.GraphProvider;
import fr.and1droid.starpedia.ui.detail.planet.PlanetFragment;
import fr.and1droid.starpedia.ui.list.ListActivity;

public class DetailActivity extends AppCompatActivity {

    @Inject
    FragmentFactory fragmentFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        GraphProvider.injectIn(this);
        initActionBar();

        if (savedInstanceState == null) {
            Fragment fragment = fragmentFactory.getFragment(BaseFragment.getEntity(getIntent().getExtras()));
            fragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.swentity_detail_container, fragment)
                    .commit();
        }
    }

    private void initActionBar() {
        setSupportActionBar((Toolbar) findViewById(R.id.detail_toolbar));
        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            super.onBackPressed();
            super.onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static Intent newIntent(Context context, SWEntity entity) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtras(PlanetFragment.getBundle(entity));
        return intent;
    }
}
