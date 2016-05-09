package be.appfoundry.mvpimplementation.ui;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import be.appfoundry.mvpimplementation.R;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityInstrumentationTest {
    @Rule public ActivityTestRule<MainActivity> mainActivityTestRule =
        new ActivityTestRule<>(
            MainActivity.class,
            false,    // initialTouchMode
            false);   // launchActivity. False to set intent per test);

    @Test
    public void testDataViewDisplayed() {
        onView(withId(R.id.data_view)).check(matches(isDisplayed()));
    }

    @Test
    public void testShowData() {
        onView(withId(R.id.data_view)).check(matches(withText("Fake dataObject")));
    }

    @Test
    public void testSnackbar() {
        onView(snackbarWithText("Test")).check(matches(isDisplayed()));
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private void launchDefaultMainActivity() {
        mainActivityTestRule.launchActivity(null); //Launch activity with default intent
    }


    private Matcher<View> snackbarWithText(String text) {
        return allOf(withId(android.support.design.R.id.snackbar_text), withText(text));
    }
}
