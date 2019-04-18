package com.smile.kotlinapp

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
//        assertEquals(4, 2 + 2)
        val parameterizedClass = ParameterizedClass<String>("string-value")

        val res = parameterizedClass.getValue()

        assertTrue(res is String)
    }

    fun test(){

    }
}
