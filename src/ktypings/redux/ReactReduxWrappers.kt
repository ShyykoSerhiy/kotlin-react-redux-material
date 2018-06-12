@file:JsModule("react-redux")

package ktypings.redux

import react.RClass
import react.RProps
import react.ReactElement


@JsName("connect")
external fun <P : RProps, ST : ReduxState> connect(
    mapStateToProps: ((ST, P) -> P)? = definedExternally,
    mapDispatchToProps: (((dynamic) -> Unit, P) -> P)? = definedExternally
): (Any) -> RClass<P>

@JsName("Provider")
external val Provider: RClass<ProviderProps>

external interface ProviderProps : RProps {
    var store: Any
}

