package fr.and1droid.starpedia.ui.home;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import fr.and1droid.starpedia.R;
import fr.and1droid.starpedia.matcher.ListMatchers;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ListActivityTest {

    @Rule
    public ActivityTestRule<HomeActivity> mActivityTestRule = new ActivityTestRule<>(HomeActivity.class);

    @Test
    public void listPlanetTest() {
        onView(withId(R.id.category_list)).perform(actionOnItemAtPosition(0, click()));
        onView(withId(R.id.swentity_list)).check(matches(ListMatchers.withListSize(4)));

        onView(withText("Planet 1")).check(matches(isDisplayed()));
        onView(withText("Planet 2")).check(matches(isDisplayed()));
        onView(withText("Planet 3")).check(matches(isDisplayed()));
        onView(withText("Planet 4")).check(matches(isDisplayed()));
    }

    @Test
    public void listPeopleTest() {
        onView(withId(R.id.category_list)).perform(actionOnItemAtPosition(1, click()));
        onView(withId(R.id.swentity_list)).check(matches(ListMatchers.withListSize(4)));

        onView(withText("People 1")).check(matches(isDisplayed()));
        onView(withText("People 2")).check(matches(isDisplayed()));
        onView(withText("People 3")).check(matches(isDisplayed()));
        onView(withText("People 4")).check(matches(isDisplayed()));
    }

    @Test
    public void listFilmTest() {
        onView(withId(R.id.category_list)).perform(actionOnItemAtPosition(2, click()));
        onView(withId(R.id.swentity_list)).check(matches(ListMatchers.withListSize(4)));

        onView(withText("Film 1")).check(matches(isDisplayed()));
        onView(withText("Film 2")).check(matches(isDisplayed()));
        onView(withText("Film 3")).check(matches(isDisplayed()));
        onView(withText("Film 4")).check(matches(isDisplayed()));
    }

    @Test
    public void listStarshipTest() {
        onView(withId(R.id.category_list)).perform(actionOnItemAtPosition(3, click()));
        onView(withId(R.id.swentity_list)).check(matches(ListMatchers.withListSize(4)));

        onView(withText("Starship 1")).check(matches(isDisplayed()));
        onView(withText("Starship 2")).check(matches(isDisplayed()));
        onView(withText("Starship 3")).check(matches(isDisplayed()));
        onView(withText("Starship 4")).check(matches(isDisplayed()));
    }
}
