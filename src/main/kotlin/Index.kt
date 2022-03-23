import components.App.App
import kotlinx.browser.document
import kotlinx.browser.window
import react.dom.render
import styled.injectGlobal
import styles.GlobalStyles

fun main() {
  injectGlobal(GlobalStyles.toString())
  window.onload = {
    render(document.getElementById("root")) {
      App {}
    }
  }
}
