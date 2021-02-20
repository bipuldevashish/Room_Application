package com.bipuldevashish.room_application.ui.detail

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bipuldevashish.room_application.R
import com.bipuldevashish.room_application.room.NoteItem
import com.bipuldevashish.room_application.ui.viewmodel.NoteViewModel
import java.text.DateFormat
import java.util.*


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */

class DetailedFragment : Fragment() {

    private val TAG = "DetailedFragment"
    private lateinit var saveButton: Button
    private lateinit var titleEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var dateEditText: TextView
    private lateinit var mNoteViewModel: NoteViewModel
    private val myCalendar: Calendar = Calendar.getInstance()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_note_detail, container, false)

        saveButton = view?.findViewById(R.id.button_save)!!
        titleEditText = view.findViewById(R.id.editTextTitle)!!
        descriptionEditText = view.findViewById(R.id.editTextDescription)!!
        dateEditText = view.findViewById(R.id.textViewDate)!!
        mNoteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        saveButton.setOnClickListener{
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {

        val title = titleEditText.text.toString()
        val description = descriptionEditText.text.toString()
        val date= myCalendar.time

        println("value of date is: $date")

        if (inputCheck(title, description)){
            val note = NoteItem(0, title, description, date)
            mNoteViewModel.insertNotes(note)
            Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_detailedFragment_to_listNoteFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill all the fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(title: String, description: String) : Boolean{
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(description))
    }

}


