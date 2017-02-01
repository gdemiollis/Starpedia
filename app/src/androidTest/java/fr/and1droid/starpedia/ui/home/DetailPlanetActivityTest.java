package fr.and1droid.starpedia.ui.home;


import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import fr.and1droid.starpedia.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class DetailPlanetActivityTest {

    @Rule
    public ActivityTestRule<HomeActivity> mActivityTestRule = new ActivityTestRule<>(HomeActivity.class);

    @Test
    public void detailPlanetTest() {
        onView(withId(R.id.category_list)).perform(actionOnItemAtPosition(0, click()));
        onView(withId(R.id.swentity_list)).perform(actionOnItemAtPosition(0, click()));


        onView(withContentDescription("Navigate up")).check(matches(isDisplayed()));

        onView(allOf(withId(R.id.value),
                childAtPosition(childAtPosition(withId(R.id.diameter), 1), 0)))
                .check(matches(withText("100 m/s2")));
        onView(allOf(withId(R.id.key),
                childAtPosition(childAtPosition(withId(R.id.diameter), 1), 1)))
                .check(matches(withText("Diameter")));

        onView(allOf(withId(R.id.value),
                childAtPosition(childAtPosition(withId(R.id.gravity), 1), 0)))
                .check(matches(withText("10 km")));
        onView(allOf(withId(R.id.key),
                childAtPosition(childAtPosition(withId(R.id.gravity), 1), 1)))
                .check(matches(withText("Gravity")));

        onView(allOf(withId(R.id.value),
                childAtPosition(childAtPosition(withId(R.id.population), 1), 0)))
                .check(matches(withText("1000")));
        onView(allOf(withId(R.id.key),
                childAtPosition(childAtPosition(withId(R.id.population), 1), 1)))
                .check(matches(withText("Population")));

        onView(allOf(withId(R.id.value),
                childAtPosition(childAtPosition(withId(R.id.terrain), 1), 0)))
                .check(matches(withText("Desert")));
        onView(allOf(withId(R.id.key),
                childAtPosition(childAtPosition(withId(R.id.terrain), 1), 1)))
                .check(matches(withText("Terrain")));

        onView(allOf(withId(R.id.value),
                childAtPosition(childAtPosition(withId(R.id.climate), 1), 0)))
                .check(matches(withText("tropical")));
        onView(allOf(withId(R.id.key),
                childAtPosition(childAtPosition(withId(R.id.climate), 1), 1)))
                .check(matches(withText("Climate")));

        onView(allOf(withId(R.id.value),
                childAtPosition(childAtPosition(withId(R.id.orbital_period), 1), 0)))
                .check(matches(withText("24")));
        onView(allOf(withId(R.id.key),
                childAtPosition(childAtPosition(withId(R.id.orbital_period), 1), 1)))
                .check(matches(withText("Orbital period")));

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
