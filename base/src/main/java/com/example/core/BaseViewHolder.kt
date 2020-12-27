package com.example.core

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView
import java.util.*

abstract class BaseViewHolder : RecyclerView.ViewHolder {
    constructor(itemView:View):super(itemView)


   private val viewHashMap: MutableMap<Int,View> = HashMap()

   fun <T : View> getView(id:Int):T{
      var view:View?=viewHashMap[id]
       if (view==null){
           view= itemView.findViewById(id)
           viewHashMap[id]=view
       }
       return view as T
   }
       open fun setText(id: Int,text:String?){
          (getView<View>(id) as TextView).text = text
       }

}