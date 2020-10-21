package com.example.kaspresso.recycler.test

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.kaspresso.recycler.MainActivity
import com.example.kaspresso.recycler.screen.MainScreen
import com.example.kaspresso.recycler.ui.main.MainRecyclerAdapter
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Test

class RecyclerTest : TestCase(kaspressoBuilder = Kaspresso.Builder.simple().apply {
    beforeEachTest {
        ActivityScenario.launch(MainActivity::class.java)
    }
}) {

    /**
     * Пример клика с экшенами из Espresso
     */
    @Test
    fun espressoStyleClick() = run {
        MainScreen {
            recycler.act {
                /** Ниже код экшен в стиле Espresso. Если не получается сделать что-то средствами Kakao,
                 * можно использовать Espresso над Kakao-обёртками с помощью act для экшенов или assert для ассершенов
                 */
                actionOnItem<MainRecyclerAdapter.ViewHolder>(hasDescendant(withText("Camera")), click())
            }
        }
    }

    /**
     * Пример клика со стандартными item type для [com.agoda.kakao.recycler.KRecyclerView]
     */
    @Test
    fun kakaoStyleClick() = run {
        MainScreen {
            recycler {
                childWith<MainScreen.DefaultItem> {
                    withDescendant { withText("Camera") }
                } perform { click() }
            }
        }
    }

    /**
     * Пример клика с кастомными item type для [com.agoda.kakao.recycler.KRecyclerView]
     */
    @Test
    fun kakaoStyleWithCustomItemTypesClick() = run {
        MainScreen {
            predefinedItemsRecycler {
                firstChild<MainScreen.CameraItem> {
                    click()
                }
            }
        }
    }
}
