package com.example.jetpackcomponentswithkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackcomponentswithkotlin.R
import com.example.jetpackcomponentswithkotlin.model.CountryModel
import kotlinx.android.synthetic.main.recyclerviewitem.view.*

class RecyclerViewAdapter(val context:Context, val countryModel: List<CountryModel>?):RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var title: TextView
        var id:TextView

        init {
            title=itemView.tv_title
            id=itemView.tv_description
        }
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ViewHolder {
        val inflater=LayoutInflater.from(parent.context).inflate(R.layout.recyclerviewitem,parent,false)
        return ViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.title.text= countryModel?.get(position)?.title.toString()
        holder.id.text= countryModel?.get(position)?.userId.toString()
    }

    override fun getItemCount(): Int {
        return countryModel?.size!!
    }



}