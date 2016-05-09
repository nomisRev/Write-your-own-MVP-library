package be.appfoundry.mvpimplementation.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class ThreadFactoryTest {

    //UnsupportedOperationException thrown in the private constructor gets wrapped in InvocationTargetException
    //https://docs.oracle.com/javase/7/docs/api/java/lang/reflect/InvocationTargetException.html
    @Test(expected = InvocationTargetException.class)
    public void testPrivateConstructor() throws Exception{
        Constructor<ThreadFactory> threadFactoryConstructor = ThreadFactory.class.getDeclaredConstructor();
        threadFactoryConstructor.setAccessible(true);
        threadFactoryConstructor.newInstance();
    }

    @Test
    public void testNewThread() {
        Thread thread1 = ThreadFactory.provideNewThread(() -> { });
        Thread thread2 = ThreadFactory.provideNewThread(() -> { });
        assertNotEquals(thread1.getId(),thread2.getId());
    }
}