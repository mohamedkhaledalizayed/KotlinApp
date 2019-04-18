@file:JvmName("MyCustomKotlin")
package com.smile.kotlinapp

import android.R

object myObject{

    fun myName()="Mohamed khaled ali zayed"
}
fun main(){

    println(MyJavaClass.sum(4,5))

    lambda { "print" }
    "Mohamed".inf("Khalid")

    val add: (Int, Int) -> Int = {a,b-> a+b}
    sum(10,10) { a, b -> println(a+b) }

    addTwoNum(3,3,object : MyInterface {
        override fun sum(a: Int) {
            println(a)
        }
    })

    getData(5,5, ::doAdd)

    doAddAction(3,3,object : MyAction{
        override fun doAction(a: Int, b: Int) {
            println(a+b)
        }
    })

    getData(4){it*2}

    var test = test()

    with(test){
        a = 10
        b = "mohamed"
    }

    test.apply {
        a = 10
        b = "mohamed"
    }.run()
}

fun getData(a: Int, add: (Int)-> Int){
    println(add(a))
}

fun lambda(msg: () -> String){
    println(msg())
}
private infix fun String.inf(a: String) = println(this+a)

fun addTwoNum(a: Int, b: Int, action: MyInterface){
    action.sum(a + b)
}

fun add(a: Int, b: Int) = a + b

data class Student(var name: String, var id: Int)

class ParameterizedClass<A>(private val value: A) {

    fun getValue(): A {
        return value
    }
}

fun sum(a: Int, b: Int, addFunction:(Int, Int)-> Unit) = addFunction(a,b)
interface MyInterface{
    fun sum(a: Int)
}

fun doAdd(a: Int, b: Int)= a+b
fun getData(a: Int, b: Int, add: (Int,Int)-> Int){
    println(add(a,b))
}

interface MyAction{
    fun doAction(a: Int, b: Int)
}

fun doAddAction(a: Int, b: Int, action: MyAction){
    action.doAction(a,b)
}

class test{

    var a = 2
    var b = "h"
    fun run(){
        println("ruuuuuuuuuuun$a $b")
    }
}