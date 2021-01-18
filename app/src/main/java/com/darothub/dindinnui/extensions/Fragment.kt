package com.darothub.dindinnui.extensions

import android.net.Uri
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import changeStatusBarColor

/**
 * Navigate to destination id
 *
 * @param destinationId
 */
fun Fragment.goto(destinationId: NavDirections) {
    findNavController().navigate(destinationId)
}

/**
 * Navigate up
 *
 */
fun Fragment.gotoUp() {
    findNavController().navigateUp()
}

/**
 * Navigate to uri
 *
 * @param uri
 */
fun Fragment.goto(uri: Uri) {
    val request = NavDeepLinkRequest.Builder
        .fromUri(uri)
        .build()
    findNavController().navigate(request)
}

fun Fragment.goto(destinationId: Int) {
    findNavController().navigate(destinationId)
}

fun Fragment.onBackDispatcher(action: () -> Unit){
    requireActivity().onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            // in here you can do logic when backPress is clicked
            action()

        }
    })
}

fun Fragment.pop(){
    findNavController().popBackStack()
}

fun Fragment.changeStatusBarColor(colorRes: Int) {
    requireActivity().changeStatusBarColor(colorRes)
}