package org.tyaa.kotlin.ankoexperiments.ui.post

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import com.bumptech.glide.Glide
import org.jetbrains.anko.*
import org.tyaa.kotlin.ankoexperiments.data.post.Post

class PostDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val post: Post = Post(intent.getIntExtra("postId", 0), "", "", 0)

        verticalLayout {
            lparams(matchParent, wrapContent)
            padding = dip(16)

            imageView {
                Glide.with(this@PostDetailsActivity).load("http://i.pravatar.cc/56?u=${post.title}").into(this)
            }.lparams {
                height = dip(60)
                width = dip(60)
                gravity = Gravity.CENTER
            }
            textView {
                textSize = 16f
                text = post.id.toString()
            }.lparams {
                gravity = Gravity.CENTER
                setMargins(0, dip(5), 0, dip(10))
            }
            textView {
                textSize = 16f
                text = post.body
            }.lparams {
                gravity = Gravity.CENTER
            }
        }
    }
}
