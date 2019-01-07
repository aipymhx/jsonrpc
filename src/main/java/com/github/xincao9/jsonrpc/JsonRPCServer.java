/*
 * Copyright 2018 xingyunzhi.
 *
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
 */
package com.github.xincao9.jsonrpc;

/**
 * 
 * @author xincao9@gmail.com
 */
public interface JsonRPCServer {

    /**
     *
     * @throws java.lang.Throwable
     */
    void start() throws Throwable;

    /**
     *
     * @throws java.lang.Throwable
     */
    void shutdown() throws Throwable;

    /**
     *
     * @param method
     */
    void register(Method method);

    /**
     *
     * @param name
     * @return
     */
    Method getMethod(String name);


    /**
     *
     * @param port
     * @param boss
     * @param worker
     * @return
     */
    static JsonRPCServer defaultJsonRPCServer(Integer port, Integer boss, Integer worker) {
        return new JsonRPCServerImpl(port, boss, worker);
    }
}
