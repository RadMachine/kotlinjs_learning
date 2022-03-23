package components.Tabs

import kotlinx.html.js.onClickFunction
import react.PropsWithChildren
import react.RBuilder
import react.StateSetter
import react.functionComponent
import styled.css
import styled.styledA
import styled.styledDiv

enum class Tab {
  MyQuotes,
  NewQuotes
}

external interface ITabsSelectorProps : PropsWithChildren {
  var setActiveTab: StateSetter<Tab>
  var swapShowPicker: () -> Unit
}

val TabsSelector = functionComponent<ITabsSelectorProps> { props ->
  styledDiv {
    css { +TabsSelectorStyles.Root }

    styledA {
      css { +TabsSelectorStyles.Tab }
      +"Мои цитаты"
      attrs.onClickFunction = { props.setActiveTab(Tab.MyQuotes) }
    }

    +" | "

    styledA {
      css { +TabsSelectorStyles.Tab }
      +"Поиск цитат"
      attrs.onClickFunction = { props.setActiveTab(Tab.NewQuotes) }
    }

    +" | "

    styledA {
      css { +TabsSelectorStyles.Tab }
      +"Палитра"
      attrs.onClickFunction = { props.swapShowPicker() }
    }
  }
}

fun RBuilder.TabsSelector(handler: ITabsSelectorProps.() -> Unit) = child(TabsSelector) { attrs { handler() } }