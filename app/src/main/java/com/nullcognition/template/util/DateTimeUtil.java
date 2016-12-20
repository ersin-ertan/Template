package com.nullcognition.template.util;

import com.instacart.library.truetime.TrueTimeRx;
import org.threeten.bp.DateTimeUtils;
import org.threeten.bp.Instant;

/**
 * Created by mms on 12/20/16.
 */

public class DateTimeUtil {

  private DateTimeUtil() {
    throw new IllegalStateException();
  }

  public static Instant now() {
    // throws IllegalStateException if fails to init
    return DateTimeUtils.toInstant(TrueTimeRx.now());
  }
}
