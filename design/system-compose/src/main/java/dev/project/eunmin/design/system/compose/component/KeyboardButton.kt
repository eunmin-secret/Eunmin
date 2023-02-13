package dev.project.eunmin.design.system.compose.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.project.eunmin.design.system.compose.theme.EunminTheme

@Composable
fun KeyboardButton(
    symbol: String,
    modifier: Modifier = Modifier,
    ratio: Float = 1f,
    padding: Dp = 8.dp,
    focus: Boolean = false,
    backgroundColor: Color = MaterialTheme.colorScheme.primaryContainer,
    textColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
    onClick: () -> Unit = {  },
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(ratio)
            .padding(padding)
            .then(modifier),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),

        border = if (focus) {
            BorderStroke(3.dp, MaterialTheme.colorScheme.onPrimaryContainer)
        } else null,
        shape = RoundedCornerShape(20.dp),
        onClick = { onClick() }
    ) {
        Text(
            text = symbol,
            color = textColor,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun KeyboardButtonPreview() {
    EunminTheme {
        KeyboardButton("1")
    }
}