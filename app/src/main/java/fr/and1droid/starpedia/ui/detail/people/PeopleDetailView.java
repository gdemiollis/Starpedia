package fr.and1droid.starpedia.ui.detail.people;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

import com.swapi.model.People;

import fr.and1droid.starpedia.R;
import fr.and1droid.starpedia.ui.detail.DetailView;

public class PeopleDetailView extends DetailView<People> {
    public PeopleDetailView(Context context) {
        super(context);
    }

    public PeopleDetailView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PeopleDetailView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PeopleDetailView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void setEntity(People entity) {
        initRow(R.id.birth_year, R.string.birth_year, entity.birthYear, R.drawable.ic_birth_year);
        initRow(R.id.eye, R.string.eye_color, entity.eyeColor, R.drawable.ic_eye);
        initRow(R.id.hair, R.string.hair_color, entity.hairColor, R.drawable.ic_hair_color);
        initRow(R.id.gender, R.string.gender, entity.gender, R.drawable.ic_gender);
        initRow(R.id.height, R.string.height, entity.height, R.drawable.ic_height);
    }
}
