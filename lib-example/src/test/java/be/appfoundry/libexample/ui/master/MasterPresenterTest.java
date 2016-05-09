package be.appfoundry.libexample.ui.master;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class MasterPresenterTest {
    MasterMVPContract.MasterPresenter mainPresenter;
    MockMasterView mockMasterView;

    @Before
    public void setUp() throws Exception {
        this.mainPresenter = new MasterPresenter();
        this.mockMasterView = new MockMasterView();
    }

    @Test
    public void preConditions() throws Exception{
        assertNotNull(mainPresenter);
    }

    @Test
    public void testGetData() throws Exception {
        mainPresenter.attachView(mockMasterView);
        assertNull(mockMasterView.dataObject);
        mainPresenter.getData();
        assertNotNull(mockMasterView.dataObject);
    }

    @Test
    public void testAttachView() throws Exception {
        assertNull(mockMasterView.dataObject);
        mainPresenter.attachView(mockMasterView);
        mainPresenter.getData();
        assertNotNull(mockMasterView.dataObject);
    }

    @Test
    public void testDetachView() throws Exception {
        assertNull(mockMasterView.dataObject);
        mainPresenter.attachView(mockMasterView);
        mainPresenter.detachView();
        mainPresenter.getData();
        assertNull(mockMasterView.dataObject);
    }
}
