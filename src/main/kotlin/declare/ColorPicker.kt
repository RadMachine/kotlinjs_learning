@file:JsModule("react-colorful")
@file:JsNonModule

package declare

import react.FC
import react.PropsWithChildren

@JsName("HexColorPicker")
external val ColorPicker: FC<ColorPickerProps>

external interface ColorPickerProps : PropsWithChildren {
  var color: String
  var onChange: (String) -> Unit
}