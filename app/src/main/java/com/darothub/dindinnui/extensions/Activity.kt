import android.app.Activity
import androidx.core.content.ContextCompat

/**
 * changes status bar color
 */
fun Activity.changeStatusBarColor(colorRes: Int) {
    window.statusBarColor = ContextCompat.getColor(
        this,
        colorRes
    )
}
