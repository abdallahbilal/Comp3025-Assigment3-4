package ca.georgiancollege.assignment3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ca.georgiancollege.assignment3.databinding.TextRowItemBinding

class FirstAdapter(private val dataSet: Array<Tasks_data>) :
    RecyclerView.Adapter<FirstAdapter.ViewHolder>() {
    class ViewHolder(val binding: TextRowItemBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
// Inflate the layout with view binding
        val binding = TextRowItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
// Use view binding to set the text
        viewHolder.binding.Task.text = dataSet[position].tasks_Title
        viewHolder.binding.comments.text = dataSet[position].comments
    }
    override fun getItemCount() = dataSet.size
}
