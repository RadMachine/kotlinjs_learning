package components.App

import components.MyQuotes.MyQuotes
import components.NewQuotes.NewQuotes
import components.Quote.QuoteData
import components.Tabs.Tab
import components.Tabs.TabsSelector
import declare.ColorPicker
import declare.ColorPickerStyles
import kotlinx.browser.localStorage
import react.*
import styled.css
import styled.styledDiv
import styles.mainColor

val App = functionComponent<PropsWithChildren> { props ->

  val (showPicker, setShowPicker) = useState(false)

  if (showPicker) styledDiv {
    css { +ColorPickerStyles.Container }
    ColorPicker {
      attrs {
        color = "#ffffff"
        attrs.onChange = { mainColor = it }
      }
    }
  }

  val (tab, setActiveTab) = useState(Tab.MyQuotes)

  val quoteState = useState(JSON.parse<Array<QuoteData>>(localStorage.getItem("quotes") ?: "[]").toList())

  useEffect(quoteState.component1()) {
    localStorage.setItem("quotes", JSON.stringify(quoteState.component1().toTypedArray()))
  }

  TabsSelector {
    this.setActiveTab = setActiveTab
    swapShowPicker = { setShowPicker(!showPicker) }
  }

  styledDiv {
    css { +AppStyles.Main }
    when (tab) {
      Tab.MyQuotes -> MyQuotes { this.quoteState = quoteState }
      Tab.NewQuotes -> NewQuotes { myQuotes = quoteState }
    }
  }
}

fun RBuilder.App(handler: PropsWithChildren.() -> Unit) = child(App) { attrs { handler() } }