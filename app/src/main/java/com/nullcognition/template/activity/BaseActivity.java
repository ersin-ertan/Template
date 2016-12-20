package com.nullcognition.template.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.bluelinelabs.conductor.Router;
import com.nullcognition.template.App;
import com.nullcognition.template.di.builder.HasActivitySubcomponentBuilders;
import com.nullcognition.template.di.component.ActivityComponent;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by mms on 12/20/16.
 */

public abstract class BaseActivity extends AppCompatActivity {

  protected Router router;
  protected ActivityComponent activityComponent;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    injectMembers(App.get(this));
  }

  protected abstract void injectMembers(
      HasActivitySubcomponentBuilders hasActivitySubcomponentBuilders);

  @Override protected void attachBaseContext(Context newBase) {
    super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
  }

  @Override protected void onDestroy() {
    router.onActivityDestroyed(this);
    activityComponent = null;
    super.onDestroy();
  }
}
