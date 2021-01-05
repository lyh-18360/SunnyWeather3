package com.unnyweather.android.logic.dao

import android.content.Context
import androidx.core.content.edit
import com.google.gson.Gson
import com.unnyweather.android.SunnyWeatherApplication
import com.unnyweather.android.logic.model.Place

object PlaceDao {
    fun savePlace(place: Place){
        sharedPrefreences().edit {
            putString("place",Gson().toJson(place))
        }
    }
    fun getSavedPlace():Place{
        val placeJson= sharedPrefreences().getString("place","")
        return Gson().fromJson(placeJson,Place::class.java)
    }
    fun isPlaceSaved()= sharedPrefreences().contains("place")

    private fun sharedPrefreences()=SunnyWeatherApplication.context.getSharedPreferences("sunny_weather",Context.MODE_PRIVATE)
}