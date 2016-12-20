package com.nullcognition.template.di.component;

import android.app.Activity;
import dagger.MembersInjector;

/**
 * Created by mms on 12/20/16.
 */

public interface ActivityComponent<A extends Activity> extends MembersInjector<A> {
}