/*
 * Copyright (c) 2022, salesforce.com, inc.
 * All rights reserved.
 * SPDX-License-Identifier: BSD-3-Clause
 * For full license text, see the LICENSE file in the repo root or https://opensource.org/licenses/BSD-3-Clause
 */
package com.salesforce.functions.jvm.runtime.json.exception;

public class JsonLibraryNotPresentException extends Exception {
  public JsonLibraryNotPresentException(String message, Throwable cause) {
    super(message, cause);
  }
}
