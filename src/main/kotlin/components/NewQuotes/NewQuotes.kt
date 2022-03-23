package components.NewQuotes

import components.Quote.Quote
import components.Quote.QuoteData
import components.SearchForm.SearchForm
import react.*

external interface INewQuotesProps : PropsWithChildren {
  var myQuotes: StateInstance<List<QuoteData>>
}

val NewQuotes = functionComponent<INewQuotesProps> { props ->
  val (newQuotes, setNewQuotes) = useState<List<QuoteData>>(listOf())
  val (myQuotes, setMyQuotes) = props.myQuotes

  SearchForm {
    setQuotes = setNewQuotes
  }

  for (q in newQuotes) Quote {
    author = q.author
    body = q.body
    key = q.id
    action = { setMyQuotes(myQuotes + q) }
    actionText = "Добавить"
  }
}

fun RBuilder.NewQuotes(handler: INewQuotesProps.() -> Unit) = child(NewQuotes) { attrs { handler() } }