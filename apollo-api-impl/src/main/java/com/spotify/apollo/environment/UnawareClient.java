/*
 * -\-\-
 * Spotify Apollo API Implementations
 * --
 * Copyright (C) 2013 - 2015 Spotify AB
 * --
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * -/-/-
 */
package com.spotify.apollo.environment;

import com.spotify.apollo.Client;
import com.spotify.apollo.Request;
import com.spotify.apollo.Response;

import java.io.IOException;
import java.util.concurrent.CompletionStage;

import okio.ByteString;

import static java.util.Objects.requireNonNull;
import static java.util.Optional.empty;

/**
 * An apollo service Client that uses a {@link IncomingRequestAwareClient} with no incoming
 * {@link Request}.
 */
class UnawareClient implements Client {

  private final IncomingRequestAwareClient delegate;

  UnawareClient(IncomingRequestAwareClient delegate) {
    this.delegate = requireNonNull(delegate);
  }

  @Override
  public CompletionStage<Response<ByteString>> send(Request request) {
    return delegate.send(request, empty());
  }
}
