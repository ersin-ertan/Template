package com.nullcognition.template.di.module;

import com.nullcognition.template.di.scope.ActivityScope;
import dagger.Module;
import dagger.Provides;

/**
 * Created by mms on 12/20/16.
 */

@Module public abstract class ActivityModule<T> {
  protected final T activity;

  public ActivityModule(T activity) {
    this.activity = activity;
  }

  @Provides @ActivityScope public T provideActivity() {
    return activity;
  }
}