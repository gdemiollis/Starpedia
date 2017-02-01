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
public class DetailFilmActivityTest {

    @Rule
    public ActivityTestRule<HomeActivity> mActivityTestRule = new ActivityTestRule<>(HomeActivity.class);

    @Test
    public void detailFilmTest() {
        onView(withId(R.id.category_list)).perform(actionOnItemAtPosition(2, click()));
        onView(withId(R.id.swentity_list)).perform(actionOnItemAtPosition(0, click()));

        onView(withContentDescription("Navigate up")).check(matches(isDisplayed()));

        onView(allOf(withId(R.id.value),
                childAtPosition(childAtPosition(withId(R.id.release_date), 1), 0)))
                .check(matches(withText("2016/06/01")));
        onView(allOf(withId(R.id.key),
                childAtPosition(childAtPosition(withId(R.id.release_date), 1), 1)))
                .check(matches(withText("Release date")));

        onView(allOf(withId(R.id.value),
                childAtPosition(childAtPosition(withId(R.id.director), 1), 0)))
                .check(matches(withText("Director 1")));
        onView(allOf(withId(R.id.key),
                childAtPosition(childAtPosition(withId(R.id.director), 1), 1)))
                .check(matches(withText("Director")));

        onView(withId(R.id.opening_crawl)).check(matches(withText("Opening crawl 1")));
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
