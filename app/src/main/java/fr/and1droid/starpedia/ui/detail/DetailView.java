package fr.and1droid.starpedia.ui.detail;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.swapi.model.SWEntity;


public abstract class DetailView<E extends SWEntity> extends LinearLayout {

    public DetailView(Context context) {
        super(context);
    }

    public DetailView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DetailView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DetailView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public abstract void setEntity(E entity);

    protected void initRow(int gravity, int key, String value, int ic_gravity) {
        ((RowView) findViewById(gravity))
                .withKey(key).withValue(value)
                .withValue(value)
                .withIcon(ic_gravity);
    }
}
