package com.example.architecturecomponentdemo.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.architecturecomponentdemo.R
import com.example.architecturecomponentdemo.api.entity.Repository
import com.example.architecturecomponentdemo.ui.adapter.RepositoryAdapter.ViewHolder
import kotlinx.android.synthetic.main.list_item_repository.view.*

/**
 * Created by cuong on 7/14/17.
 */
class RepositoryAdapter(var repositories: List<Repository>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.list_item_repository, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.onBind(position)
    }

    override fun getItemCount(): Int {
        return repositories.size
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(position: Int) {
            val repository = repositories[position]
            itemView.tvName.text = repository.name
            itemView.tvDescription.text = repository.description

        }
    }
}


