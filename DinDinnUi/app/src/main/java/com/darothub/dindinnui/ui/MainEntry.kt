package com.darothub.dindinnui.ui

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.deeplinkdispatch.DeepLink
import com.airbnb.deeplinkdispatch.DeepLinkHandler
import com.airbnb.deeplinkdispatch.DeepLinkModule
import com.darothub.dindinnui.databinding.ActivityMainEntryBinding


@DeepLinkHandler(*[AppDeepLinkModule::class, LibraryDeepLinkModule::class ])
class MainEntry : AppCompatActivity() {
    lateinit var binding: ActivityMainEntryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Make full screen with status bar visible
        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            statusBarColor = Color.TRANSPARENT
        }
        binding = ActivityMainEntryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent = intent
        if (intent.getBooleanExtra(DeepLink.IS_DEEP_LINK, false)) {
            val parameters = intent.extras
            val idString = parameters!!.getString("id")
            // Do something with idString
            Log.i("Main", "$idString")
        }


    }


}


/** This will generate a AppDeepLinkModuleRegistry class */
@DeepLinkModule
class AppDeepLinkModule {
}

/** This will generate a LibraryDeepLinkModuleRegistry class */
@DeepLinkModule
class LibraryDeepLinkModule {
}