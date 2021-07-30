package com.kotlincookbook.app

import android.os.Bundle
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlin.properties.Delegates


/**
 * Created by theseus on 21/10/17.
 */
class AndroidFlavourAdapter:RecyclerView.Adapter<AndroidFlavourAdapter.FlavourViewHolder>(){
    var flavourItems:List<AndroidFlavours> by
            Delegates.observable(emptyList()){
                property, oldValue, newValue ->
                notifyChanges(oldValue, newValue)
            }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): FlavourViewHolder {
            return FlavourViewHolder(parent.inflate(R.layout.flavour_item))
    }

    override fun getItemCount(): Int = flavourItems.size
    override fun onBindViewHolder(holder: FlavourViewHolder, position: Int) { //payload의 데이터 변경사항을 업데이트하기위함
        holder.name.text = flavourItems.get(holder.adapterPosition).name
        holder.image.loadImage(flavourItems.get(holder.adapterPosition).image)
    }
    inner class FlavourViewHolder(var view:View):RecyclerView.ViewHolder(view){
        var name:TextView = view.findViewById(R.id.textView)
        var image:ImageView = view.findViewById(R.id.imageView)
    }
    private fun notifyChanges(oldValue: List<AndroidFlavours>, newValue: List<AndroidFlavours>){
        val diff = DiffUtil.calculateDiff(object : DiffUtil.Callback(){ //DiffUtil은 두개의 배열/리스트가 필요하며 old/new여야 한다.
            override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
                val oldFlavour = oldValue.get(oldItemPosition)
                val newFlavour = oldValue.get(newItemPosition)
                val bundle = Bundle()
                if(!oldFlavour.name.equals(newFlavour.name)){
                    bundle.putString("name",newFlavour.name)
                }
                if(!oldFlavour.image.equals(newFlavour.image)){
                    bundle.putInt("image",newFlavour.image)
                }
                if(bundle.size()==0) return null
                return bundle
            }

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldValue.get(oldItemPosition)==newValue.get(newItemPosition)
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldValue.get(oldItemPosition).name.equals(newValue.get(newItemPosition).name)
                        &&oldValue.get(oldItemPosition).image.equals(newValue.get(newItemPosition).image)
            }

            override fun getOldListSize(): Int {
                return oldValue.size
            }

            override fun getNewListSize(): Int {
                return newValue.size
            }
        })
        // Diff 계산 후에 DiffUtils 객체가 변경 내용을 Adapter에 전달하기 위해 dispatchUpdatesTo 메소드를 호출한다
        diff.dispatchUpdatesTo(this)
        // playload의 변경사항은 어댑터의 notifyItemRangeChanged 메소드를 사용하여 전달된다
        //DiffUtils는 리스트의 사이즈가 너무 큰 경우 두 리스트 간의 diff를 처리하는 데 약간의 시간이 걸릴수 있으므로, 백그라운드 스레드에서 계산해야한다.
    }
}