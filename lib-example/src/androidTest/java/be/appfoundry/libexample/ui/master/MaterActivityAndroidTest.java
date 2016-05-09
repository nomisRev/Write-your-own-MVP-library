package be.appfoundry.libexample.ui.master;

import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import be.appfoundry.libexample.R;
import be.appfoundry.libexample.service.DataServiceImpl;
import be.appfoundry.libexample.ui.detail.DetailActivity;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.ComponentNameMatchers.hasClassName;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MaterActivityAndroidTest {

    @Rule public ActivityTestRule<MasterActivity> mainActivityTestRule =
        new ActivityTestRule<>(MasterActivity.class);

    @Test
    public void preConditions() {
        assertNotNull(mainActivityTestRule.getActivity());
    }

    @Test
    public void testDataViewDisplayed() {
        onView(withId(R.id.data_view)).check(matches(isDisplayed()));
    }

    @Test
    public void testDetailButtonShown() {
        onView(withId(R.id.detail_button)).check(matches(isDisplayed()));
    }

    @Test
    public void testShowData() {
        onView(withId(R.id.data_view)).check(matches(withText(DataServiceImpl.MASTER_STRING)));
    }

    @Test
    public void testDetailButtonClicked() {
        Intents.init();

        onView(withId(R.id.detail_button)).perform(click());
        intended(hasComponent(hasClassName(DetailActivity.class.getName())));
    }
}
