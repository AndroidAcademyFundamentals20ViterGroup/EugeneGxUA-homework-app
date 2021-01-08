package com.egaragul.androidfundametals.ui.movies.details

import android.util.TypedValue
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.egaragul.androidfundametals.databinding.ItemActorBinding
import com.egaragul.androidfundametals.ui.movies.data.Actor

/**
 * Created by Eugene Garagulya
 * Date: 08.12.2020
 */
class ActorViewHolder(private val itemBinding : ItemActorBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(actor : Actor) {
        itemBinding.ivActor.load(actor.imageUrl) {
            transformations(
                RoundedCornersTransformation(
                    TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        4f,
                        itemView.context.resources.displayMetrics
                    )
                )
            )
        }
        itemBinding.tvFullName.text = actor.name
    }
}