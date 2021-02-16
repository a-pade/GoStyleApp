package com.example.gostyleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.gostyleapp.databinding.ActivityMainBinding
import com.example.gostyleapp.databinding.FragmentScanBinding
import com.example.gostyleapp.fragment.FragmentScan
import com.example.gostyleapp.fragment.FragmentTicketInProgress
import com.example.gostyleapp.fragment.FragmentTicketScan
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener{
    lateinit var binding: ActivityMainBinding
    val fragmentScanQr = FragmentScan()
    val fragmentTicketScan = FragmentTicketScan()
    val fragmentTicketInProgress = FragmentTicketInProgress()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.bottomNavigationView.setOnNavigationItemSelectedListener(this)
        loadFragment(fragmentScanQr)
    }

    private fun loadFragment(fragment : Fragment?) : Boolean{
        if(fragment!= null){
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
            return true
        }
        return false
    }

    override fun onNavigationItemSelected(item : MenuItem): Boolean{
        if(item.itemId == R.id.scanItem){
            return loadFragment(fragmentScanQr)
        }
        if(item.itemId == R.id.ticketSaveItem){
            return loadFragment(fragmentTicketScan)
        }
        if(item.itemId == R.id.ticketProgressItem){
            return loadFragment(fragmentTicketInProgress)
        }
        return false
    }
}