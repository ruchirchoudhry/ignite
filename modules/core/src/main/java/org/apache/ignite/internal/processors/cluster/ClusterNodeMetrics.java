/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.internal.processors.cluster;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import org.apache.ignite.cache.CacheMetrics;
import org.apache.ignite.cluster.ClusterMetrics;
import org.apache.ignite.internal.ClusterMetricsSnapshot;

/**
 *
 */
class ClusterNodeMetrics implements Serializable {
    /** */
    private final byte[] metrics;

    /** */
    private final Map<Integer, CacheMetrics> cacheMetrics;

    /**
     * @param metrics Metrics.
     * @param cacheMetrics Cache metrics.
     */
    ClusterNodeMetrics(ClusterMetrics metrics, Map<Integer, CacheMetrics> cacheMetrics) {
        this.metrics = ClusterMetricsSnapshot.serialize(metrics);
        this.cacheMetrics = cacheMetrics;
    }

    /**
     * @return Metrics.
     */
    byte[] metrics() {
        return metrics;
    }

    /**
     * @return Cache metrics.
     */
    Map<Integer, CacheMetrics> cacheMetrics() {
        return cacheMetrics != null ? cacheMetrics : Collections.<Integer, CacheMetrics>emptyMap();
    }
}