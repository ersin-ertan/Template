package com.nullcognition.template.di.component;

import com.nullcognition.template.activity.second.SecondActivity;
import com.nullcognition.template.di.builder.ActivityComponentBuilder;
import com.nullcognition.template.di.module.ActivityModule;
import com.nullcognition.template.di.scope.ActivityScope;
import dagger.Module;
import dagger.Subcomponent;

/**
 * Created by mms on 12/20/16.
 */

@ActivityScope @Subcomponent(modules = SecondActivityComponent.SecondActivityModule.class)
public interface SecondActivityComponent extends ActivityComponent<SecondActivity> {

  @Subcomponent.Builder interface Builder
      extends ActivityComponentBuilder<SecondActivityModule, SecondActivityComponent> {
  }

  @Module class SecondActivityModule extends ActivityModule<SecondActivity> {
    SecondActivityModule(SecondActivity activity) {
      super(activity);
    }
  }
}