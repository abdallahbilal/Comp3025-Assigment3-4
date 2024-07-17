package ca.georgiancollege.assignment3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ca.georgiancollege.assignment3.databinding.ActivityTaskEntryBinding

class TaskEntryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTaskEntryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
// Inflate the layout
        binding = ActivityTaskEntryBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}