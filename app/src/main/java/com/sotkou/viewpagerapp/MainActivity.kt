package com.sotkou.viewpagerapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var viewPager2: ViewPager2
    lateinit var myPagerAdapter: MyPagerAdapter
    lateinit var tablayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. Αρχικοποιούμε το ViewPager
        viewPager2 = findViewById(R.id.viewPager2)
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        // 2. Προσθέτουμε τα Fragments στην λίστα του Adapter
        myPagerAdapter = MyPagerAdapter(supportFragmentManager, lifecycle)
        // supportFragmentManager: αυτή η μέθοδος καλείται για να μας επιστρέψει τον fragment manager
        // ο FragmentManager διαχειρίζεται τα fragments στην activity. Μέσω αυτού μπορούμε να
        // προσθέσουμε, αντικαταστήσουμε ή αφαιρέσουμε fragments
        // lifecycle: μας επιστέφει τον κύκλο ζωής του συγκεκριμένου component

        // Προσθέτουμε τα fragments
        myPagerAdapter.addFragmentToList(FragmentOne())
        myPagerAdapter.addFragmentToList(FragmentTwo())
        myPagerAdapter.addFragmentToList(FragmentThree())

        // 3. Συνδέουμε τον adapter με το ViewPager2
        viewPager2.adapter = myPagerAdapter

        // Συνδέουμε τον tablayout με το viewpager
        tablayout = findViewById(R.id.tablayout)
        TabLayoutMediator(
            tablayout,
            viewPager2
            ) {
            tab, position ->
            tab.text = "Tab ${position+1}"
        }.attach()
    }
}