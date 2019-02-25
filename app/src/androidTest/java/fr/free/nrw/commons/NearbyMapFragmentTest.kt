package fr.free.nrw.commons

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.widget.TextView
import dagger.android.AndroidInjection.inject
import dagger.android.support.AndroidSupportInjection.inject

import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith

import fr.free.nrw.commons.kvstore.BasicKvStore
import fr.free.nrw.commons.nearby.NearbyMapFragment
import fr.free.nrw.commons.settings.SettingsActivity
import org.junit.Test
import fr.free.nrw.commons.contributions.MainActivity
import org.mockito.ArgumentMatchers.anyString


@LargeTest
@RunWith(AndroidJUnit4::class)
class NearbyMapFragmentTest {

    internal var prefs: BasicKvStore? = null

    val fragment = NearbyMapFragment()

    val testActivityRule = ActivityTestRule(MainActivity::class.java, true, true)

    @Rule
    fun rule() = testActivityRule

    @Test
    fun testFragmentName() {
        onView(withId(android.R.id.title)).check(matches(withText(anyString())))
    }


}
