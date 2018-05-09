package com.example.tablayouttabnotificationindicator

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView

class PageFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_page, container, false)
        val pageType = arguments.getString(PAGE_TYPE)

        val tvHello: TextView = view.findViewById(R.id.tv_hello)
        tvHello.text = pageType
        return view
    }
    companion object {
        val PAGE_TYPE = "PAGE_TYPE"
        fun newInstance(pageType: String): PageFragment {
            val fragment = PageFragment()
            val args = Bundle()
            args.putString(PAGE_TYPE, pageType)
            fragment.arguments = args
            return fragment
        }
    }
}