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
package com.spotify.apollo.request;

import com.spotify.apollo.dispatch.Endpoint;
import com.spotify.apollo.route.RuleMatch;

import java.util.function.BiConsumer;

/**
 * A runner for request that will handle matching the request against an {@link Endpoint}.
 */
@FunctionalInterface
public interface RequestRunnable {

  /**
   * Do the matching and hand over the match to the given continuation {@link BiConsumer}.
   *
   * @param matchContinuation  The continuation that should process the match
   */
  void run(BiConsumer<OngoingRequest, RuleMatch<Endpoint>> matchContinuation);
}
