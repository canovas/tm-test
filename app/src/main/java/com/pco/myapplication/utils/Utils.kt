package com.pco.myapplication.utils

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.Window
import android.view.WindowManager
import com.pco.myapplication.R

object Utils {
    private lateinit var dialog: Dialog

    fun manageLoading(context: Context, show: Boolean) {
        if (!show) {
            dialog.cancel()
        } else {
            try {
                dialog = Dialog(context)
                dialog.setContentView(R.layout.loading_dialog)
                val d: Drawable = ColorDrawable(Color.BLACK)
                dialog.window?.setBackgroundDrawable(d)
                dialog.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)

                (context as Activity).runOnUiThread { dialog.show() }
            } catch (e: Exception) {
            }
        }
    }

}