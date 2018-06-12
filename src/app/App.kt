package app

import kotlinext.js.asJsObject
import kotlinext.js.jsObject
import kotlinx.html.js.onClickFunction
import kotlinx.html.style
import ktypings.materialui.Button
import ktypings.redux.connect
import react.*
import react.dom.*
import logo.*
import store.ActionType
import store.ReduxAction
import store.State
import store.inc
import ticker.*

val appConnect =
        connect<App.AppProps, State>(
                { state: State, _ ->
                    jsObject{clickCount = state.clickCount}
                }, { dispatch, _ ->
            jsObject {
                incAction = {
                    dispatch(inc())
                }
            }
        })


class App : RComponent<App.AppProps, RState>() {
    override fun RBuilder.render() {
        div("App-header") {
            logo()
            div {
                attrs.style= kotlinext.js.js{
                    backgroundColor = "red"
                }
                +"Red div "
            }
            h2 {
                +"Welcome to React with Kotlin"
            }
        }
        p("App-intro") {
            +"To get started, edit "
            code { +"app/App.kt" }
            +" and save to reload."
        }
        p("App-ticker") {
            ticker( )
            attrs { onClickFunction={console.log("cool")} }
        }
        Button(){
            attrs { disabled=false; onClick=props.incAction }
            +"You clicked ${props.clickCount} times"
        }
    }

    data class AppProps(var clickCount: Int = 0, var incAction: () -> Unit = {}): RProps
}

fun RBuilder.app() = child(App::class){}
val appConnected:RClass<App.AppProps> = appConnect(App::class.js)


