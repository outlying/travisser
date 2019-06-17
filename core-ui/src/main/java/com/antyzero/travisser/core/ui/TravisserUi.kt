package com.antyzero.travisser.core.ui


import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.antyzero.travisser.core.Travisser

/**
 * Connecting core module with app
 */
class TravisserUi(travisser: Travisser) {

    private val buildListViewModelFactory: BuildListViewModelFactory = BuildListViewModelFactory(travisser)

    fun buildList(fragmentActivity: FragmentActivity): BuildListViewModel {
        return ViewModelProviders
            .of(fragmentActivity, buildListViewModelFactory)
            .get(BuildListViewModel::class.java)
    }
}