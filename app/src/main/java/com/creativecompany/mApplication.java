package com.creativecompany;

import android.app.Application;
import android.content.Context;

import com.avos.avoscloud.AVOSCloud;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by 45089 on 2018/4/15.
 */

public class mApplication extends Application {
    private RefWatcher refWatcher;

    public static RefWatcher getRefWatcher(Context context) {
        mApplication application = (mApplication) context.getApplicationContext();
        return application.refWatcher;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        refWatcher = LeakCanary.install(this);
        AVOSCloud.initialize(this, "Kjn89QAygzlLClb5APRESeTU-gzGzoHsz", "KLS2iBjTgX2AOUkdNCAkmPKl");
        AVOSCloud.setDebugLogEnabled(true);

    }
}
