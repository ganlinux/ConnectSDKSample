package com.ganlinux.connectsdksample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ganlinux.connectsdksample.ui.theme.ConnectSDKSampleTheme
import com.okx.connectsdk.ConnectSDKConfig
import com.okx.connectsdk.android.OKXConnectSDKAndroid
import com.okx.connectsdk.models.DAppInfo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeSDK(this)

        setContent {
            ConnectSDKSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

private fun initializeSDK(mainActivity: MainActivity) {
    val config = ConnectSDKConfig(
        appSecret = "your_app_secret"
    )

    val dAppInfo = DAppInfo(
        url = "connect.oker.vip",
        name = "OKX Connect Android Demo",
        icon = "https://static.okx.com/cdn/assets/imgs/247/58E63FEA47A2B7D7.png",
        origin = "https://connect.oker.vip"
    )

    val okxConnect = OKXConnectSDKAndroid.create(
        context = mainActivity,
        config = config,
        dappInfo = dAppInfo
    )
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ConnectSDKSampleTheme {
        Greeting("Android")
    }
}
