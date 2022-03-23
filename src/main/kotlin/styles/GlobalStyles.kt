package styles

import kotlinx.browser.document
import kotlinx.browser.localStorage
import kotlinx.css.*
import org.w3c.dom.HTMLElement
import kotlin.properties.Delegates

val GlobalStyles = CssBuilder().apply {
  "*" {
    outline = Outline.none
    padding = "0"
    margin = "0"
    border = "0"
    boxSizing = BoxSizing.borderBox
  }

  "html" {
    put("--main-color", mainColor)
  }
}

var mainColor by Delegates.observable(localStorage.getItem("--main-color") ?: "#8a2be2") { _, _, new ->
  document.querySelector("html").unsafeCast<HTMLElement>().style.setProperty("--main-color", new)
  localStorage.setItem("--main-color", new)
}