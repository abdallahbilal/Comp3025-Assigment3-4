package ca.georgiancollege.assignment3

import com.google.firebase.database.IgnoreExtraProperties
import com.google.firebase.firestore.DocumentId

//This is the data class for the Task

@IgnoreExtraProperties
data class Task(
    @DocumentId val id: String = "",
    val title: String,
    val comments : String

)
{
    constructor() : this("", "", "")
}