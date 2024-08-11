package ca.georgiancollege.assignment3


import androidx.recyclerview.widget.RecyclerView
import ca.georgiancollege.assignment3.databinding.TextRowItemBinding

// TaskViewHolder is a ViewHolder for the RecyclerView that displays a single Task item.
class TaskViewHolder(private val binding: TextRowItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    // Binds the data from a Task object to the views in the ViewHolder.
    fun bind(task: Task) {
        // Set the title of the task to the TextView
        binding.title.text = task.title
        // Set the comments of the Task to the TextView
        binding.comments.text = task.comments

    }
}