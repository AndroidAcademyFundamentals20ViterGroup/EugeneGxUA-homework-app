package com.egaragul.androidfundametals.ui.movies.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.egaragul.androidfundametals.databinding.ItemActorBinding
import com.egaragul.androidfundametals.ui.movies.data.Actor

/**
 * Created by Eugene Garagulya
 * Date: 08.12.2020
 */
class ActorsAdapter : RecyclerView.Adapter<ActorViewHolder>() {

    init {
        setHasStableIds(true)
    }

    private val actors = mutableListOf<Actor>()

    fun bindActors(list: List<Actor>) {
        actors.clear()
        actors.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        val layout = ItemActorBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ActorViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        holder.bind(actors[position])
    }

    override fun getItemCount(): Int = actors.size

    override fun getItemId(position: Int): Long = actors[position].id.toLong()
}