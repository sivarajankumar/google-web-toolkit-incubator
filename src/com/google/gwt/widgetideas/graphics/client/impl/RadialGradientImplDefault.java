/*
 * Copyright 2008 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.widgetideas.graphics.client.impl;

import com.google.gwt.user.client.Element;
/**
 *  Default deferred binding of Gradient Factory will create instances of this class
 *  for RadialGradients.
 */
public class RadialGradientImplDefault extends CanvasGradientImplDefault {

  public RadialGradientImplDefault(float x0, float y0, float r0,
      float x1, float y1, float r1, Element c) {
    createNativeGradientObject(x0,y0,r0,x1,y1,r1, c);
  }

  private native void createNativeGradientObject(float x0, float y0, float r0, float x1, float y1, float r1, Element c) /*-{
    var ctx = c.getContext('2d');
    var gradient = ctx.createRadialGradient(x0,y0,r0,x1,y1,r1);
    this.@com.google.gwt.widgetideas.graphics.client.impl.CanvasGradientImplDefault::setNativeGradient(Lcom/google/gwt/core/client/JavaScriptObject;)(gradient);
  }-*/;

}
