package com.nullcognition.template.activity.first;

import android.os.Bundle;
import com.nullcognition.template.R;
import com.nullcognition.template.activity.BaseActivity;
import com.nullcognition.template.di.builder.HasActivitySubcomponentBuilders;
import com.nullcognition.template.di.component.FirstActivityComponent;

public class FirstActivity extends BaseActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_first);
  }

  @Override
  protected void injectMembers(HasActivitySubcomponentBuilders hasActivitySubcomponentBuilders) {
    ((FirstActivityComponent.Builder) hasActivitySubcomponentBuilders.getActivityComponentBuilder(
        FirstActivity.class)).activityModule(new FirstActivityComponent.FirstActivityModule(this))
        .build()
        .injectMembers(this);
  }
}
