package be.appfoundry.libexample.ui.detail;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import be.appfoundry.libexample.R;
import be.appfoundry.libexample.service.DataServiceImpl;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class DetailActivityAndroidTest {
    @Rule public ActivityTestRule<DetailActivity> detailActivityTestRule =
        new ActivityTestRule<>(DetailActivity.class);

    @Test
    public void preConditions() {
        assertNotNull(detailActivityTestRule.getActivity());
    }

    @Test
    public void testDataViewDisplayed() {
        onView(withId(R.id.data_view)).check(matches(isDisplayed()));
    }

    @Test
    public void testShowSnackbarButton() {
        onView(withId(R.id.show_snackbar)).check(matches(isDisplayed()));
    }

    @Test
    public void testShowData() {
        onView(withId(R.id.data_view)).check(matches(withText(DataServiceImpl.DETAIL_STRING)));
    }

    @Test
    public void testSnackbar() {
        onView(withId(R.id.show_snackbar)).perform(click());
        onView(snackbarWithText("Snackbar shown")).check(matches(isDisplayed()));
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private Matcher<View> snackbarWithText(String text) {
        return allOf(withId(android.support.design.R.id.snackbar_text), withText(text));
    }
}
