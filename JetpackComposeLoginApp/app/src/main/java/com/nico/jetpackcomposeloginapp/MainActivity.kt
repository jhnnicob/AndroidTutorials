package com.nico.jetpackcomposeloginapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nico.jetpackcomposeloginapp.ui.theme.JetpackComposeLoginAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeLoginAppTheme {
                LoginScreen()
            }
        }
    }
}

@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier.background(color = Color.White).padding(horizontal = 40.dp)
    ) {

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painterResource(id = R.drawable.login_img),
                contentDescription = ""
            )
        }

        Spacer(modifier = Modifier.padding(vertical = 10.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Username", fontSize = 18.sp) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(5.dp, 5.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Password", fontSize = 18.sp) },
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.weight(2f))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Don't have an account? ")
            Text(" Register", modifier = Modifier.clickable { })
        }

        Spacer(modifier = Modifier.padding(vertical = 5.dp))

        OutlinedButton(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text("Submit", fontSize = 18.sp, modifier = Modifier.padding(vertical = 10.dp))
        }
    }
}

@Composable
fun Register() {
    Column(
        modifier = Modifier.padding(horizontal = 40.dp)
    ) {

        Spacer(modifier = Modifier.padding(top = 20.dp))

        Icon(
            imageVector = Icons.Outlined.ArrowBack,
            contentDescription = "Arrow Back"
        )

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painterResource(id = R.drawable.login_img),
                contentDescription = ""
            )
        }

        Spacer(modifier = Modifier.padding(vertical = 10.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Username", fontSize = 18.sp) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(5.dp, 5.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Email", fontSize = 18.sp) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(5.dp, 5.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Password", fontSize = 18.sp) },
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.weight(2f))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Already Have an account? ")
            Text(" Login", modifier = Modifier.clickable { })
        }

        Spacer(modifier = Modifier.padding(vertical = 5.dp))

        OutlinedButton(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text("Submit", fontSize = 18.sp, modifier = Modifier.padding(vertical = 10.dp))
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoginPreview() {
    JetpackComposeLoginAppTheme {
        LoginScreen()
    }
}

@Preview(showSystemUi = true)
@Composable
fun RegisterPreview() {
    JetpackComposeLoginAppTheme {
        Register()
    }
}