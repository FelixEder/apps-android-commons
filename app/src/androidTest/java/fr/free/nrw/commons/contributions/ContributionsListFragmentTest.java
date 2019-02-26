package fr.free.nrw.commons.contributions;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewAction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import com.squareup.haha.perflib.Main;
import fr.free.nrw.commons.R;
import fr.free.nrw.commons.upload.UploadActivity;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static org.hamcrest.EasyMock2Matchers.equalTo;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsNot.not;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ContributionsListFragmentTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    /**
     *
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
}