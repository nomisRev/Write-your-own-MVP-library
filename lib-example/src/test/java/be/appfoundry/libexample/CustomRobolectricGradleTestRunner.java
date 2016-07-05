package be.appfoundry.libexample;

import java.lang.reflect.Method;
import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

public class CustomRobolectricGradleTestRunner extends RobolectricGradleTestRunner {
    private static final int[] MAX_SDK_LEVEL = { 21 };

    public CustomRobolectricGradleTestRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    public Config getConfig(Method method) {
        Config config = super.getConfig(method);
        /*
        Fixing up the Config:
		* SDK can not be higher than 21
		* constants must point to a real BuildConfig class
		 */
        config = new Config.Implementation(MAX_SDK_LEVEL, config.manifest(), config.qualifiers(),
            config.packageName(), config.resourceDir(), config.assetDir(), config.shadows(),
            config.application(), config.libraries(), ensureBuildConfig(config.constants()));

        return config;
    }

    private Class<?> ensureBuildConfig(Class<?> constants) {
        if (constants == Void.class) {
            return BuildConfig.class;
        }
        return constants;
    }
}