package be.appfoundry.mvpimplementation.service;

import org.junit.Before;
import org.junit.Test;

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
    public void testGetDataObject() throws Exception {
        assertNotNull(dataService.getDataObject());
    }
}