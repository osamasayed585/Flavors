package com.osama.flavors

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.osama.flavors.ui.theme.FlavorsTheme

private const val PRODUCT_KEY = "product"
private const val NAME_KEY = "name"

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
                    MainScreen(
                        innerPadding,
                        getDeepLinkData()
                    )
                }
            }
        }
    }

    private fun getDeepLinkData(): String {
        val data: Uri = intent?.data ?: return "no data comes from deep link"
        val segments = data.pathSegments
        return when {
            segments.size >= 2 && segments[0] in listOf(PRODUCT_KEY, NAME_KEY) -> segments[1]
            else -> "no data comes from deep link"
        }
    }
}
