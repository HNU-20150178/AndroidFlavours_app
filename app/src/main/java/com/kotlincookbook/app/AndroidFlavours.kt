package com.kotlincookbook.app

/**
 * Created by theseus on 21/10/17.
 */
data class AndroidFlavours (var name:String, val image:Int)

var flavorList = listOf<AndroidFlavours>(
    AndroidFlavours("Cupcake",R.drawable.cupcake),
    AndroidFlavours("Donut",R.drawable.donut),
    AndroidFlavours("Eclair",R.drawable.eclair),
    AndroidFlavours("Froyo",R.drawable.froyo),
    AndroidFlavours("Gingerbread",R.drawable.gingerbread),
    AndroidFlavours("HoneyComb",R.drawable.honeycomb),
    AndroidFlavours("Icecream Sandwich",R.drawable.icecream),
    AndroidFlavours("Jellybean",R.drawable.jellybean),
    AndroidFlavours("KitKat",R.drawable.kitkat),
    AndroidFlavours("Lollipop",R.drawable.lollipop)
)