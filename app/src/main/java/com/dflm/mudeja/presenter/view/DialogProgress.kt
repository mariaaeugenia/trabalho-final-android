package com.dflm.mudeja.presenter.view

import android.app.Dialog
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.dflm.mudeja.R
import com.dflm.mudeja.show
import kotlinx.android.synthetic.main.dialog_progress.*

class DialogProgress(context: Context) : Dialog(context, android.R.style.Theme_Black) {

    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window?.setBackgroundDrawableResource(R.color.backgound_dialog_progress)
        View.inflate(context, R.layout.dialog_progress, null as ViewGroup)

        progressBarLoading.isIndeterminate = true
        setCancelable(false)
    }

    override fun show() {
        progressBarLoading.show(true)
        super.show()
    }

    override fun dismiss() {
        progressBarLoading.show(false)
        super.dismiss()
    }
}