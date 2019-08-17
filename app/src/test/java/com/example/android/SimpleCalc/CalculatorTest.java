/*
 * Copyright 2018, Google Inc.
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

package com.example.android.SimpleCalc;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * JUnit4 unit tests for the calculator logic. These are local unit tests; no device needed
 */
@RunWith(JUnit4.class)
@SmallTest
public class CalculatorTest {

    private Calculator mCalculator;

    /**
     * Set up the environment for testing
     */
    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }

    /**
     * Test for simple addition
     */
    @Test
    public void addTwoNumbers() {
        double resultAdd = mCalculator.add(1d, 1d);
        assertThat(resultAdd, is(equalTo(2d)));
    }

    /**
     * Test for addition with a -ve number
     */
    @Test
    public void addTwoNumbersNegative(){
        double resultAdd = mCalculator.add(-1d, 2d);
        assertThat(resultAdd, is(equalTo(1d)));
    }

    @Test
    public void addTwoNumbersFloat(){
        double resultAdd = mCalculator.add(1.111f, 1.111d);
        assertThat(resultAdd, is(closeTo(2.222, 0.01)));
    }

    /**
     * Test for simple subtraction
     */
    @Test
    public void subTwoNumbers(){
        double resultSub = mCalculator.sub(5d, 2d);
        assertThat(resultSub, is(equalTo(3d)));
    }

    /**
     * Test for subtraction with -ve result
     */
    @Test
    public void subWorksWithNegativeResult(){
        double resultSub = mCalculator.sub(4d, 14d);
        assertThat(resultSub, is(equalTo(-10d)));
    }

    /**
     * Test for simple multiplication
     */
    @Test
    public void mulTwoNumbers(){
        double resultMul = mCalculator.mul(6d, 2d);
        assertThat(resultMul, is(equalTo(12d)));
    }

    /**
     * Test for multiplication with zero
     */
    @Test
    public void mulTwoNumbersZero(){
        double resultMul = mCalculator.mul(0d, 4d);
        assertThat(resultMul, is(equalTo(0d)));
    }

    /**
     * Test for simple division
     */
    @Test
    public void divTwoNumbers(){
        double resultDiv = mCalculator.div(10d, 2d);
        assertThat(resultDiv, is(equalTo(5d)));
    }

    /**
     * Test for simple power operation
     */
    @Test
    public void powTwoNumbers(){
        double resultDiv = mCalculator.mPow(5d, 2d);
        assertThat(resultDiv, is(equalTo(25d)));
    }

}