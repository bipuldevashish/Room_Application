package com.bipuldevashish.room_application.ui

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.bipuldevashish.room_application.R

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class DetailedFragment : Fragment() {

    private lateinit var saveButton: Button
    private lateinit var titleEditText: EditText
    private lateinit var descriptionEditText: EditText

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_note_detail, container, false)

        setupViews()

        saveButton.setOnClickListener{
            insertDataToDatabase()
        }
        return view
    }

    private fun insertDataToDatabase() {

        val title = titleEditText.text.toString()
        val description = descriptionEditText.text.toString()

    }

    private fun inputCheck(title: String, description: String) : Boolean{
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(description))
    }

    private fun setupViews() {

        saveButton = view?.findViewById(R.id.save_btn)!!
        titleEditText = view?.findViewById(R.id.note_title)!!
        descriptionEditText = view?.findViewById(R.id.note_body)!!


    }
}


