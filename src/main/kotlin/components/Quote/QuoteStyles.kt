package components.Quote

import kotlinx.css.*
import styled.StyleSheet

object QuoteStyles : StyleSheet("QuoteStyles") {
 val Container by css {
   position = Position.relative
   width = 100.pct
   fontFamily = "Segoe Ui, sans-serif"
   marginBottom = 10.px
   border = "2px solid var(--main-color)"
   borderRadius = 10.px
   padding = "0 5px 5px"
 }

  val Button by css {
    position = Position.absolute
    top = (-1).px
    right = (-1).px
    borderRadius = LinearDimension("0 10px 0 5px")
  }
}