package com.kotlincookbook.app

import android.widget.ImageView
import com.bumptech.glide.Glide

open class A(var str:String){
    open fun foo(){
        println("foo from A")
    }
    final fun Notice(){
        println("Notice from A")
    }
}
//B의 기본생성자에서 A를 초기화함/ B의 기본생성자에서 매개변수를 전달하여 A를 초기화해주어야한다.
class B(var randomString:String): A(randomString){
    override fun foo() {
        println("foo from B")
    }

}
//클래스 C에서 기본 생성자가 없는 경우 클래스 C 에서는 모든 부가생성자에서 super 키워드를 통해 A를 초기화해주어야한다.
class C : A {
    constructor(randomString: String) : super(randomString)
    constructor(randomString: String, randomInt: Int) : super(randomString)
}




//추상클래스는 상속시 모든추상메소드 구현필요
//open으로 둘 필요는 없다. 추상화라는 것 자체가 재정의를 필수로 하기 때문이다.
class D(var string:String): E(){
    override fun methodC() {

    }

}
abstract class E {
    abstract fun methodC()
    fun impl(){}
}





