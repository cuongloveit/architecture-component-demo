package com.example.architecturecomponentdemo.base;

import android.support.annotation.NonNull;

import com.example.architecturecomponentdemo.BuildConfig;

import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.manifest.AndroidManifest;
import org.robolectric.res.FileFsFile;
import org.robolectric.res.FsFile;

import java.lang.reflect.Method;

/**
 * Created by cuong on 7/4/17.
 */

public class AppTestRunner extends RobolectricTestRunner {
    /**
     * @param testClass the test class to be run
     * @throws InitializationError if junit says so
     */

    // This value should be changed as soon as Robolectric will support newer api.
    private static final int SDK_EMULATE_LEVEL = 23;

    public AppTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    @Override
    protected AndroidManifest getAppManifest(Config config) {
        AndroidManifest appManifest = super.getAppManifest(config);
        FsFile androidManifestFile = appManifest.getAndroidManifestFile();

        if (androidManifestFile.exists()) {
            return appManifest;
        } else {
            String moduleRoot = getModuleRootPath(config);
            androidManifestFile = FileFsFile.from(moduleRoot, appManifest.getAndroidManifestFile().getPath().replace("bundles", "manifests/full"));
            FsFile resDirectory = FileFsFile.from(moduleRoot, appManifest.getResDirectory().getPath().replace("/res","").replace("bundles","res/merged"));
            FsFile assetsDirectory = FileFsFile.from(moduleRoot, appManifest.getAssetsDirectory().getPath().replace("/assets", "").replace("bundles", "assets"));
            return new AndroidManifest(androidManifestFile, resDirectory, assetsDirectory);
        }
    }

    private String getModuleRootPath(Config config) {
        String moduleRoot = config.constants().getResource("").toString().replace("file:", "");
        return moduleRoot.substring(0, moduleRoot.indexOf("/build"));
    }

    @Override
    public Config getConfig(Method method) {
        final Config config = super.getConfig(method);
        return new Config.Implementation(
                new int[]{SDK_EMULATE_LEVEL},
                config.manifest(),
                config.qualifiers(),
                config.packageName(),
                config.abiSplit(),
                config.resourceDir(),
                config.assetDir(),
                config.buildDir(),
                config.shadows(),
                config.instrumentedPackages(),
                TestApplication.class,
                config.libraries(),
                config.constants() == Void.class ? BuildConfig.class : config.constants()
        );
    }

    @NonNull
    public static TestApplication getApplication() {
        return (TestApplication) RuntimeEnvironment.application;
    }
}
