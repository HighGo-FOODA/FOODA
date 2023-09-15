package com.example.fooda

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.fooda.ArchiveFragment
import com.example.fooda.CommunityFragment
import com.example.fooda.HomeFragment
import com.example.fooda.MypageFragment
import com.example.fooda.R
import com.example.fooda.databinding.ActivityMainBinding


private const val TAG_HOME = "home_fragment"
private const val TAG_ARCHIVE = "archive_fragment"
private const val TAG_COMMUNITY = "community_fragment"
private const val TAG_MYPAGE = "mypage_fragment"



class MainActivity: AppCompatActivity(){

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//xml 그림자 잡아주는
        binding.bottomNavigationView.background = null


        setFragment(TAG_HOME, HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.menu_home -> setFragment(TAG_HOME, HomeFragment())
                R.id.menu_archive -> setFragment(TAG_ARCHIVE, ArchiveFragment())
                R.id.menu_community-> setFragment(TAG_COMMUNITY, CommunityFragment())
                R.id.menu_mypage-> setFragment(TAG_MYPAGE, MypageFragment())

            }
            true
        }
    }

    private fun setFragment(tag: String, fragment: Fragment) {
        val manager: FragmentManager = supportFragmentManager
        val fragTransaction = manager.beginTransaction()

        if (manager.findFragmentByTag(tag) == null){
            fragTransaction.add(R.id.mainFrameLayout, fragment, tag)
        }

        val home = manager.findFragmentByTag(TAG_HOME)
        val archive = manager.findFragmentByTag(TAG_ARCHIVE)
        val community = manager.findFragmentByTag(TAG_COMMUNITY)
        val myPage = manager.findFragmentByTag(TAG_MYPAGE)

        if (archive != null){
            fragTransaction.hide(archive)
        }

        if (home != null){
            fragTransaction.hide(home)
        }

        if (community != null) {
            fragTransaction.hide(community)
        }

        if (myPage != null) {
            fragTransaction.hide(myPage)
        }

        if (tag == TAG_HOME) {
            if (home != null) {
                fragTransaction.show(home)
            }
        } else if (tag == TAG_ARCHIVE) {
            if (archive != null) {
                fragTransaction.show(archive)
            }
        } else if (tag == TAG_COMMUNITY) {
            if (community != null) {
                fragTransaction.show(community)
            }
        } else if (tag == TAG_MYPAGE) {
            if (myPage != null) {
                fragTransaction.show(myPage)
            }
        }

        fragTransaction.commitAllowingStateLoss()
    }

}