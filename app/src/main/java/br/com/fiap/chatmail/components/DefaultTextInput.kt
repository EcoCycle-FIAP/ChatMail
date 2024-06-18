package br.com.fiap.chatmail.components

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.chatmail.R

@Composable
fun <T> DefaultTextInput(
    modifier: Modifier = Modifier,
    width: Dp = 300.dp,
    value: T,
    onValueChange: (T) -> Unit,
    label: String,
    placeholder: String,
    trailingIcon: @Composable (() -> Unit)? = null,
    readOnly: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    singleLine: Boolean = true
) {
    OutlinedTextField(
        label = { Text(text = label) },
        placeholder = { Text(text = placeholder) },
        value = when (value) {
            is String -> value
            is Int -> value.toString()
            else -> throw IllegalArgumentException("Unsupported value type")
        },
        onValueChange = {
            @Suppress("UNCHECKED_CAST")
            onValueChange(it as T)
        },
        singleLine = singleLine,
        textStyle = TextStyle(fontSize = 16.sp),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .width(width)
            .then(modifier),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.primary_color),
            focusedTrailingIconColor = colorResource(id = R.color.primary_color),
            unfocusedTrailingIconColor = colorResource(id = R.color.chatmail_gray_color),
            unfocusedBorderColor = colorResource(id = R.color.transparent),
            focusedContainerColor = colorResource(id = R.color.input_background),
            unfocusedContainerColor = colorResource(id = R.color.input_background),
            focusedLabelColor = colorResource(id = R.color.chatmail_gray_color),
            unfocusedLabelColor = colorResource(id = R.color.chatmail_gray_color),
            focusedPlaceholderColor = colorResource(id = R.color.chatmail_gray_color)
        ),
        trailingIcon = trailingIcon,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        readOnly = readOnly
    )
}