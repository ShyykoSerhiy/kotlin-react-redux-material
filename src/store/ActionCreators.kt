package store

import kotlinext.js.asJsObject
import kotlinext.js.jsObject
import util.async
import util.await
import kotlin.browser.window

fun inc(): ((dynamic) -> Unit, () -> State) -> Unit {
    return { dispatch: (dynamic) -> Unit, getState: () -> State ->
        async {
            val count = window.fetch("api/count", jsObject{method="POST"; headers= jsObject { "content-type" to "application/json"}}).await().text().await()
            val action = ReduxAction(ActionType.INC_COUNT, IncCount(count.toInt()))()
            dispatch(action)
        }
    }
}