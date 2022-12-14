/*
 * Copyright (c) 2022, salesforce.com, inc.
 * All rights reserved.
 * SPDX-License-Identifier: BSD-3-Clause
 * For full license text, see the LICENSE file in the repo root or https://opensource.org/licenses/BSD-3-Clause
 */
package com.salesforce.functions.jvm.runtime.sfjavafunction;

import com.salesforce.functions.jvm.runtime.cloudevent.SalesforceContextCloudEventExtension;
import com.salesforce.functions.jvm.runtime.cloudevent.SalesforceFunctionContextCloudEventExtension;
import com.salesforce.functions.jvm.runtime.sfjavafunction.exception.SalesforceFunctionException;
import io.cloudevents.CloudEvent;

public interface InvocationWrapper {
  Object invoke(
      Object payload,
      CloudEvent cloudEvent,
      SalesforceContextCloudEventExtension salesforceContext,
      SalesforceFunctionContextCloudEventExtension functionContext)
      throws SalesforceFunctionException;
}
