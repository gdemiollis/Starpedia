package fr.and1droid.starpedia.util;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

import com.swapi.model.Category;

import fr.and1droid.starpedia.R;

public class CategoryUtil {

    public static
    @DrawableRes
    int getImageByCategory(Category category) {
        switch (category) {
            case Planet:
                return R.drawable.ic_planet;
            case People:
                return R.drawable.ic_population;
            case Film:
                return R.drawable.ic_movie;
            case Starship:
                return R.drawable.ic_spaceship;
            default:
                throw new IllegalArgumentException("No text for category " + category);
        }
    }

    public static
    @StringRes
    int getTextByCaterory(Category category) {
        switch (category) {
            case Planet:
                return R.string.planets;
            case People:
                return R.string.people;
            case Film:
                return R.string.films;
            case Starship:
                return R.string.spaceships;
            default:
                throw new IllegalArgumentException("No text for category " + category);
        }
    }
}
