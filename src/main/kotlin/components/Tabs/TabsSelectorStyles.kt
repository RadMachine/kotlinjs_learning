package components.Tabs

import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.TextDecorationLine
import styled.StyleSheet

object TabsSelectorStyles : StyleSheet("TabsSelectorStyles") {
  val Root by css {
    width = 800.px
    margin(horizontal = LinearDimension.auto)
    color = Color("var(--main-color)")
  }

  val Tab by css {
    cursor = Cursor.pointer
    textDecoration = TextDecoration(setOf(TextDecorationLine.underline))
  }
}