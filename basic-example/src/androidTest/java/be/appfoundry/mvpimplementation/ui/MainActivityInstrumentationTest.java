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
import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityInstrumentationTest {
    @Rule public ActivityTestRule<MainActivity> mainActivityTestRule =
        new ActivityTestRule<>(MainActivity.class);

    @Test
    public void preConditions() {
        assertNotNull(mainActivityTestRule.getActivity());
    }

    @Test
    public void testDataViewDisplayed() {
        onView(withId(R.id.data_view)).check(matches(isDisplayed()));
    }

    @Test
    public void testShowData() {
        onView(withId(R.id.data_view)).check(matches(withText("Fake dataObject")));
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private Matcher<View> snackbarWithText(String text) {
        return allOf(withId(android.support.design.R.id.snackbar_text), withText(text));
    }
}
