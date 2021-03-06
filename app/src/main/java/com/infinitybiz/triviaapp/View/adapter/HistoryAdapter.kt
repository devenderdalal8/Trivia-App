package com.infinitybiz.triviaapp.View.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.infinitybiz.triviaapp.Model.User
import com.infinitybiz.triviaapp.R
import com.infinitybiz.triviaapp.ViewHolder.HistoryViewHolder

class HistoryAdapter(var context: Context, var details : ArrayList<User>) : RecyclerView
.Adapter<HistoryViewHolder>() {

//    lateinit var room : AppDatabase

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item , parent , false)
        return HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        var details = details.get(position)
        holder.vName.text = details.name.toString()
        holder.vValue.text=details.value.toString()
        holder.vList.text=details.list.toString()
        holder.vTime.text=details.time.toString()


    }

    override fun getItemCount(): Int {
        return  details.size
    }
}