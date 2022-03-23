package declare

import kotlinx.css.*
import styled.StyleSheet

object ColorPickerStyles : StyleSheet("ColorPickerStyles") {
  val Container by css {
    position = Position.absolute
    left = 15.px
    top = 15.px
  }
}