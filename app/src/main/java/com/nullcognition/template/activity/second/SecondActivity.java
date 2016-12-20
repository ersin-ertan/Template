package com.nullcognition.template.activity.second;

import android.os.Bundle;
import com.nullcognition.template.R;
import com.nullcognition.template.activity.BaseActivity;
import com.nullcognition.template.di.builder.HasActivitySubcomponentBuilders;
import com.nullcognition.template.di.component.SecondActivityComponent;

public class SecondActivity extends BaseActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);
  }

  @Override
  protected void injectMembers(HasActivitySubcomponentBuilders hasActivitySubcomponentBuilders) {
    ((SecondActivityComponent.Builder) hasActivitySubcomponentBuilders.getActivityComponentBuilder(
        SecondActivity.class)).activityModule(
        new SecondActivityComponent.SecondActivityModule(this)).build().injectMembers(this);
  }
}