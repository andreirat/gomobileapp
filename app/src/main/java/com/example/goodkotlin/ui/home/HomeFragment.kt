package com.example.goodkotlin.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.net.NetworkInfo
import android.net.ConnectivityManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import android.content.Context
import androidx.lifecycle.ViewModelProviders
import com.example.goodkotlin.R

import hello.Hello

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val cm = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
        val isWiFi: Boolean = activeNetwork?.type == ConnectivityManager.TYPE_WIFI


        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        val typeTextView: TextView = root.findViewById(R.id.text_home_conn_type)
        val t = Hello.connectionStatus("$isConnected")
        val connType = Hello.connectionType("Is Wifi: $isWiFi")
        textView.text = t
        typeTextView.text = connType
//        homeViewModel.text.observe(this, Observer {
//            textView.text = it
//        })
        return root
    }
}