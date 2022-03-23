package components.App

import kotlinx.css.*
import styled.StyleSheet

object AppStyles : StyleSheet("AppStyles") {
  val Main by css {
    width = 800.px
    display = Display.flex
    flexDirection = FlexDirection.column
    alignItems = Align.center
    margin = "20px auto 0"
  }
}