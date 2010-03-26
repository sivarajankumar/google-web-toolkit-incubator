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
package com.google.gwt.libideas.event.shared;

/**
 * AbstractEvent is the root of all events.
 *
 * @param <T> the type of handler used for this event
 */
public abstract class AbstractEvent<T extends EventHandler> {

  /**
   * Key class used to register events with HandlerManager.
   */
  public static class Key<T extends EventHandler> {

    static int EXPECTED_MAX_HANDLERS_PER_WIDGET = 5;

    private static int INDEX_SOURCE;

    private int index;

    {
      index = INDEX_SOURCE;
      INDEX_SOURCE += EXPECTED_MAX_HANDLERS_PER_WIDGET;
    }

    // We override hashcode to make it as efficent as possible.
    @Override
    public int hashCode() {
      return index;
    }
  }

  private Object source;

  private Object userData;

  protected AbstractEvent() {
  }

  /**
   * Returns the source that generated the event.
   */
  public Object getSource() {
    return source;
  }

  /**
   * Returns a user attached object to this event.
   */
  public Object getUserData() {
    return userData;
  }

  /**
   * Attaches a user-defined object to this event.
   */
  public void setUserData(Object userData) {
    this.userData = userData;
  }

  /**
   * Fires event for given handler type.
   *
   * @param handler of type T
   */
  protected abstract void fireEvent(T handler);

  /**
   * Returns the Key used to register this event.
   */
  protected abstract Key getKey();

  /**
   * Set the source that triggered this event.
   *
   * @param source An object of type F
   */
  void setSource(Object source) {
    this.source = source;
  }
}
