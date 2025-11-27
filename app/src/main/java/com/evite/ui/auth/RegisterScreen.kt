package com.evite.ui.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.evite.ui.components.EviteButton
import com.evite.ui.components.EviteTextField
import com.evite.ui.theme.DarkText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavController) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    
    var nameError by remember { mutableStateOf<String?>(null) }
    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }
    var confirmError by remember { mutableStateOf<String?>(null) }

    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                title = { 
                    Text(
                        "Register", 
                        color = DarkText,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp
                    ) 
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = DarkText
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            // Full Name
            EviteTextField(
                value = fullName,
                onValueChange = { 
                    fullName = it
                    nameError = null
                },
                placeholder = "Full Name",
                leadingIcon = Icons.Outlined.Person,
                error = nameError
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Email
            EviteTextField(
                value = email,
                onValueChange = { 
                    email = it
                    emailError = null
                },
                placeholder = "Email Address",
                leadingIcon = Icons.Outlined.Email,
                error = emailError
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Password
            EviteTextField(
                value = password,
                onValueChange = { 
                    password = it
                    passwordError = null
                },
                placeholder = "Password",
                leadingIcon = Icons.Outlined.Lock,
                isPassword = true,
                error = passwordError
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Confirm Password
            EviteTextField(
                value = confirmPassword,
                onValueChange = { 
                    confirmPassword = it
                    confirmError = null
                },
                placeholder = "Confirm Password",
                leadingIcon = Icons.Outlined.Lock,
                isPassword = true,
                error = confirmError
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Create Account Button
            EviteButton(
                text = "Create Account",
                onClick = {
                    var isValid = true
                    
                    if (fullName.length < 2) {
                        nameError = "Name must be at least 2 characters"
                        isValid = false
                    }
                    
                    if (email.isBlank() || !email.contains("@")) {
                        emailError = "Please enter a valid email"
                        isValid = false
                    }
                    
                    if (password.length < 6) {
                        passwordError = "Password must be at least 6 characters"
                        isValid = false
                    }
                    
                    if (password != confirmPassword) {
                        confirmError = "Passwords do not match"
                        isValid = false
                    }
                    
                    if (isValid) {
                        // TODO: Implement Registration Logic
                    }
                }
            )
        }
    }
}
