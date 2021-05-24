package edu.ecu.cs.pirateplaces

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

private const val TAG = "PiratePlacesActivity"
private const val KEY_INDEX = "index"

class PiratePlacesActivity : AppCompatActivity() {
    private lateinit var previousButton: Button
    private lateinit var nextButton: Button
    private lateinit var placeTextView: TextView
    private lateinit var clickableText: TextView
    private lateinit var peopleTextView: TextView

    private val placeBank = listOf(
        Place(R.string.place_beach),
        Place(R.string.place_library),
        Place(R.string.place_spa),
        Place(R.string.place_nails)
    )

    private val peopleBank = listOf(
        People(R.string.people_couple),
        People(R.string.people_classmates),
        People(R.string.people_girls_day),
        People(R.string.people_self)
    )

    var currentIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate(Bundle?) called")
        setContentView(R.layout.activity_pirate_places)

        val provider: ViewModelProvider = ViewModelProviders.of(this)
        val piratePlacesViewModel = provider.get(PiratePlacesViewModel::class.java)
        Log.d(TAG, "Got a PiratePlaceViewModel: $piratePlacesViewModel")

        previousButton = findViewById(R.id.previous_button)
        nextButton = findViewById(R.id.next_button)
        placeTextView = findViewById(R.id.place_text_view)
        peopleTextView = findViewById(R.id. people_text_view)
        clickableText = findViewById(R.id.place_text_view)

        nextButton.setOnClickListener {
            if(currentIndex<3){
                currentIndex = (currentIndex + 1)
                updatePlace()
                updatePeople()
            }
            else{
                Toast.makeText(this, "You are at the last entry on the list.", Toast.LENGTH_LONG).show()
            }
        }

        previousButton.setOnClickListener {
            if(currentIndex>0){
                currentIndex = (currentIndex - 1)
                updatePlace()
                updatePeople()
            }
            else{
                Toast.makeText(this, "You are at the first entry on the list.", Toast.LENGTH_LONG).show()
            }
        }

        clickableText.setOnClickListener {
            val intent = Intent(this, CheckInActivity::class.java)
            startActivity(intent)
            updatePlace()
        }

        updatePlace()
        updatePeople()

    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        Log.i(TAG, "onSaveInstanceState")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }
    private fun updatePlace() {
        val placeTextResId = placeBank[currentIndex].textResId
        placeTextView.setText(placeTextResId)
    }

    private fun updatePeople() {
        val peopleTextResId = peopleBank[currentIndex].textResId
        peopleTextView.setText(peopleTextResId)
    }

}
