package com.codingbhasha.assingment.conveter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Conveter {
    @TypeConverter
    fun listToJson(countryLang: List<Any>): String? {
        val type = object : TypeToken<List<Any>>() {}.type
        return Gson().toJson(countryLang, type)
    }
    @TypeConverter
    fun jsonToList(countryLangString: String?): List<Any>? {
        val type = object : TypeToken<List<Any>>() {}.type
        return Gson().fromJson<List<Any>>(countryLangString, type)
    }
}