package com.example.gzano.uniboors.Utils.Adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.gzano.uniboors.Fragments.RecyclerFragment
import com.example.gzano.uniboors.Utils.Constants
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

/**
 * Created by gzano on 04/10/2017.
 */
class PlacesPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {


    override fun getItem(position: Int): Fragment = when (position) {
        0 -> {
            val recyclerFragment = RecyclerFragment()
            recyclerFragment.setPlacesPresenter(FirebaseDatabase.getInstance().getReference(Constants.CESENA_CAMPUS_NODE))
            recyclerFragment

        }
        else -> {
            val recyclerFragment = RecyclerFragment()
            recyclerFragment.setPlacesPresenter(FirebaseDatabase.getInstance().getReference(Constants.NODE_USERS_PATH).child(FirebaseAuth.getInstance().currentUser?.uid).child("places"))
            recyclerFragment
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        when (position) {
            0 -> return Constants.CESENA_CAMPUS
            1 -> return Constants.YOUR_PLACES

        }
        return null.toString()
    }

    override fun getCount(): Int = Constants.PLACES_PAGE_NUMBER
}