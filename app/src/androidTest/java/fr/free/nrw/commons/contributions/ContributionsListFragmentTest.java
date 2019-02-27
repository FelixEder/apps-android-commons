package fr.free.nrw.commons.contributions;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import fr.free.nrw.commons.R;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.core.IsNot.not;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ContributionsListFragmentTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    /**
     * Test to confirm the functional requirements ContributionsListFragment.Feature1.1.Functional.Requirements.1
     */
    @Test
    public void fabPlussClickTest(){
        onView(withId(R.id.fab_cameraa)).check(matches(not(isDisplayed())));
        onView(withId(R.id.fab_galleryy)).check(matches(not(isDisplayed())));
        onView(withId(R.id.contributionsList)).check(matches(isDisplayed()));
        onView(withId(R.id.fab_pluss)).perform(click());
        onView(withId(R.id.fab_cameraa)).check(matches(isDisplayed()));
        onView(withId(R.id.fab_galleryy)).check(matches(isDisplayed()));
    }

    /**
     * Test to confirm the functional requirements ContributionsListFragment.Feature1.1.Functional.Requirements.2
     */
    @Test
    public void fabPlussBackClickTest(){
        onView(withId(R.id.fab_cameraa)).check(matches(not(isDisplayed())));
        onView(withId(R.id.fab_galleryy)).check(matches(not(isDisplayed())));
        onView(withId(R.id.contributionsList)).check(matches(isDisplayed()));
        onView(withId(R.id.fab_pluss)).perform(click());
        onView(withId(R.id.fab_cameraa)).check(matches(isDisplayed()));
        onView(withId(R.id.fab_galleryy)).check(matches(isDisplayed()));

        onView(withId(R.id.fab_pluss)).perform(click());
    }

    /**
     * Test to confirm the functional requirements ContributionsListFragment.Feature1.1.Functional.Requirements.3
     */
    @Test
    public void fabGallaryyClickTest(){
        onView(withId(R.id.fab_cameraa)).check(matches(not(isDisplayed())));
        onView(withId(R.id.fab_galleryy)).check(matches(not(isDisplayed())));
        onView(withId(R.id.contributionsList)).check(matches(isDisplayed()));
        onView(withId(R.id.fab_pluss)).perform(click());
        onView(withId(R.id.fab_cameraa)).check(matches(isDisplayed()));
        onView(withId(R.id.fab_galleryy)).check(matches(isDisplayed()));

        onView(withId(R.id.fab_galleryy)).perform(click());
    }

    /**
     * Test to confirm the functional requirements ContributionsListFragment.Feature1.1.Functional.Requirements.4
     */
    @Test
    public void fabCameraaClickTest(){
        onView(withId(R.id.fab_cameraa)).check(matches(not(isDisplayed())));
        onView(withId(R.id.fab_galleryy)).check(matches(not(isDisplayed())));
        onView(withId(R.id.contributionsList)).check(matches(isDisplayed()));
        onView(withId(R.id.fab_pluss)).perform(click());
        onView(withId(R.id.fab_cameraa)).check(matches(isDisplayed()));
        onView(withId(R.id.fab_galleryy)).check(matches(isDisplayed()));

        onView(withId(R.id.fab_cameraa)).perform(click());
    }
}