package com.kotlincookbook.app

import com.google.gson.Gson

fun main(args: Array<String>){
    val jsonStr = """
        {
            "name": "HongCheol",
            "age": 21,
            "isAwesome" : true
        }
    """.trimIndent()

    data class Information(val name:String, val age:Int, val isAwesome:Boolean)
    val information:Information
    Gson().fromJson<Information>(jsonStr,Information::class.java)
    //이제 데이터를 코틀린의 객체처럼 사용할 수 있다.
}
