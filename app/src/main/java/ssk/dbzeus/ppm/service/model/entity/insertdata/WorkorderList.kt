package ssk.dbzeus.ppm.service.model.entity.insertdata

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

@TypeConverters(WorkorderListConverter::class)
class WorkorderList(arrayListItem: ArrayList<WorkorderListItem>) : ArrayList<WorkorderListItem>()
class WorkorderListConverter {
    private var gson = Gson()

    @TypeConverter
    fun listToJson(value: ArrayList<WorkorderList>?): String? = gson.toJson(value)

    @TypeConverter
    fun jsonToList(value: String): ArrayList<WorkorderList> {
        val listType: Type = object : TypeToken<ArrayList<WorkorderList?>?>() {}.type
        return gson.fromJson(value, listType)
    }
}