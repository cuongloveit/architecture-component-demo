package com.androidtmc.example.view.widget.text

/**
 * Created by cuong on 7/2/17.
 */
interface IAppTexview {
    /**
     * set font for all text
     */
    fun setFont(font : String)

    /**
     * increase or decrease text size by ratio
     */
    fun setSizeRatio(ratio: Float)
}