package com.nullcognition.template.di.component;

import com.nullcognition.template.activity.first.FirstActivity;
import com.nullcognition.template.di.builder.ActivityComponentBuilder;
import com.nullcognition.template.di.module.ActivityModule;
import com.nullcognition.template.di.scope.ActivityScope;
import dagger.Module;
import dagger.Subcomponent;

/**
 * Created by mms on 12/20/16.
 */

@ActivityScope @Subcomponent(modules = FirstActivityComponent.FirstActivityModule.class)
public interface FirstActivityComponent extends ActivityComponent<FirstActivity> {

  @Subcomponent.Builder interface Builder
      extends ActivityComponentBuilder<FirstActivityModule, FirstActivityComponent> {
  }

  @Module class FirstActivityModule extends ActivityModule<FirstActivity> {
    FirstActivityModule(FirstActivity activity) {
      super(activity);
    }
  }
}