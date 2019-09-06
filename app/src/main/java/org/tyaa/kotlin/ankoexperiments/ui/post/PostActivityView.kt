package org.tyaa.kotlin.ankoexperiments.ui.post

import android.view.Gravity
import android.view.View
import org.jetbrains.anko.*

class PostActivityView: AnkoComponent<PostActivity> {
    override fun createView(ui: AnkoContext<PostActivity>): View = with(ui) {
        verticalLayout {
            lparams(matchParent, matchParent)
            gravity = Gravity.CENTER
            textView("Cool Anko TextView") {
                gravity = Gravity.CENTER
            }
        }
    }
}