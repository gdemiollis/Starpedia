package fr.and1droid.starpedia.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.RequiresApi;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import fr.and1droid.starpedia.R;


public class PlanetRowView extends LinearLayout {
    public PlanetRowView(Context context) {
        super(context);
    }

    public PlanetRowView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PlanetRowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PlanetRowView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setKey(@StringRes int key) {
        ((TextView) findViewById(R.id.key)).setText(key);
    }

    public void setValue(String value) {
        ((TextView) findViewById(R.id.value)).setText(value);
    }

    public void setIcon(@DrawableRes int icon) {
        ((ImageView) findViewById(R.id.icon)).setImageResource(icon);
    }
}
