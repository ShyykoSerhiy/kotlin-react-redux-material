package store

import ktypings.redux.ReduxState

data class State(
        val clickCount: Int = 0
) : ReduxState