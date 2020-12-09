package kg.geektech.youtubeparsing.data.models.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kg.geektech.youtubeparsing.data.models.Item
import java.lang.reflect.Type

class ItemsConverter {

    val gson = Gson()
    val type: Type = object : TypeToken<MutableList<Item>>() {}.type


    @TypeConverter
     fun daysOfWeekToString(items: MutableList<Item>?): String? =
        gson.toJson(items, type)


    @TypeConverter
    fun stringToDaysOfWeekToString(items: String?): MutableList<Item>? =
        gson.fromJson(items, type)

}