package store

import ktypings.redux.ReduxState

fun mainReducer(reduxState: State, reduxAction: dynamic): State =
        if (reduxAction.type.startsWith("@@redux/INIT")) {
            reduxState
        } else {
            when (ActionType.valueOf(reduxAction.type)) {
                ActionType.INC_COUNT       -> {
                    reduxState.copy(clickCount = (reduxAction.payload as IncCount).newCount)
                }
            }
        }