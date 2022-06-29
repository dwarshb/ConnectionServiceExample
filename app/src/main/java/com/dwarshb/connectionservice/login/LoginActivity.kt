package com.dwarshb.connectionservice.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dwarshb.connectionservice.R
import com.dwarshb.connectionservice.login.ui.theme.ConnectionServiceTheme

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConnectionServiceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginView()
                }
            }
        }
    }
}

@Composable
fun LoginView(onLoginClick : Unit) {
    var number by rememberSaveable { mutableStateOf("") }
    Column(modifier = Modifier
        .border(0.5.dp, Color.Gray, RectangleShape)
        .padding(12.dp)) {
        Text(text = "Login using your phone number")
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(value = number,
            placeholder = {
                Text(stringResource(id = R.string.enter_your_phoneNumber))},
            onValueChange = {number = it},
            trailingIcon = {
                IconButton(onClick = { onLoginClick }) {
                    Icon(imageVector = Icons.Default.ArrowForward,
                        contentDescription = "forward")
                }
            }
        )


    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ConnectionServiceTheme {
        LoginView()
    }
}