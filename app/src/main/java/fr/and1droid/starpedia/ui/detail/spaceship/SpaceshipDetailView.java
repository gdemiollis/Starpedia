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
    public void setEntity(Starship planet) {
    }

}
