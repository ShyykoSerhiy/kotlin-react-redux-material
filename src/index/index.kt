package index

import app.*
import kotlinext.js.*
import react.dom.*
import kotlin.browser.*
import ktypings.redux.*
import store.State
import store.mainReducer

fun main(args: Array<String>) {
    requireAll(require.context("src", true, js("/\\.css$/")))
    val store = Redux.createStore(::mainReducer, State(),
            Redux.applyMiddleware(ReduxThunk).asDynamic())

    render(document.getElementById("root")) {
        Provider() {
            attrs.store = store
            appConnected{}
        }
    }
}


