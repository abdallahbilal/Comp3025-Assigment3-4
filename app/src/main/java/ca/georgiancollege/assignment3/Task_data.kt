package ca.georgiancollege.assignment3

import com.google.firebase.database.IgnoreExtraProperties
import com.google.firebase.firestore.DocumentId
@IgnoreExtraProperties
data class Task(
    @DocumentId val id: String = "",
    val tasks_Title: String,
    val comments : String,

    )
{
    constructor() : this("", "", "")
}