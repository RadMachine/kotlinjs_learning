package components.SearchForm

import components.Form.FormStyles
import components.Quote.QuoteData
import kotlinx.browser.window
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.await
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.html.ButtonType
import kotlinx.html.js.onSubmitFunction
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.url.URLSearchParams
import org.w3c.fetch.Headers
import org.w3c.fetch.RequestInit
import react.*
import styled.css
import styled.styledButton
import styled.styledForm
import styled.styledInput

interface IQuoteDataArray {
  val quotes: Array<QuoteData>
}

suspend fun fetchQuotes(author: String) = coroutineScope {
  val headers = Headers().apply { append("Authorization", "Token token=\"419d87646e2ad64cb7881015fe537cca\"") }
  var url = "https://favqs.com/api/quotes/"

  if (author != "") {
    val searchParams = URLSearchParams().apply {
      append("filter", author)
      append("type", "author")
    }
    url += "?$searchParams"
  }

  val res = window
    .fetch(url, RequestInit(headers = headers))
    .await()
    .json()
    .await()
    .unsafeCast<IQuoteDataArray>()

  if (res.quotes[0].body != "No quotes found") res.quotes.toList()
  else listOf()
}

external interface ISearchFormProps : PropsWithChildren {
  var setQuotes: StateSetter<List<QuoteData>>
}

val SearchForm = functionComponent<ISearchFormProps> { props ->
  val searchInput = useRef<HTMLInputElement>()

  styledForm {
    css { +FormStyles.Form }

    styledInput {
      css { +FormStyles.Input }
      attrs.placeholder = "Автор"
      attrs.required = true
      ref = searchInput
    }

    styledButton {
      css { +FormStyles.Button }
      +"Поиск"
      attrs.type = ButtonType.submit
    }

    attrs.onSubmitFunction = {
      it.preventDefault()
      MainScope().launch {
        props.setQuotes(fetchQuotes(searchInput.current!!.value))
      }
    }
  }
}

fun RBuilder.SearchForm(handler: ISearchFormProps.() -> Unit) = child(SearchForm) { attrs { handler() } }