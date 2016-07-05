package be.appfoundry.mvpimplementation.ui;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import be.appfoundry.mvpimplementation.R;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityAndroidTest {
    @Rule public ActivityTestRule<MainActivity> mainActivityTestRule =
        new ActivityTestRule<>(MainActivity.class,false,false);

    @Test
    public void preConditions() {
        assertNull(mainActivityTestRule.getActivity());
        launchDefaultIntent();
        assertNotNull(mainActivityTestRule.getActivity());
    }

    @Test
    public void testDataViewDisplayed() {
        launchDefaultIntent();
        onView(withId(R.id.data_view)).check(matches(isDisplayed()));
    }

    @Test
    public void testShowData() {
        launchDefaultIntent();
        onView(withId(R.id.data_view)).check(matches(withText("Fake dataObject")));
    }

    @Test
    public void isAlive() {
       launchDefaultIntent();

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private void launchDefaultIntent() {
        mainActivityTestRule.launchActivity(null);
    }
}
