package fr.free.nrw.commons.contributions;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import fr.free.nrw.commons.R;

import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityUITest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void initialViewsExist() {
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()));
        onView(withId(R.id.tab_layout)).check(matches(isDisplayed()));
        onView(withId(R.id.pager)).check(matches(isDisplayed()));
        onView(withId(R.id.navigation_view)).check(matches(isDisplayed()));
    }

    @Test
    public void onClickNearbyInfoTest() {
    }

    @Test
    public void onClickNotificationTest() {
    }
}