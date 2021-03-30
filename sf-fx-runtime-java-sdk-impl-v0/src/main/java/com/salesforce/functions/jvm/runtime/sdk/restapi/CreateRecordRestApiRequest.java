/*
 * Copyright (c) 2021, salesforce.com, inc.
 * All rights reserved.
 * SPDX-License-Identifier: BSD-3-Clause
 * For full license text, see the LICENSE file in the repo root or https://opensource.org/licenses/BSD-3-Clause
 */
package com.salesforce.functions.jvm.runtime.sdk.restapi;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Optional;
import org.apache.http.client.utils.URIBuilder;

public class CreateRecordRestApiRequest implements RestApiRequest<ModifyRecordResult> {
  private final String type;
  private final Map<String, JsonPrimitive> values;

  public CreateRecordRestApiRequest(String type, Map<String, JsonPrimitive> values) {
    this.type = type;
    this.values = values;
  }

  @Override
  public HttpMethod getHttpMethod() {
    return HttpMethod.POST;
  }

  @Override
  public URI createUri(URI baseUri, String apiVersion) {
    try {
      return new URIBuilder(baseUri)
          .setPathSegments("services", "data", "v" + apiVersion, "sobjects", type)
          .build();
    } catch (URISyntaxException e) {
      throw new RuntimeException("Unexpected URISyntaxException!", e);
    }
  }

  @Override
  public Optional<JsonElement> getBody() {
    return Optional.of(new Gson().toJsonTree(values));
  }

  @Override
  public ModifyRecordResult processResponse(
      int statusCode, Map<String, String> headers, JsonElement body) {
    if (statusCode == 201) {
      return new ModifyRecordResult(body.getAsJsonObject().get("id").getAsString());
    }

    throw new RuntimeException(
        "Unimplemented error handling! Status code: " + statusCode + "\n" + body.toString());
  }
}