package com.example.chucknorrisjokes


import android.widget.ImageButton
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity.addFragment(@IdRes FragmentContainerId: Int, fragment: Fragment) {
    val transaction = supportFragmentManager.beginTransaction()
    transaction.add(FragmentContainerId, fragment)
    transaction.commit()
}
