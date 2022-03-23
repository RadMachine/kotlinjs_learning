package components.MyQuotes

import components.Form.Form
import components.Quote.Quote
import components.Quote.QuoteData
import react.*

external interface IMyQuotesProps : PropsWithChildren {
  var quoteState: StateInstance<List<QuoteData>>
}

val MyQuotes = functionComponent<IMyQuotesProps> { props ->
  val (quotes, setQuotes) = props.quoteState

  Form {
    addQuote = { setQuotes(quotes + it) }
  }

  for (q in quotes) Quote {
    author = q.author
    body = q.body
    key = q.id
    action = { setQuotes(quotes.filter { it.id != q.id }) }
    actionText = "X"
  }
}

fun RBuilder.MyQuotes(handler: IMyQuotesProps.() -> Unit) = child(MyQuotes) { attrs { handler() } }