package com.darothub.dindinnui.ui

import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.darothub.dindinnui.R
import com.darothub.dindinnui.adapter.filterView
import com.darothub.dindinnui.adapter.productView
import com.darothub.dindinnui.data.CartData
import com.darothub.dindinnui.data.PizzaData
import com.darothub.dindinnui.databinding.FragmentMainBinding
import com.darothub.dindinnui.extensions.getName
import com.darothub.dindinnui.model.ProductObject
import com.darothub.dindinnui.viewmodel.PizzaViewModel


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val PRODUCT = "product"

/**
 * A simple [Fragment] subclass.
 * Use the [BottomFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BottomFragment : BaseMvRxFragment() {
    private val title by lazy {
        getName()
    }
    private val viewModel:PizzaViewModel by activityViewModel()
    private val handler by lazy {
        Handler(Looper.getMainLooper())
    }
    private val fadeOut: Animation by lazy{
        AnimationUtils.loadAnimation(requireContext(), R.anim.fade_out)
    }
    private var product: ArrayList<ProductObject>? = null

    lateinit var mainFragmentBinding:FragmentMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            product = it.getParcelableArrayList(PRODUCT)
        }
        Log.i(title, "PRODUCT $product")
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

        mainFragmentBinding.mainFilterFragRv.withModels {
            PizzaData.listOfFilter.forEach { f->
                filterView {
                    id(f.id)
                    data(f)

                }
            }
        }


    }
    override fun invalidate() = withState(viewModel){state->
        val navHostFragment = requireActivity().supportFragmentManager.fragments[0] as NavHostFragment
        val parent = navHostFragment.childFragmentManager.primaryNavigationFragment as EntryFragment
        mainFragmentBinding.mainFragRv.withModels {
            product?.forEach {p->
                productView {
                    id(p.id)
                    data(p)
                    buttonTouchListener{ view, motionEvent ->
                        view as Button
                        when (motionEvent.action) {
                            MotionEvent.ACTION_DOWN -> {
                                return@buttonTouchListener pressedEvent(view, R.color.teal_200, getString(R.string.addedplusone))
                            }
                            MotionEvent.ACTION_UP -> {
                                view.performClick()
                                return@buttonTouchListener pressedEvent(view, R.color.black, p.price)
                            }
                        }
                        false
                    }

                    buttonClickListener { model, parentView, clickedView, position ->
                        CartData.cartItems.add(p)
                        parent.binding.mainEntryCv.animation = fadeOut
                        parent.binding.mainEntryCartCountTv.text = "${CartData.cartItems.size}"

                    }
                }
            }
        }
    }
    private fun pressedEvent(
        view: Button,
        color:Int,
        p: String
    ): Boolean {
        view.apply {
            background?.colorFilter = PorterDuffColorFilter(
                ContextCompat.getColor(
                    requireContext(),
                    color
                ),
                PorterDuff.Mode.SRC_IN
            )
            text = p
        }
        return true
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BottomFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(product: ArrayList<ProductObject>?) =
            BottomFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(PRODUCT, product)
                }
            }
    }
}