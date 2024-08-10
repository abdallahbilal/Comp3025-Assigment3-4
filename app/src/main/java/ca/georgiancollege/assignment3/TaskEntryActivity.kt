package ca.georgiancollege.assignment3

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ca.georgiancollege.assignment3.databinding.ActivityTaskEntryBinding
import com.google.android.gms.tasks.Task
import java.util.UUID

class TaskEntryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTaskEntryBinding
    private val viewModel: TaskViewModel by viewModels()

    private lateinit var dataManager: DataManager

    private var taskId: String? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskEntryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the DataManager
        dataManager = DataManager.instance()

        // Get the Task ID from the intent
        taskId = intent.getStringExtra("taskId")

        // a conditional check to confirm that we are either adding or updating
        if(taskId != null)
        {
            viewModel.loadTasksById(taskId!!)
        }
        else
        {
            // we don't need the delete button when we are adding a new Task
            binding.deleteButton.visibility = View.GONE
        }

        // Observe the Task LiveData to update the UI
        viewModel.task.observe(this) { task ->
            task?.let {
                binding.editTextTitle.setText(it.title)
                binding.editComments.setText(it.comments)
            }
        }

        binding.saveButton.setOnClickListener {
            saveTask()
        }

//        binding.deleteButton.setOnClickListener {
//            deleteTask()
//        }

    }


    // Function to save or update a Task
    private fun saveTask()
    {
        val title = binding.editTextTitle.text.toString()
        val comments = binding.editComments.text.toString()


        if(title.isNotEmpty() || comments.isNotEmpty() )
        {
            val task = Task(id = taskId ?: UUID.randomUUID().toString(), title = title, comments = comments)
            viewModel.saveTask(task)
            Toast.makeText(this, "TV Show Saved", Toast.LENGTH_SHORT).show()
            finish()
        }
        else
        {
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
        }
    }


}