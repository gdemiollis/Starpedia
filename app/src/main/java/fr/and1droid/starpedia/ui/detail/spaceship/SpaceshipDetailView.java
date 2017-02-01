package fr.and1droid.starpedia.ui.detail.spaceship;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

import com.swapi.model.Planet;
import com.swapi.model.Starship;

import fr.and1droid.starpedia.R;
import fr.and1droid.starpedia.ui.detail.DetailView;


public class SpaceshipDetailView extends DetailView<Starship> {

    public SpaceshipDetailView(Context context) {
        super(context);
    }

    public SpaceshipDetailView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SpaceshipDetailView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SpaceshipDetailView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void setEntity(Starship entity) {
        initRow(R.id.cost, R.string.cost, entity.costInCredits, R.drawable.ic_cost);
        initRow(R.id.length, R.string.length, entity.length, R.drawable.ic_height);
        initRow(R.id.crew, R.string.crew, entity.crew, R.drawable.ic_population);
        initRow(R.id.max_atmosphering_speed, R.string.max_atmosphering_speed, entity.maxAtmospheringSpeed, R.drawable.ic_speed);
    }

}
