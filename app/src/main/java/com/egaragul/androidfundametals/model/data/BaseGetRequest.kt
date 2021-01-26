package com.egaragul.androidfundametals.model.data

import com.egaragul.androidfundametals.di.RetrofitModule
import kotlinx.serialization.Serializable

@Serializable
data class BaseGetRequest(
    val apiKey : String = RetrofitModule.API_KEY
)
