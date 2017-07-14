package com.androidtmc.example.view.widget.text

import android.content.Context
import android.support.v7.widget.AppCompatButton
import android.util.AttributeSet

/**
 * Created by cuong on 7/2/17.
 */
class AppButton : AppCompatButton, IAppTexview {


    constructor(context: Context) : super(context) {

    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun setFont(font: String) {
    }

    override fun setSizeRatio(ratio: Float) {
    }

}