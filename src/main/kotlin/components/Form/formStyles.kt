package components.Form

import kotlinx.css.*
import kotlinx.css.properties.border
import styled.StyleSheet

object FormStyles : StyleSheet("formStyles") {
  val Form by css {
    width = 100.pct
    display = Display.flex
    flexDirection = FlexDirection.column
    gap = 10.px
    alignItems = Align.start
    marginBottom = 10.px
  }

  val Input by css {
    width = 100.pct
    padding = "2px"
    border = "1.5px solid var(--main-color)"
    borderRadius = 3.px
    resize = Resize.vertical
  }

  val Button by css {
    backgroundColor = Color.transparent
    padding = "5px 15px"
    fontSize = 10.px
    fontWeight = FontWeight("500")
    color = Color("var(--main-color)")
    border = "1.5px solid var(--main-color)"
    borderRadius = 3.px
    cursor = Cursor.pointer
  }
}