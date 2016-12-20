package com.nullcognition.template;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.instacart.library.truetime.TrueTimeRx;
import com.jakewharton.threetenabp.AndroidThreeTen;
import com.jenzz.appstate.RxAppStateMonitor;
import com.nullcognition.template.di.builder.ActivityComponentBuilder;
import com.nullcognition.template.di.builder.HasActivitySubcomponentBuilders;
import com.nullcognition.template.di.component.AppComponent;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import rx.schedulers.Schedulers;

/**
 * Created by mms on 12/20/16.
 */

public class App extends Application implements HasActivitySubcomponentBuilders {

  private AppComponent appComponent;
  public static RefWatcher refWatcher;

  @Inject Map<Class<? extends Activity>, Provider<ActivityComponentBuilder>>
      activityComponentBuilders;

  @Override public void onCreate() {
    super.onCreate();

    if (LeakCanary.isInAnalyzerProcess(this)) return;
    refWatcher = LeakCanary.install(this);

    appComponent = DaggerAppComponent.create();
    appComponent.inject(this);

    AndroidThreeTen.init(this);

    TrueTimeRx.build()
        .withSharedPreferences(this)
        .initializeRx("0.north-america.pool.ntp.org")
        .subscribeOn(Schedulers.io())
        .subscribe(date -> {
          // TrueTimeRx.now(); to get the true time of now
        }, Throwable::printStackTrace);

    RxAppStateMonitor.monitor(this).subscribe(appState -> {
      switch (appState) {
        case BACKGROUND:
          break;
        case FOREGROUND:
          break;
      }
    });

    //CalligraphyConfig.initDefault(
    //    new CalligraphyConfig.Builder().setDefaultFontPath("fonts/AvenirLTStd-Roman.otf")
    //        .setFontAttrId(R.attr.fontPath)
    //        .build());
  }

  @Override public ActivityComponentBuilder getActivityComponentBuilder(
      Class<? extends Activity> activityClass) {
    return activityComponentBuilders.get(activityClass).get();
  }

  public static HasActivitySubcomponentBuilders get(Context context) {
    return ((HasActivitySubcomponentBuilders) context.getApplicationContext());
  }
}
