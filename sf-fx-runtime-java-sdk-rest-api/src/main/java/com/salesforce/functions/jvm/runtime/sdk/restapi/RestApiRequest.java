/*
 * Copyright (c) 2022, salesforce.com, inc.
 * All rights reserved.
 * SPDX-License-Identifier: BSD-3-Clause
 * For full license text, see the LICENSE file in the repo root or https://opensource.org/licenses/BSD-3-Clause
 */
package com.salesforce.functions.jvm.runtime.sdk.restapi;

import com.google.gson.JsonElement;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Optional;

public interface RestApiRequest<T> {
  HttpMethod getHttpMethod();

  URI createUri(URI baseUri, String apiVersion) throws URISyntaxException;

  Optional<JsonElement> getBody();

  T processResponse(int statusCode, Map<String, String> headers, JsonElement body)
      throws RestApiErrorsException;
}
