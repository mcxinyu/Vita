package com.androidisland.sample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.androidisland.sample.viewmodel.ViewModelNoFactory
import com.androidisland.vita.VitaOwner
import com.androidisland.vita.vita

class FragmentA : Fragment() {

    val vm1 by vita.with(VitaOwner.Multiple(this))
        .viewModel<ViewModelNoFactory>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Vita", "FragmentA#vm=>$vm1")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setOnClickListener {
            startActivity(Intent(view.context, SecondActivity::class.java))
        }
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        Log.d("test33", "fragA view destroyed")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.d("test33", "fragA destroyed")
//    }
}