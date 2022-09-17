package com.example.kotlintraining.view

import android.content.Intent


fun main(){

    var person=Person().apply {
        name="porya"
        age="33"
    }

    println(person)

    with(Intent()){
        putExtra("","")
        putExtra("","")
    }

}

class Person(){
    lateinit var name:String
    lateinit var age:String
}

