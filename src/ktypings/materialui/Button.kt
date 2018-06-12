@file:JsModule("@material-ui/core/Button")

package ktypings.materialui

import react.RClass
import react.RProps

@JsName("default")
external val Button: RClass<ButtonProps>

external interface ButtonProps : RProps {
    var disabled: Boolean
    var onClick:()-> Unit
}

