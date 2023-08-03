package com.example.trivia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.trivia.databinding.FragmentNameBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class NameFragment : Fragment() {
    private lateinit var binding : FragmentNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNameBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvName = binding.etName
        val layoutName = binding.layoutName
        val button = binding.btStart
        val navController = view.findNavController()

        button.setOnClickListener {
            if (tvName.text.toString().isNotEmpty()) {
                layoutName.error = null
                Toast.makeText(this.context, view.context.getString(R.string.greeting_text, tvName.text), Toast.LENGTH_LONG).show();
                navController.navigate(NameFragmentDirections.actionNameFragmentToQuestionFragment(tvName.text.toString()))
            } else {
                layoutName.error = "El nombre no puede estar vacio"
            }
        }

    }
}