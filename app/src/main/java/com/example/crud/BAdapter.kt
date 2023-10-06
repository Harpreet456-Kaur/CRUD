package com.example.crud

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import android.widget.TextView

class BAdapter(var list: ArrayList<BModel>,var bInterface : BInterface): BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return 1
    }

    override fun getItemId(p0: Int): Long {
        return 1
    }

    override fun getView(position: Int, view: View?, parent : ViewGroup?): View {
        var view = LayoutInflater.from(parent?.context).inflate(R.layout.items, parent, false)

        var etname= view.findViewById<TextView>(R.id.name)
        var etcourse= view.findViewById<TextView>(R.id.course)

        etname.text = list[position].name
        etcourse.text = list[position].course

        view?.setOnClickListener {
            bInterface.click(position,list)
        }
        return view
    }

    interface BInterface{
        fun click(position: Int,list: ArrayList<BModel>)
    }
}