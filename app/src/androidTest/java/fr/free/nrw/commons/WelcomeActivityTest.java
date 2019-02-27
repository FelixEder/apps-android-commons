package fr.free.nrw.commons;

import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import fr.free.nrw.commons.contributions.MainActivity;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.anything;
import static org.junit.Assert.*;

public class WelcomeActivityTest {

    /**
     * Rule that is executed before tests that sets up the AppActivity before testing.
     */
    @Rule
    public ActivityTestRule<WelcomeActivity> mAppActivityTestRule =
            new ActivityTestRule<>(WelcomeActivity.class, false, true);

    /**
     * Test to confirm the functional requirements WelcomeActivity.Feature1.1.Functional.Requirements.1-3
     *
     * * tests that the initial view elements welcomePager, welcomePagerIndicator and finishTutorialButton is displayed
     */
    @Test
    public void initialViewsExist() {
        onView(withId(R.id.welcomePager)).check(matches(isDisplayed()));
        onView(withId(R.id.welcomePagerIndicator)).check(matches(isDisplayed()));
        onView(withId(R.id.finishTutorialButton)).check(matches(isDisplayed()));
    }
}