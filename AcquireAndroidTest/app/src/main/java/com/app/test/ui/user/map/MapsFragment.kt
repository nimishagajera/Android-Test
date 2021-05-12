package com.app.test.ui.user.map

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.test.R
import com.app.test.databinding.FragmentMapsBinding
import com.app.test.ui.base.BaseFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MapsFragment : BaseFragment<FragmentMapsBinding>(), OnMapReadyCallback {

    private var lat = 0.0
    private var long = 0.0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        mViewBinding = FragmentMapsBinding.inflate(inflater, container, false)

        lat = arguments?.getString("latitude").toString().toDouble()
        long = arguments?.getString("longitude").toString().toDouble()
        return mViewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        val location = LatLng(lat, long)
        googleMap.let {
            it.addMarker(MarkerOptions().position(location).title("Marker added"))
            it.moveCamera(CameraUpdateFactory.newLatLng(location))
            it.animateCamera(CameraUpdateFactory.zoomTo(10F))
        }
    }
}