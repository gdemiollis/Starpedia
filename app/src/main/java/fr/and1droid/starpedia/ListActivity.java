package fr.and1droid.starpedia;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.swapi.models.Planet;

import java.util.List;

import fr.and1droid.starpedia.service.PlanetService;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        View recyclerView = findViewById(R.id.swentity_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
    }

    private void setupRecyclerView(@NonNull final RecyclerView recyclerView) {
        final boolean mTwoPane = findViewById(R.id.swentity_detail_container) != null;
        new PlanetService(new RequestCallback<List<Planet>>() {
            @Override
            public void onSuccess(List<Planet> planets) {
                SimpleItemRecyclerViewAdapter adapter = new SimpleItemRecyclerViewAdapter(planets, mTwoPane);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFail(Throwable throwable) {
                Log.e(getClass().getSimpleName(), throwable.getMessage(), throwable);
                Toast.makeText(ListActivity.this, throwable.getMessage(), Toast.LENGTH_LONG).show();
            }
        }).invoke();


    }
}
