package be.appfoundry.libexample.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DataServiceImplTest {

    DataServiceImpl dataService;

    @Before
    public void setUp() throws Exception {
        this.dataService = new DataServiceImpl();
    }

    @Test
    public void preConditions() throws Exception{
        assertNotNull(dataService);
    }

    @Test
    public void testGetMasterDataObject() throws Exception {
        assertNotNull(dataService.getMasterObject());
        assertEquals(DataServiceImpl.MASTER_STRING,dataService.getMasterObject().getDataString());
    }

    @Test
    public void testGetDetailDataObject() throws Exception {
        assertNotNull(dataService.getDetailObject());
        assertEquals(DataServiceImpl.DETAIL_STRING,dataService.getDetailObject().getDataString());
    }
}