package com.app.test.ui.location

import android.os.Bundle
import android.util.Log
import com.app.test.R
import com.app.test.databinding.ActivityLocationBinding
import com.app.test.ui.base.BaseActivity
import com.google.android.gms.common.api.Status
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import java.util.*


class LocationActivity : BaseActivity<ActivityLocationBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mViewBinding.root)

        Places.initialize(this, getString(R.string.google_maps_key))
        val autocompleteFragment =
            supportFragmentManager.findFragmentById(R.id.autocomplete_fragment) as AutocompleteSupportFragment?

        autocompleteFragment!!.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME))

        autocompleteFragment.setOnPlaceSelectedListener(object : PlaceSelectionListener {
            override fun onPlaceSelected(place: Place) {
                mViewBinding.textLocation.text = place.name.toString() + "," + place.id
                Log.i("TAG", "Place: " + place.name + ", " + place.id)
            }

            override fun onError(status: Status) {
                // TODO: Handle the error.
                mViewBinding.textLocation.text = status.statusMessage
                Log.i("TAG", "An error occurred: $status")
            }
        })
    }

    override fun getViewBinding(): ActivityLocationBinding =
        ActivityLocationBinding.inflate(layoutInflater)
}