/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.kuujo.copycat.resource.manager;

import net.kuujo.copycat.raft.Operation;
import net.kuujo.copycat.raft.Query;

/**
 * Path exists command.
 *
 * @author <a href="http://github.com/kuujo">Jordan Halterman</a>
 */
public class PathExists extends PathOperation<Boolean> implements Query<Boolean> {

  /**
   * Returns a new PathExists builder.
   *
   * @return A new PathExists command builder.
   */
  public static Builder builder() {
    return Operation.builder(PathExists.Builder.class);
  }

  public PathExists() {
  }

  public PathExists(String path) {
    super(path);
  }

  @Override
  public Consistency consistency() {
    return Consistency.LINEARIZABLE_STRICT;
  }

  /**
   * Path exists builder.
   */
  public static class Builder extends PathOperation.Builder<Builder, PathExists> {
    public Builder() {
      super(new PathExists());
    }
  }

}
