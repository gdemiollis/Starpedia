package fr.and1droid.starpedia.ui.detail.people;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

import com.swapi.model.People;

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

    }
}
