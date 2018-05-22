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
package org.apache.commons.geometry.spherical.twod;


import org.apache.commons.geometry.core.Geometry;
import org.junit.Assert;
import org.junit.Test;

public class S2PointTest {

    @Test
    public void testS2Point() {
        for (int k = -2; k < 3; ++k) {
            S2Point p = new S2Point(1.0 + k * Geometry.TWO_PI, 1.4);
            Assert.assertEquals(1.0 + k * Geometry.TWO_PI, p.getTheta(), 1.0e-10);
            Assert.assertEquals(1.4, p.getPhi(), 1.0e-10);
            Assert.assertEquals(Math.cos(1.0) * Math.sin(1.4), p.getVector().getX(), 1.0e-10);
            Assert.assertEquals(Math.sin(1.0) * Math.sin(1.4), p.getVector().getY(), 1.0e-10);
            Assert.assertEquals(Math.cos(1.4), p.getVector().getZ(), 1.0e-10);
            Assert.assertFalse(p.isNaN());
        }
    }

    @Test(expected=IllegalArgumentException.class)
    public void testNegativePolarAngle() {
        new S2Point(1.0, -1.0);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testTooLargePolarAngle() {
        new S2Point(1.0, 3.5);
    }

    @Test
    public void testNaN() {
        Assert.assertTrue(S2Point.NaN.isNaN());
        Assert.assertTrue(S2Point.NaN.equals(new S2Point(Double.NaN, 1.0)));
        Assert.assertFalse(new S2Point(1.0, 1.3).equals(S2Point.NaN));
    }

    @Test
    public void testEquals() {
        S2Point a = new S2Point(1.0, 1.0);
        S2Point b = new S2Point(1.0, 1.0);
        Assert.assertEquals(a.hashCode(), b.hashCode());
        Assert.assertFalse(a == b);
        Assert.assertTrue(a.equals(b));
        Assert.assertTrue(a.equals(a));
        Assert.assertFalse(a.equals('a'));
    }

    @Test
    public void testDistance() {
        S2Point a = new S2Point(1.0, 0.5 * Math.PI);
        S2Point b = new S2Point(a.getTheta() + 0.5 * Math.PI, a.getPhi());
        Assert.assertEquals(0.5 * Math.PI, a.distance(b), 1.0e-10);
        Assert.assertEquals(Math.PI, a.distance(a.negate()), 1.0e-10);
        Assert.assertEquals(0.5 * Math.PI, S2Point.MINUS_I.distance(S2Point.MINUS_K), 1.0e-10);
        Assert.assertEquals(0.0, new S2Point(1.0, 0).distance(new S2Point(2.0, 0)), 1.0e-10);
    }

}
