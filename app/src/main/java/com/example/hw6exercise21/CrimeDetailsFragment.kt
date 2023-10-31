package com.example.hw6exercise21

import android.os.Bundle
import android.os.FileUtils.copy
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.example.hw6exercise21.databinding.FragmentCrimeDetailBinding
import java.util.*


class CrimeDetailsFragment :Fragment() {


private lateinit var crime: Crime

private var _binding: FragmentCrimeDetailBinding? = null

 private val binding
 get() = checkNotNull(_binding){
     "Cannot access binding because it is null. Is the view Visible?"
 }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        crime = Crime(

//Addition of requiresPolice that seems to work with the new conditional
            UUID.randomUUID(),
            title = "",
            date = Date(),
            isSolved = false,
            requiresPolice = false

        )
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        binding = FragmentCrimeDetailBinding.inflate(layoutInflater, container, false)
        _binding = FragmentCrimeDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    //Wiring up views in a fragment
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            crimeTitle.doOnTextChanged { text, _, _, _ ->
                crime = crime.copy(title = text.toString())
            }

            crimeDate.apply {
                text = crime.date.toString()
                isEnabled = false
            }

            //Listener for TextBox change
            crimeSolved.setOnCheckedChangeListener{_, isChecked ->
                crime = crime.copy(isSolved = isChecked)
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}