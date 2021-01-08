package com.darothub.dindinnui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.darothub.dindinnui.adapter.filterView
import com.darothub.dindinnui.adapter.productView
import com.darothub.dindinnui.data.ProductData
import com.darothub.dindinnui.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayout

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var mainFragmentBinding:FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        Log.i("fragment", param1.toString())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mainFragmentBinding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return mainFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        mainFragmentBinding.textTv.text = param2
//        val tabLayout:TabLayout = requireActivity().findViewById<View>(R.id.bs).findViewById(R.id.bottom_sheet_tabLayout)
//        tabLayout.getTabAt(1)?.select()
        mainFragmentBinding.mainFilterFragRv.withModels {
            ProductData.listOfFilter.forEach { f->
                filterView {
                    id(f.id)
                    data(f)
                }
            }
        }

        mainFragmentBinding.mainFragRv.withModels {
            ProductData.listOfObject.forEach {p->
                productView {
                    id(p.id)
                    data(p)
                }
            }
        }

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}