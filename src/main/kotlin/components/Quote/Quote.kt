package components.Quote

import components.Form.FormStyles
import kotlinx.html.js.onClickFunction
import react.PropsWithChildren
import react.RBuilder
import react.dom.h2
import react.dom.p
import react.functionComponent
import styled.css
import styled.styledButton
import styled.styledDiv

data class QuoteData(var author: String, var body: String, val id: String)

external interface IQuoteProps : PropsWithChildren {
  var author: String
  var body: String
  var action: () -> Unit
  var actionText: String
}

val Quote = functionComponent<IQuoteProps> { props ->
  styledDiv {
    css {
      +QuoteStyles.Container
    }
    h2 { +props.author }
    p { +props.body }
    styledButton {
      css {
        +FormStyles.Button
        +QuoteStyles.Button
      }
      +props.actionText
      attrs.onClickFunction = { props.action() }
    }
  }
}

fun RBuilder.Quote(handler: IQuoteProps.() -> Unit) = child(Quote) { attrs { handler() } }