package com.nullcognition.template.di.component;

import com.nullcognition.template.App;
import com.nullcognition.template.di.module.ActivityBindingModule;
import com.nullcognition.template.di.module.AppModule;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by mms on 12/20/16.
 */

@Singleton @Component(modules = { AppModule.class, ActivityBindingModule.class })
public interface AppComponent {

  App inject(App application);
}