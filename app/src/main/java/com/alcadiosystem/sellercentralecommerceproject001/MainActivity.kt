package com.alcadiosystem.sellercentralecommerceproject001

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
import androidx.navigation.compose.rememberNavController
import com.alcadiosystem.sellercentralecommerceproject001.navigation.NavigationSeller
import com.alcadiosystem.sellercentralecommerceproject001.presentation.home.HomeScreen
import com.alcadiosystem.sellercentralecommerceproject001.presentation.ui.theme.SellerCentralEcommerceProject001Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SellerCentralEcommerceProject001Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavigationSeller(navController = navController)

                }
            }
        }
    }
}
