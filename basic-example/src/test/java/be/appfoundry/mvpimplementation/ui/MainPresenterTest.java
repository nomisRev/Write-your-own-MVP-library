package be.appfoundry.mvpimplementation.ui;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class MainPresenterTest {

    MVPContract.MainPresenter mainPresenter;
    MockMainView mockMainView;

    @Before
    public void setUp() throws Exception {
        this.mainPresenter = new MainPresenter();
        this.mockMainView = new MockMainView();
    }

    @Test
    public void preConditions() throws Exception{
        assertNotNull(mainPresenter);
    }

    @Test
    public void testGetData() throws Exception {
        mainPresenter.attachView(mockMainView);
        assertNull(mockMainView.dataObject);
        mainPresenter.getData();
        assertNotNull(mockMainView.dataObject);
    }

    @Test
    public void testAttachView() throws Exception {
        assertNull(mockMainView.dataObject);
        mainPresenter.attachView(mockMainView);
        mainPresenter.getData();
        assertNotNull(mockMainView.dataObject);
    }

    @Test
    public void testDetachView() throws Exception {
        assertNull(mockMainView.dataObject);
        mainPresenter.attachView(mockMainView);
        mainPresenter.detachView();
        mainPresenter.getData();
        assertNull(mockMainView.dataObject);
    }
}