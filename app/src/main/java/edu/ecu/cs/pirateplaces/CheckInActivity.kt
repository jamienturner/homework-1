package edu.ecu.cs.pirateplaces

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class CheckInActivity : AppCompatActivity() {
    private lateinit var checkInButton: Button
    private lateinit var checkInTextView: TextView

    private val placeBank = listOf(
        Place(R.string.place_beach),
        Place(R.string.place_library),
        Place(R.string.place_spa),
        Place(R.string.place_nails)
    )

    var currentIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_in)

        checkInButton = findViewById(R.id.checkin_button)
        checkInTextView = findViewById(R.id.checkin_message)

        checkInButton.setOnClickListener {
            if(false){
                super.onBackPressed()
            }else{
                checkInTextView.text = "Checked In"
                super.onBackPressed()
                Toast.makeText(this, "You have checked in!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun updatePlace() {
        val placeTextResId = placeBank[currentIndex].textResId
        checkInTextView.setText(placeTextResId)
    }

}