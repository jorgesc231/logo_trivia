package com.example.trivia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.trivia.databinding.FragmentSuccessBinding

class SuccessFragment : Fragment() {

    private lateinit var binding : FragmentSuccessBinding
    private lateinit var args : SuccessFragmentArgs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            args = SuccessFragmentArgs.fromBundle(requireArguments())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentSuccessBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btWinRetry.setOnClickListener {
            view.findNavController().navigate(SuccessFragmentDirections.actionSuccessFragmentToNameFragment())
        }

        binding.successText.text = view.context.getString(R.string.win_text, args.userName)
    }
}