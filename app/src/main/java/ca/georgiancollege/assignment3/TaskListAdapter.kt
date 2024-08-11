package ca.georgiancollege.assignment3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ca.georgiancollege.assignment3.databinding.TextRowItemBinding

// TaskListAdapter is an adapter for the RecyclerView that displays a list of Task items.
// It extends ListAdapter, which helps with efficiently updating the list using the TaskComparator.
class TaskListAdapter(private val onItemClicked: (Task) -> Unit) :
    ListAdapter<Task, TaskViewHolder>(TaskComparator()) {

    // Called when the RecyclerView needs a new ViewHolder to represent an item.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        // Inflate the item layout and create a binding object
        val binding = TextRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        // Return a new ViewHolder instance with the binding object
        return TaskViewHolder(binding)
    }

    // Called by the RecyclerView to display the data at the specified position.
    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {

        val current = getItem(position)

        holder.bind(current)

        holder.itemView.setOnClickListener {
            onItemClicked(current)
        }
    }
}