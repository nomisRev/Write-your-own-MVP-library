package be.appfoundry.mvpimplementation.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ServiceFactoryTest {

    //UnsupportedOperationException thrown in the private constructor gets wrapped in InvocationTargetException
    //https://docs.oracle.com/javase/7/docs/api/java/lang/reflect/InvocationTargetException.html
    @Test(expected = InvocationTargetException.class)
    public void testPrivateConstructor() throws Exception{
        Constructor<ServiceFactory> serviceFactoryConstructor = ServiceFactory.class.getDeclaredConstructor();
        serviceFactoryConstructor.setAccessible(true);
        ServiceFactory serviceFactory = serviceFactoryConstructor.newInstance();
    }

    @Test
    public void testProvideDataService() throws Exception {
        assertNotNull(ServiceFactory.provideDataService());
    }
}