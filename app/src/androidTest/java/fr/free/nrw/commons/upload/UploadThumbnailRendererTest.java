package fr.free.nrw.commons.upload;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import fr.free.nrw.commons.R;
import fr.free.nrw.commons.contributions.MainActivity;
import fr.free.nrw.commons.quiz.QuizResultActivity;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class UploadThumbnailRendererTest {

    @Rule
    public ActivityTestRule<UploadActivity> activityTestRule = new ActivityTestRule<>(UploadActivity.class);

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test(){
        onView(withId(R.id.thumbnail)).check(matches(isDisplayed()));
        onView(withId(R.id.left_space)).check(matches(isDisplayed()));
        onView(withId(R.id.right_space)).check(matches(isDisplayed()));
    }
}

