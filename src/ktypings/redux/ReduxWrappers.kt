package ktypings.redux


external interface ReduxState
external class Store {
    @JsName("getState")
    fun getState(): ReduxState

    @JsName("dispatch")
    fun dispatch(action: dynamic)
}

@JsModule("redux")
@JsNonModule
external object Redux {
    @JsName("createStore")
    fun <ST : ReduxState> createStore(reducer: (ST, dynamic) -> ReduxState,
                                      initialState: ST,
                                      enhancer: (dynamic) -> ST = definedExternally)
            : Store

    @JsName("applyMiddleware")
    fun applyMiddleware(vararg middleware: () -> (dynamic) -> dynamic)
            : ((dynamic) -> Unit, () -> ReduxState) -> Unit

    @JsName("compose")
    fun compose(vararg funcs: dynamic): (dynamic) -> dynamic
}
