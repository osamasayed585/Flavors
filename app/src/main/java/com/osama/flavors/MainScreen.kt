package com.osama.flavors

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.osama.flavors.di.FlavorFactory
import com.osama.flavors.ui.theme.FlavorsTheme

@Composable
fun MainScreen(
    innerPadding: PaddingValues,
    message: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val context = LocalContext.current
        Text(text = message)
        Button(
            modifier = Modifier.padding(top = 32.dp),
            onClick = {
                val flavorAction = FlavorFactory.getFlavorAction()
                val result = flavorAction.performAction()
                Toast.makeText(context, result, Toast.LENGTH_LONG).show()
            }
        ) {
            Text("Perform Flavor-Specific Action")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    FlavorsTheme {
        MainScreen(
            innerPadding = PaddingValues(),
            message = "Welcome to the app!"
        )
    }
}