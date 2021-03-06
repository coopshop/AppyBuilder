// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2016-2018 AppyBuilder.com, All Rights Reserved - Info@AppyBuilder.com
// https://www.gnu.org/licenses/gpl-3.0.en.html

// Copyright 2009-2011 Google, All Rights reserved
// Copyright 2011-2012 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.client.widgets.properties;

import static com.google.appinventor.client.Ode.MESSAGES;

/**
 * Property editor for float values.
 *
 * @author lizlooney@google.com (Liz Looney)
 */
public class FloatPropertyEditor extends TextPropertyEditor {

  @Override
  protected boolean validateKeyCode(char keyCode) {
    // First check whether it's a normal character, not a control character.
    if (keyCode >= ' ') {
      if (keyCode >= '0' && keyCode <= '9') {
        return true;
      }
      if (keyCode == '+' || keyCode == '-') {
        return true;
      }
      if (keyCode == '.') {
        return true;
      }
      return false;
    }
    return super.validateKeyCode(keyCode);
  }

  @Override
  protected void validate(String text) throws InvalidTextException {
    super.validate(text);

    // Make sure it's a float.
    try {
      Float.parseFloat(text);
    } catch (NumberFormatException e) {
      throw new InvalidTextException(MESSAGES.notAFloat(text));
    }
  }
}
