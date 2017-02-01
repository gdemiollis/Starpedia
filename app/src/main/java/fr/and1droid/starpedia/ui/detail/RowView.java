package fr.and1droid.starpedia.ui.detail;

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


public class RowView extends LinearLayout {
    public RowView(Context context) {
        super(context);
    }

    public RowView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RowView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public RowView withKey(@StringRes int key) {
        ((TextView) findViewById(R.id.key)).setText(key);
        return this;
    }

    public RowView withValue(String value) {
        ((TextView) findViewById(R.id.value)).setText(value);
        return this;
    }

    public RowView withIcon(@DrawableRes int icon) {
        ((ImageView) findViewById(R.id.icon)).setImageResource(icon);
        return this;
    }
}
