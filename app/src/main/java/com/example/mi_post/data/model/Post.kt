package com.example.mi_post.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

/**
 * Created by Festus Kiambi on 2/21/19.
 */
@Entity(tableName = "posts")
data class Post(

    @Json(name = "id")
    @PrimaryKey
    val id: Int,

    @Json(name = "userId")
    @ColumnInfo(name = "user_id")
    val userId: String?,

    @Json(name = "title")
    @ColumnInfo(name = "title")
    val title: String?,

    @Json(name = "body")
    @ColumnInfo(name = "body")
    val body: String?
)


