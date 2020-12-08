package com.egaragul.androidfundametals.ui.movies.details

import androidx.recyclerview.widget.RecyclerView
import com.egaragul.androidfundametals.databinding.ItemActorBinding
import com.egaragul.androidfundametals.ui.movies.data.Actor

/**
 * Created by Eugene Garagulya
 * Date: 08.12.2020
 */
class ActorViewHolder(private val itemBinding : ItemActorBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(actor : Actor) {
        itemBinding.ivActor.setImageResource(actor.image)
        itemBinding.tvFullName.text = actor.name
    }
}