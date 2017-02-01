package fr.and1droid.starpedia.util;

import org.junit.Test;

import fr.and1droid.starpedia.R;

import static com.swapi.model.Category.Film;
import static com.swapi.model.Category.People;
import static com.swapi.model.Category.Planet;
import static com.swapi.model.Category.Starship;
import static org.junit.Assert.*;

public class CategoryUtilTest {
    @Test
    public void getImageByCategory() throws Exception {
        assertEquals(R.drawable.ic_spaceship, CategoryUtil.getImageByCategory(Starship));
        assertEquals(R.drawable.ic_population, CategoryUtil.getImageByCategory(People));
        assertEquals(R.drawable.ic_planet, CategoryUtil.getImageByCategory(Planet));
        assertEquals(R.drawable.ic_movie, CategoryUtil.getImageByCategory(Film));
    }

    @Test
    public void getTextByCaterory() throws Exception {
        assertEquals(R.string.spaceships, CategoryUtil.getTextByCaterory(Starship));
        assertEquals(R.string.people, CategoryUtil.getTextByCaterory(People));
        assertEquals(R.string.planets, CategoryUtil.getTextByCaterory(Planet));
        assertEquals(R.string.films, CategoryUtil.getTextByCaterory(Film));
    }
}