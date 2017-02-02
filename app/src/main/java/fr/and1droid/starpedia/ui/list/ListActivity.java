package fr.and1droid.starpedia.ui.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.swapi.model.Category;
import com.swapi.model.SWEntity;

import java.util.List;

import javax.inject.Inject;

import fr.and1droid.starpedia.R;
import fr.and1droid.starpedia.injection.GraphProvider;
import fr.and1droid.starpedia.service.BaseService;
import fr.and1droid.starpedia.service.RequestCallback;
import fr.and1droid.starpedia.service.ServiceFactory;

public class ListActivity extends AppCompatActivity {

    @Inject
    ServiceFactory serviceFactory;

    private static final String EXTRA_CATEGORY = "EXTRA_CATEGORY";

    public static Intent newIntent(Context context, Category category) {
        Intent intent = new Intent(context, ListActivity.class);
        intent.putExtra(EXTRA_CATEGORY, category);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GraphProvider.injectIn(this);
        setContentView(R.layout.list_activity);

        initToolbar();

        View recyclerView = findViewById(R.id.swentity_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());
    }

    private void setupRecyclerView(@NonNull final RecyclerView recyclerView) {
        final boolean mTwoPane = findViewById(R.id.swentity_detail_container) != null;
        BaseService<List<SWEntity>> service = serviceFactory.getService((Category) getIntent().getSerializableExtra(EXTRA_CATEGORY));
        service.list(new RequestCallback<List<SWEntity>>() {
            @Override
            public void onSuccess(List<SWEntity> entities) {
                EntityRecyclerViewAdapter adapter = new EntityRecyclerViewAdapter(entities, mTwoPane);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFail(Throwable throwable) {
                Log.e(getClass().getSimpleName(), throwable.getMessage(), throwable);
                Toast.makeText(ListActivity.this, throwable.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
