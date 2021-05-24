package edu.ecu.cs.pirateplaces

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "PiratePlacesViewModel"

class PiratePlacesViewModel : ViewModel(){
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
    private var currentIndex = 0
}