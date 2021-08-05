package com.kotlincookbook.app

import android.widget.Toast
//클래스 계층 구조 제한
sealed class ToastOperations{
}

class ShowMessageToast(val message: String) : ToastOperations()
object ShowErrorToast :ToastOperations(){

}
/*
fun doToastOperation(toastOperation: ToastOperations){
    when(toastOperation){
        is ShowMessageToast -> Toast.makeText(this,
            toastOperation.message, Toast.LENGTH_LONG)
            .show()
        ShowErrorToast -> Toast.makeText(this,"Error..Grr",Toast.LENGTH_LONG).show()
    }
}
 */


