package com.osama.flavors

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.google.firebase.analytics.FirebaseAnalytics
import com.osama.flavors.ui.theme.FlavorsTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlavorsTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        CenterAlignedTopAppBar(title = { Text(text = stringResource(R.string.welcome_message)) })
                    }
                ) { innerPadding ->
                    MainScreen(innerPadding, intent)
                }
            }
        }
    }
}

@Composable
fun MainScreen(innerPadding: PaddingValues, intent: Intent?) {
    val flavorAction = FlavorFactory.getFlavorAction()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val context = LocalContext.current
        Text(text = getDeepLinkData(intent))
        Button(
            onClick = {
                val result = flavorAction.performAction()
                Toast.makeText(context, result, Toast.LENGTH_LONG).show()
            }
        ) {
            Text("Perform Action")
        }
    }
}

private fun getDeepLinkData(intent: Intent?): String {
    val data: Uri? = intent?.data
    val segments = data?.pathSegments
    val deepValue = if (segments != null && segments.size >= 2 && segments[0] == "product") {
        segments[1]
    } else if (segments != null && segments.size >= 2 && segments[0] == "name")
        segments[1]
    else "no data"
    return deepValue
}
