package components.Form

import components.Quote.QuoteData
import kotlinx.html.ButtonType
import kotlinx.html.js.onSubmitFunction
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLTextAreaElement
import react.PropsWithChildren
import react.RBuilder
import react.functionComponent
import react.useRef
import styled.*
import kotlin.js.Date

external interface IFormProps : PropsWithChildren {
  var addQuote: (QuoteData) -> Unit
}

val Form = functionComponent<IFormProps> { props ->
  val fields = object {
    val author = useRef<HTMLInputElement>()
    val body = useRef<HTMLTextAreaElement>()
  }

  styledForm {
    css { +FormStyles.Form }

    styledInput {
      css { +FormStyles.Input }
      attrs.placeholder = "Автор"
      attrs.required = true
      ref = fields.author
    }

    styledTextarea {
      css { +FormStyles.Input }
      attrs.placeholder = "Цитата"
      attrs.required = true
      ref = fields.body
    }

    styledButton {
      css { +FormStyles.Button }
      +"Добавить"
      attrs.type = ButtonType.submit
    }

    attrs.onSubmitFunction = {
      it.preventDefault()
      props.addQuote(QuoteData(
        fields.author.current!!.value,
        fields.body.current!!.value,
        Date.now().toString()
      ))
      fields.author.current!!.value =  ""
      fields.body.current!!.value = ""
    }
  }
}

fun RBuilder.Form(handler: IFormProps.() -> Unit) = child(Form) { attrs { handler() } }