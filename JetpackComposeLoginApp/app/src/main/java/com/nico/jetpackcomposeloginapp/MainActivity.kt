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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nico.jetpackcomposeloginapp.ui.theme.JetpackComposeLoginAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeLoginAppTheme {
                NavigationHost()
            }
        }
    }
}

@Composable
fun NavigationHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "login_screen"
    ) {
        composable(route = "login_screen") {
            LoginScreen(navController)
        }

        composable(route = "register_screen") {
            RegisterScreen(navController)
        }
    }
}

@Composable
fun LoginScreen(navController: NavController) {

    val username = remember {
        mutableStateOf("")
    }

    val password = remember {
        mutableStateOf("")
    }

    val isEnabled =
        username.value.isNotEmpty() && password.value.isNotEmpty()

    Column(
        modifier = Modifier
            .background(color = Color.White)
            .padding(horizontal = 40.dp)
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
            value = username.value,
            onValueChange = { username.value = it },
            placeholder = { Text("Username", fontSize = 18.sp) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(5.dp, 5.dp))

        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            placeholder = { Text("Password", fontSize = 18.sp) },
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.weight(2f))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Don't have an account? ")
            Text(
                " Register",
                modifier = Modifier.clickable { navController.navigate("register_screen") })
        }

        Spacer(modifier = Modifier.padding(vertical = 5.dp))

        OutlinedButton(
            onClick = { },
            enabled = isEnabled,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text("Submit", fontSize = 18.sp, modifier = Modifier.padding(vertical = 10.dp))
        }
    }
}

@Composable
fun RegisterScreen(navController: NavController) {

    val username = remember {
        mutableStateOf("")
    }

    val email = remember {
        mutableStateOf("")
    }

    val password = remember {
        mutableStateOf("")
    }

    val isEnabled =
        username.value.isNotEmpty() && email.value.isNotEmpty() && password.value.isNotEmpty()

    Column(
        modifier = Modifier
            .background(color = Color.White)
            .padding(horizontal = 40.dp)
    ) {

        Spacer(modifier = Modifier.padding(top = 20.dp))

        IconButton(onClick = { navController.navigate("login_screen") }) {
            Icon(
                imageVector = Icons.Outlined.ArrowBack,
                contentDescription = "Arrow Back"
            )
        }

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
            value = username.value,
            onValueChange = { username.value = it },
            placeholder = { Text("Username", fontSize = 18.sp) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(5.dp, 5.dp))

        OutlinedTextField(
            value = email.value,
            onValueChange = { email.value = it },
            placeholder = { Text("Email", fontSize = 18.sp) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(5.dp, 5.dp))

        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            placeholder = { Text("Password", fontSize = 18.sp) },
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.weight(2f))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Already Have an account? ")
            Text(" Login", modifier = Modifier.clickable { navController.navigate("login_screen") })
        }

        Spacer(modifier = Modifier.padding(vertical = 5.dp))

        OutlinedButton(
            onClick = { },
            enabled = isEnabled,
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
    val navController = rememberNavController()
    JetpackComposeLoginAppTheme {
        LoginScreen(navController)
    }
}

@Preview(showSystemUi = true)
@Composable
fun RegisterPreview() {
    val navController = rememberNavController()
    JetpackComposeLoginAppTheme {
        RegisterScreen(navController)
    }
}