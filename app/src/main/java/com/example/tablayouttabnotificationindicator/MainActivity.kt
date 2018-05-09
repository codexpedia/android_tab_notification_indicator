package com.example.tablayouttabnotificationindicator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v4.content.ContextCompat
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pageAdapter = PageAdapter(supportFragmentManager)

        pageAdapter.add(PageFragment.newInstance("News"), "News")
        pageAdapter.add(PageFragment.newInstance("Discover"), "Discover")

        view_pager.adapter = pageAdapter
        tabs.setupWithViewPager(view_pager)

        val discoverTab = tabs.getTabAt(1)

        discoverTab?.setCustomView(R.layout.tab_custom_view)

        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                if (tab != null && tab.position == 1) {
                    val view = tab.customView
                    val selectedText = view?.findViewById(android.R.id.text1) as TextView
                    selectedText.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.dark_gray))
                }
             }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null && tab.position == 1) {
                    val view = tab.customView
                    val selectedText = view?.findViewById(android.R.id.text1) as TextView
                    selectedText.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.colorPrimary))
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }
}
