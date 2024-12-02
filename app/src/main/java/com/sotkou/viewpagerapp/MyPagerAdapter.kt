package com.sotkou.viewpagerapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyPagerAdapter(fm: FragmentManager, lc: Lifecycle) :
    FragmentStateAdapter(fm, lc) {

        // Λίστα που περιέχει όλα τα fragments στην εφαρμογή
        var fragmentsList: ArrayList<Fragment> = ArrayList()

    // Προσθέτει τα fragments που υπάρχουν στην εφαρμογή
    fun addFragmentToList(fragment: Fragment) {
        fragmentsList.add(fragment)
    }

        // Επιστρέφει τον αριθμό των items (fragments, views)
    override fun getItemCount(): Int {
        return fragmentsList.size
    }

    // Ειναι υπεύθυνη για την δημιουργία και επιστροφή ενος
    // fragment σε συγκεκριμένη θέση μεσα στο ViewPager2
    override fun createFragment(position: Int): Fragment {
        return fragmentsList.get(position)
    }
}