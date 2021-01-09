package com.example.java_and_kotlin


class Person{
    private var name: String;
    private var age: Int;

    constructor(name: String, age: Int){
        this.age = age;
        this.name = name;
    }

    fun printInfo(){
        println("Person - $name, $age")
    }

    fun getInfo(): String{
        return "Person - $name, $age"
    }
}