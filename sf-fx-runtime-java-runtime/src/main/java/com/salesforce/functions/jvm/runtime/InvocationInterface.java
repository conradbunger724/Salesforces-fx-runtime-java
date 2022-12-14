/*
 * Copyright (c) 2022, salesforce.com, inc.
 * All rights reserved.
 * SPDX-License-Identifier: BSD-3-Clause
 * For full license text, see the LICENSE file in the repo root or https://opensource.org/licenses/BSD-3-Clause
 */
package com.salesforce.functions.jvm.runtime;

import com.salesforce.functions.jvm.runtime.project.ProjectFunction;

/**
 * An InvocationInterface provides an interface for the user to invoke their function. This could be
 * an embedded web server that translates requests into function calls, a handler for a binary
 * protocol, a reader for a queue of function calls or anything else.
 */
public interface InvocationInterface<T, R, E extends Throwable> {
  /**
   * Starts the InvocationInterface for the given function. Implementations are supposed to return
   * as soon as they are able to serve function invocations.
   *
   * @param projectFunction The function to expose via this InvocationInterface.
   * @throws Exception When the implementation cannot recover from an error and needs to terminate.
   * @see #stop()
   */
  void start(ProjectFunction<T, R, E> projectFunction) throws Exception;

  /**
   * Stops the InvocationInterface.
   *
   * @throws Exception When the implementation cannot recover from an error and needs to terminate.
   * @see #start(ProjectFunction)
   */
  void stop() throws Exception;

  /**
   * Blocks until the InvocationInterface wants to stop itself.
   *
   * @throws Exception When the implementation cannot recover from an error and needs to terminate.
   */
  void block() throws Exception;

  /**
   * Returns if the InvocationInterface is started.
   *
   * @return If the InvocationInterface is started.
   * @see #start(ProjectFunction)
   */
  boolean isStarted();
}
