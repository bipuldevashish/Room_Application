package com.bipuldevashish.room_application.ui.firstFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bipuldevashish.room_application.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.properties.Delegates

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(R.layout.fragment_first) {

    private lateinit var mFirstViewModel: FirstViewModel

    private fun setupViews() {
        view?.findViewById<FloatingActionButton>(R.id.fab)?.setOnClickListener{
                val action = FirstFragmentDirections.actionFirstFragmentToDetailedFragment()
                findNavController().navigate(action)
        }

        mFirstViewModel= ViewModelProvider(this).get(FirstViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

}