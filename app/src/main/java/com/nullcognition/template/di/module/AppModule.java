package com.nullcognition.template.di.module;

import android.content.Context;
import com.nullcognition.template.App;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by mms on 12/20/16.
 */

@Module public class AppModule {

  private final App application;

  public AppModule(App application) {
    this.application = application;
  }

  @Provides @Singleton public Context provideAppContext() {
    return application.getApplicationContext();
  }

  @Provides @Singleton public App provideApp() {
    return application;
  }
}
