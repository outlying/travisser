package com.antyzero.travisser.core.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.antyzero.travisser.core.Travisser


class BuildListViewModelFactory(val travisser: Travisser) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BuildListViewModel(travisser) as T
    }
}