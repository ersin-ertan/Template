package com.nullcognition.template.di.key;

import android.app.Activity;
import dagger.MapKey;

/**
 * Created by mms on 12/20/16.
 */

@MapKey public @interface ActivityKey {
  Class<? extends Activity> value();
}