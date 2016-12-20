package com.nullcognition.template.controller;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by mms on 12/20/16.
 */

public abstract class BaseController extends RefWatchingController {

  final protected CompositeSubscription compSub = new CompositeSubscription();

  protected BaseController() {
  }

  protected BaseController(Bundle args) {
    super(args);
  }

  @Override protected void onDestroyView(@NonNull View view) {
    if (compSub.hasSubscriptions()) compSub.clear();
    super.onDestroyView(view);
  }

  @Override protected void onViewBound(@NonNull View view) {
    super.onViewBound(view);
  }

  protected void initToolbar(Toolbar toolbar) {
    if (toolbar != null) {
      toolbar.setOnMenuItemClickListener(this::onOptionsItemSelected);
      toolbar.setTitle(getTitle());
    }
  }

  abstract protected String getTitle();
}