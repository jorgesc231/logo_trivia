package com.example.trivia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.trivia.databinding.FragmentFailBinding

class FailFragment : Fragment() {

    private lateinit var binding : FragmentFailBinding
    private lateinit var args : FailFragmentArgs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            args = FailFragmentArgs.fromBundle(requireArguments())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFailBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btFailRetry.setOnClickListener {
            view.findNavController().navigateUp()
        }

        binding.failText.text = view.context.getString(R.string.fail_text, args.userName)
    }
}