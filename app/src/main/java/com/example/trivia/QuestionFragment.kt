package com.example.trivia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.trivia.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment() {
    private lateinit var binding : FragmentQuestionBinding
    private lateinit var args : QuestionFragmentArgs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            args = QuestionFragmentArgs.fromBundle(requireArguments())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuestionBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = view.findNavController()
        val correctAnswer = "Whatsapp"
        var answer = ""

        binding.tvGreetings.text = view.context.getString(R.string.greeting_text, args.userName)

        binding.btSend.setOnClickListener {
            val checkedRadioButtonId = binding.radioGroup.checkedRadioButtonId // Returns View.NO_ID if nothing is checked.
            when(checkedRadioButtonId) {
                View.NO_ID -> {
                    answer = "nada"
                }

                R.id.radio_button_1 -> {
                    answer = "Facebook"
                }

                R.id.radio_button_2 -> {
                    answer = "Twitter"
                }

                R.id.radio_button_3 -> {
                    answer = "Whatsapp"
                }

                R.id.radio_button_4 -> {
                    answer = "Instagram"
                }
            }

            if (answer == correctAnswer) {
                //Toast.makeText(view.context, "Correcto", Toast.LENGTH_SHORT).show()
                navController.navigate(QuestionFragmentDirections.actionQuestionFragmentToSuccessFragment(args.userName))
            } else if (answer == "nada") {
                Toast.makeText(view.context, "Selecciona una opcion", Toast.LENGTH_SHORT).show()
            } else {
                //Toast.makeText(view.context, "Incorrecto", Toast.LENGTH_SHORT).show()
                navController.navigate(QuestionFragmentDirections.actionQuestionFragmentToFailFragment(args.userName))
            }
        }
    }
}