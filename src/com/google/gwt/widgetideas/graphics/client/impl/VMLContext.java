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

import com.google.gwt.widgetideas.graphics.client.GWTCanvas;

/**
 * The VML context abstraction for the Internet Explorer implementation.
 */
public class VMLContext {

  public float arcScaleX;

  public float arcScaleY;

  public float fillAlpha;

  public String fillStyle;
  
  public CanvasGradientImplIE6 fillGradient;
  
  public CanvasGradientImplIE6 strokeGradient;

  public float globalAlpha;

  public String globalCompositeOperation;

  public String lineCap;

  public String lineJoin;

  public float lineWidth;

  public float[] matrix = new float[9];

  public float miterLimit;

  public float strokeAlpha;

  public String strokeStyle;

  public VMLContext() {

    // load identity matrix
    matrix[0] = 1.0f; matrix[1] = 0.0f; matrix[2] = 0.0f;
    matrix[3] = 0.0f; matrix[4] = 1.0f; matrix[5] = 0.0f;
    matrix[6] = 0.0f; matrix[7] = 0.0f; matrix[8] = 1.0f;

    // init other stuff
    arcScaleX         =  1.0f;
    arcScaleY         =  1.0f;
    globalAlpha         =  1.0f;
    strokeAlpha         =  1.0f;
    fillAlpha         =  1.0f;
    miterLimit          = 10.0f;
    lineWidth         =  1.0f;
    lineCap           =  GWTCanvasImplIE6.BUTT;
    lineJoin          =  GWTCanvas.MITER;
    strokeStyle         =  "#000";
    fillStyle         =  "#000";
    globalCompositeOperation  =  GWTCanvasImplIE6.SOURCE_OVER;
  }

  public VMLContext(VMLContext ctx) {

    // copy the matrix
    matrix[0] = ctx.matrix[0]; matrix[1] = ctx.matrix[1]; matrix[2] = ctx.matrix[2];
    matrix[3] = ctx.matrix[3]; matrix[4] = ctx.matrix[4]; matrix[5] = ctx.matrix[5];
    matrix[6] = ctx.matrix[6]; matrix[7] = ctx.matrix[7]; matrix[8] = ctx.matrix[8];

    // copy other stuff
    arcScaleX         = ctx.arcScaleX;
    arcScaleY         = ctx.arcScaleY;
    globalAlpha         = ctx.globalAlpha;
    strokeAlpha         = ctx.strokeAlpha;
    fillAlpha         = ctx.fillAlpha;
    miterLimit          = ctx.miterLimit;
    lineWidth         = ctx.lineWidth;
    lineCap           = ctx.lineCap;
    lineJoin          = ctx.lineJoin;
    strokeStyle         = ctx.strokeStyle;
    fillStyle         = ctx.fillStyle;
    fillGradient = ctx.fillGradient;
    strokeGradient = ctx.strokeGradient;
    globalCompositeOperation  = ctx.globalCompositeOperation;
  }
}
