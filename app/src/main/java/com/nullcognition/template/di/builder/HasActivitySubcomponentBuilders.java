package com.nullcognition.template.di.builder;

import android.app.Activity;

/**
 * Created by mms on 12/20/16.
 */

public interface HasActivitySubcomponentBuilders {
  ActivityComponentBuilder getActivityComponentBuilder(Class<? extends Activity> activityClass);
}