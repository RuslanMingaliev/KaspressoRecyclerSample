package com.example.kaspresso.recycler.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kaspresso.recycler.ui.main.model.Application
import kotlin.random.Random

class MainViewModel : ViewModel() {

    val data: MutableLiveData<List<Application>> = MutableLiveData(
        listOf(Application("Camera", false))+ generateRandomApps(count = COUNT, length = LENGTH)
    )

    private companion object {
        private const val POOL = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        private const val COUNT = 100
        private const val LENGTH = 5
    }

    private fun generateRandomApps(count: Int, length: Int): List<Application> = (1..count).map {
        (1..length)
            .map { Random.nextInt(0, POOL.length) }
            .map(POOL::get)
            .joinToString("")

    }.map { Application(it, false) }

    /**
     * Тестовый пример :)
     */
    fun onApplicationSelectedChanged(application: Application) {
        val oldList = data.value ?: error("List is empty")
        val index = oldList.indexOf(application)
        val newList = oldList.subList(0, index) +
                application.copy(isSelected = !application.isSelected) +
                oldList.subList(index + 1, oldList.size)
        data.value = newList
    }
}
