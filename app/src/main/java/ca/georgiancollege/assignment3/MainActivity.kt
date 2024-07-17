package ca.georgiancollege.assignment3

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import ca.georgiancollege.assignment3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Declare an instance of the binding class
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
// Inflate the layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dailyTasks = arrayOf(
            Tasks_data("Task 1", "0000001"),
            Tasks_data("Task 2", "0000002"),
            Tasks_data("Task 3", "0000003"),
            Tasks_data("Task 4", "0000004"),
            Tasks_data("Task 5", "0000005"),
            Tasks_data("Task 6", "0000006"),
            Tasks_data("Task 7", "0000007"),
            Tasks_data("Task 8", "0000008"),
            Tasks_data("Task 9", "0000009")

        )
        val firstAdapter = FirstAdapter(dailyTasks)
// Use view binding to replace findViewById or synthetic properties
        binding.firstRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = firstAdapter
        }

        binding.addButton.setOnClickListener {
            val intent = Intent(this, TaskEntryActivity::class.java)
            startActivity(intent)
        }

    }
}