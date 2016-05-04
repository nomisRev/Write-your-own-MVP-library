package be.appfoundry.libexample.ui.detail;

import android.app.Activity;
import android.widget.TextView;
import be.appfoundry.libexample.BuildConfig;
import be.appfoundry.libexample.R;
import be.appfoundry.libexample.model.DataObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class DetailActivityTest {
    final String dataString = "TEST STRING";
    DataObject dataObject;

    @Before
    public void setUp() throws Exception {
        dataObject = new DataObject(dataString);
    }

    @Test
    public void preConditions() {
        Activity activity = Robolectric.buildActivity(DetailActivity.class).get();
        assertNotNull(activity);
    }

    @Test
    public void testDataView() {
        final Activity activity = Robolectric.buildActivity(DetailActivity.class).create().start().resume().visible().get();
        final TextView dataView = (TextView) activity.findViewById(R.id.data_view);
        assertNotNull(dataView);
    }

    @Test
    public void testShowData() {
        final DetailActivity activity = Robolectric.buildActivity(DetailActivity.class).create().start().resume().visible().get();
        activity.showData(dataObject);
        final TextView dataView = (TextView) activity.findViewById(R.id.data_view);
        assertEquals(dataString,dataView.getText().toString());
    }
}
