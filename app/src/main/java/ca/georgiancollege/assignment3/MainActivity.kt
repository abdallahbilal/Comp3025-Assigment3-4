package ca.georgiancollege.assignment3

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ca.georgiancollege.assignment3.databinding.ActivityMainBinding
import com.google.firebase.firestore.FirebaseFirestore


/*
*
* Abdallah Bilal
* Comp 3025
* Assignment3
* To-Do List App
* 07/08/2024
*
* */

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: TaskViewModel by viewModels()

    private lateinit var dataManager: DataManager

    private val adapter = TaskListAdapter { task: Task ->
        val intent = Intent(this, TaskEntryActivity::class.java).apply {
            putExtra("taskId", taskId)
        }
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Firestore
        FirebaseFirestore.setLoggingEnabled(true)

        // creates an alias for the DataManager instance
        dataManager = DataManager.instance()

        binding.firstRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.firstRecyclerView.adapter = adapter

        // Observe the Task LiveData to update the UI
        viewModel.tasks.observe(this) { tasks ->
            adapter.submitList(tasks)
        }

        viewModel.loadAllTasks()

        binding.addButton.setOnClickListener {
            val intent = Intent(this, TaskEntryActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadAllTasks()
    }
}







