package com.example.musiee

import android.app.Activity
import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class MyAdapter(val context: Activity, val dataList: List<Data>) :
    RecyclerView.Adapter<MyAdapter.MYViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MYViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return MYViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MYViewHolder, position: Int) {

        val currentData = dataList[position]

        val mediaPlayer=MediaPlayer.create(context,currentData.preview.toUri())

        holder.title.text = currentData.title

        Picasso.get().load(currentData.album.cover).into(holder.image);

        holder.play.setOnClickListener{
            mediaPlayer.start()
        }

        holder.pause.setOnClickListener {
            mediaPlayer.stop()
        }

    }

    override fun getItemCount(): Int {
        return dataList.size
    }


    class MYViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image : ImageView
        val title : TextView
        val play : ImageButton
        val pause : ImageButton

        init {
            image=itemView.findViewById(R.id.musicimage)
            title=itemView.findViewById(R.id.musictitle)
            play=itemView.findViewById(R.id.btnplay)
            pause=itemView.findViewById(R.id.btnpause)
        }

    }
}
