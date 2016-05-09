package be.appfoundry.libexample.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

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
    public void testNotNullThread() {
        Thread thread = ThreadFactory.provideNewThread(() -> {});
        assertNotNull(thread);
    }

    @Test
    public void testDifferentNewThread() {
        Thread thread1 = ThreadFactory.provideNewThread(() -> { });
        Thread thread2 = ThreadFactory.provideNewThread(() -> { });
        assertNotEquals(thread1.getId(),thread2.getId());
    }

}