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
public class DetailPeopleActivityTest {

    @Rule
    public ActivityTestRule<HomeActivity> mActivityTestRule = new ActivityTestRule<>(HomeActivity.class);

    @Test
    public void detailPeopleTest() {
        onView(withId(R.id.category_list)).perform(actionOnItemAtPosition(1, click()));
        onView(withId(R.id.swentity_list)).perform(actionOnItemAtPosition(0, click()));


        onView(withContentDescription("Navigate up")).check(matches(isDisplayed()));

        onView(allOf(withId(R.id.value),
                childAtPosition(childAtPosition(withId(R.id.birth_year), 1), 0)))
                .check(matches(withText("1981")));
        onView(allOf(withId(R.id.key),
                childAtPosition(childAtPosition(withId(R.id.birth_year), 1), 1)))
                .check(matches(withText("Birth year")));

        onView(allOf(withId(R.id.value),
                childAtPosition(childAtPosition(withId(R.id.eye), 1), 0)))
                .check(matches(withText("Dark")));
        onView(allOf(withId(R.id.key),
                childAtPosition(childAtPosition(withId(R.id.eye), 1), 1)))
                .check(matches(withText("Eye color")));

        onView(allOf(withId(R.id.value),
                childAtPosition(childAtPosition(withId(R.id.hair), 1), 0)))
                .check(matches(withText("Brown")));
        onView(allOf(withId(R.id.key),
                childAtPosition(childAtPosition(withId(R.id.hair), 1), 1)))
                .check(matches(withText("Hair color")));

        onView(allOf(withId(R.id.value),
                childAtPosition(childAtPosition(withId(R.id.height), 1), 0)))
                .check(matches(withText("181")));
        onView(allOf(withId(R.id.key),
                childAtPosition(childAtPosition(withId(R.id.height), 1), 1)))
                .check(matches(withText("Height")));

        onView(allOf(withId(R.id.value),
                childAtPosition(childAtPosition(withId(R.id.gender), 1), 0)))
                .check(matches(withText("Female")));
        onView(allOf(withId(R.id.key),
                childAtPosition(childAtPosition(withId(R.id.gender), 1), 1)))
                .check(matches(withText("Gender")));
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
