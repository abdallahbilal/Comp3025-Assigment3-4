package ca.georgiancollege.assignment3

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
            Tasks_data("House of the Dragon", "HBO",),
            Tasks_data("Lord of the Rings", "Prime Video"),
            Tasks_data("Andor", "Disney"),
            Tasks_data("Severance", "AppleTv"),
            Tasks_data("Star Trek: Strange New Worlds", "Paramount+")
        )
        val firstAdapter = FirstAdapter(dailyTasks)
// Use view binding to replace findViewById or synthetic properties
        binding.firstRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = firstAdapter
        }
    }
}