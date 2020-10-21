package com.example.kaspresso.recycler.screen

import android.view.View
import com.agoda.kakao.image.KImageView
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.text.KTextView
import com.example.kaspresso.recycler.R
import com.example.kaspresso.recycler.ui.main.MainFragment
import com.kaspersky.kaspresso.screens.KScreen
import org.hamcrest.Matcher

object MainScreen : KScreen<MainScreen>() {

    override val layoutId: Int? = R.layout.main_fragment
    override val viewClass: Class<*>? = MainFragment::class.java

    val recycler = KRecyclerView({ withId(R.id.recycler) }, itemTypeBuilder = {
        itemType(::DefaultItem)
    })

    val predefinedItemsRecycler = KRecyclerView({ withId(R.id.recycler) }, itemTypeBuilder = {
        itemType(::CameraItem)
    })

    class DefaultItem(parent: Matcher<View>) : KRecyclerItem<DefaultItem>(parent) {
        val icon = KImageView { withId(R.id.icon) }
        val item = KTextView { withId(R.id.text) }
    }

    class CameraItem(parent: Matcher<View>) : KRecyclerItem<DefaultItem>(parent) {
        val item = KTextView { withText("Camera") }
    }
}
