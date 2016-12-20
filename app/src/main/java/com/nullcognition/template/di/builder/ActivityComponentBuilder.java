package com.nullcognition.template.di.builder;

import com.nullcognition.template.di.component.ActivityComponent;
import com.nullcognition.template.di.module.ActivityModule;

/**
 * Created by mms on 12/20/16.
 */

public interface ActivityComponentBuilder<M extends ActivityModule, C extends ActivityComponent> {
  ActivityComponentBuilder<M, C> activityModule(M activityModule);

  C build();
}