package com.nullcognition.template.di.module;

import com.nullcognition.template.activity.first.FirstActivity;
import com.nullcognition.template.activity.second.SecondActivity;
import com.nullcognition.template.di.builder.ActivityComponentBuilder;
import com.nullcognition.template.di.component.FirstActivityComponent;
import com.nullcognition.template.di.component.SecondActivityComponent;
import com.nullcognition.template.di.key.ActivityKey;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by mms on 12/20/16.
 */

@Module(subcomponents = { FirstActivityComponent.class, SecondActivityComponent.class })
public abstract class ActivityBindingModule {

  @Binds @IntoMap @ActivityKey(FirstActivity.class)
  public abstract ActivityComponentBuilder firstActivityComponentBuilder(
      FirstActivityComponent.Builder impl);

  @Binds @IntoMap @ActivityKey(SecondActivity.class)
  public abstract ActivityComponentBuilder secondActivityComponentBuilder(
      SecondActivityComponent.Builder impl);
}