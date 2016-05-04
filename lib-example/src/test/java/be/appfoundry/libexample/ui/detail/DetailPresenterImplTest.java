package be.appfoundry.libexample.ui.detail;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class DetailPresenterImplTest {
    DetailMVPContract.DetailPresenter detailPresenter;
    MockDetailView mockDetailView;

    @Before
    public void setUp() throws Exception {
        this.detailPresenter = new DetailPresenterImpl();
        this.mockDetailView = new MockDetailView();
    }

    @Test
    public void preConditions() throws Exception{
        assertNotNull(detailPresenter);
    }

    @Test
    public void testGetData() throws Exception {
        detailPresenter.attachView(mockDetailView);
        assertNull(mockDetailView.dataObject);
        detailPresenter.getDetailData();
        assertNotNull(mockDetailView.dataObject);
    }

    @Test
    public void testAttachView() throws Exception {
        assertNull(mockDetailView.dataObject);
        detailPresenter.attachView(mockDetailView);
        detailPresenter.getDetailData();
        assertNotNull(mockDetailView.dataObject);
    }

    @Test
    public void testDetachView() throws Exception {
        assertNull(mockDetailView.dataObject);
        detailPresenter.attachView(mockDetailView);
        detailPresenter.detachView();
        detailPresenter.getDetailData();
        assertNull(mockDetailView.dataObject);
    }
}
