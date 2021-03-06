package com.infinitybiz.triviaapp.ViewHolder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.infinitybiz.triviaapp.R

class HistoryViewHolder (item : View) : RecyclerView.ViewHolder(item)  {

    var vTime : TextView= item.findViewById<TextView>(R.id.vtime )
    var vName: TextView = item.findViewById<TextView>(R.id.vname  )
    var vValue : TextView= item.findViewById<TextView>(R.id.vvalue  )
    var vList: TextView = item.findViewById<TextView>(R.id.vlist  )
}