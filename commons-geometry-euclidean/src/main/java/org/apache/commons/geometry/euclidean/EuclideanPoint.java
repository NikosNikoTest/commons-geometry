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
package org.apache.commons.geometry.euclidean;

import org.apache.commons.geometry.core.AffinePoint;

/** Represents a point in a Euclidean space of any dimension.
 *
 * @param <P> Point implementation type
 * @param <V> Vector implementation type
 */
public interface EuclideanPoint<P extends EuclideanPoint<P, V>, V extends EuclideanVector<P, V>> extends AffinePoint<P, V> {

    /** Returns a vector with the same coordinates as this point.
     * This is equivalent to the expression {@code v = P - Z} where
     * {@code P} is this point, {@code Z} is the zero point. and
     * {@code v} is the returned vector.
     * @return vector with same coordinate values as this point
     */
    V asVector();

    /** Returns the vector representing the displacement from this point
     * to the given point. This is exactly equivalent to {@code p.subtract(thisPoint)}
     * but with a method name that is much easier to visualize.
     * @param p the point the returned vector will be directed toward
     * @return vector representing the displacement <em>from</em> this point <em>to</em> the given point
     */
    V vectorTo(P p);
}
