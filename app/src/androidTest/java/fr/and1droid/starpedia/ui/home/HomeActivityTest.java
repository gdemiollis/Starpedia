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
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class HomeActivityTest {

    @Rule
    public ActivityTestRule<HomeActivity> mActivityTestRule = new ActivityTestRule<>(HomeActivity.class);

    @Test
    public void homeActivityTest() {
        onView(withId(R.id.category_list)).check(matches(ListMatchers.withListSize(4)));
        onView(withText("Planets")).check(matches(isDisplayed()));
        onView(withText("People")).check(matches(isDisplayed()));
        onView(withText("Films")).check(matches(isDisplayed()));
        onView(withText("Spaceships")).check(matches(isDisplayed()));
    }
}
