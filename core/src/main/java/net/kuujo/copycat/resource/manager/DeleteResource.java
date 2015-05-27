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

import net.kuujo.copycat.io.Buffer;
import net.kuujo.copycat.io.serializer.Serializer;
import net.kuujo.copycat.io.serializer.Writable;
import net.kuujo.copycat.raft.Command;
import net.kuujo.copycat.raft.Operation;

/**
 * Delete resource command.
 *
 * @author <a href="http://github.com/kuujo">Jordan Halterman</a>
 */
public class DeleteResource implements Command<Boolean>, Writable {

  /**
   * Returns a new DeleteResource builder.
   *
   * @return A new DeleteResource command builder.
   */
  public static Builder builder() {
    return Operation.builder(DeleteResource.Builder.class);
  }

  private long resource;

  public DeleteResource() {
  }

  /**
   * Returns the resource ID.
   *
   * @return The resource ID.
   */
  public long resource() {
    return resource;
  }

  @Override
  public void writeObject(Buffer buffer, Serializer serializer) {
    buffer.writeLong(resource);
  }

  @Override
  public void readObject(Buffer buffer, Serializer serializer) {
    resource = buffer.readLong();
  }

  /**
   * Delete resource builder.
   */
  public static class Builder extends Command.Builder<Builder, DeleteResource> {
    public Builder() {
      super(new DeleteResource());
    }

    /**
     * Sets the delete resource ID.
     *
     * @param resource The resource ID.
     * @return The command builder.
     */
    public Builder withResource(long resource) {
      command.resource = resource;
      return this;
    }
  }

}
