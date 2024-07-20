package ca.georgiancollege.assignment3

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import ca.georgiancollege.assignment3.databinding.ActivityMainBinding
/*
*
* Abdallah Bilal
* Comp 3025
* Assignment3
* To-Do List App
* 20/07/2024
*
* */





class MainActivity : AppCompatActivity() {
    // Declare an instance of the binding class
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
// Inflate the layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Mock data
        val dailyTasks = arrayOf(
            Tasks_data("Task 1", "Clean the house"),
            Tasks_data("Task 2", "Groceries"),
            Tasks_data("Task 3", "Make dinner"),
            Tasks_data("Task 4", "Watch House of the Dragon"),
            Tasks_data("Task 5", "Sleep")

        )
        val firstAdapter = FirstAdapter(dailyTasks)
// Use view binding to replace findViewById or synthetic properties
        binding.firstRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = firstAdapter
        }
// Set up the button click listener for the add button
        binding.addButton.setOnClickListener {
            val intent = Intent(this, TaskEntryActivity::class.java)
            startActivity(intent)
        }

    }
}