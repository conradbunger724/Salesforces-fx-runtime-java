/*
 * Copyright (c) 2022, salesforce.com, inc.
 * All rights reserved.
 * SPDX-License-Identifier: BSD-3-Clause
 * For full license text, see the LICENSE file in the repo root or https://opensource.org/licenses/BSD-3-Clause
 */
package com.salesforce.functions.jvm.runtime.project;

import java.util.List;

public interface ProjectFunctionsScanner<
    F extends ProjectFunction<T, R, E>, T, R, E extends Throwable> {
  List<F> scan(Project project);
}
