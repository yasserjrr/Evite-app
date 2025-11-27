package com.evite.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.EventAvailable
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.evite.ui.components.EviteButton
import com.evite.ui.components.EviteTextField
import com.evite.ui.theme.MediumGray
import com.evite.ui.theme.PrimaryBlue

import androidx.compose.material.icons.filled.EventAvailable

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }

    Scaffold(
        containerColor = Color.White
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Logo
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .background(PrimaryBlue, RoundedCornerShape(20.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = androidx.compose.material.icons.Icons.Filled.EventAvailable,
                    contentDescription = "Logo",
                    tint = Color.White,
                    modifier = Modifier.size(48.dp)
                )
            }

            Spacer(modifier = Modifier.height(60.dp))

            // Email
            EviteTextField(
                value = email,
                onValueChange = { 
                    email = it
                    emailError = null
                },
                placeholder = "your@example.com",
                leadingIcon = Icons.Outlined.Email,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
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
                placeholder = "••••••••",
                leadingIcon = Icons.Outlined.Lock,
                isPassword = true,
                error = passwordError
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Login Button
            EviteButton(
                text = "Log In",
                onClick = {
                    var isValid = true
                    if (email.isBlank() || !email.contains("@")) {
                        emailError = "Please enter a valid email"
                        isValid = false
                    }
                    if (password.isBlank()) {
                        passwordError = "Please enter your password"
                        isValid = false
                    }
                    
                    if (isValid) {
                        // TODO: Implement Login Logic
                    }
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Forgot Password
            Text(
                text = "Forgot Password?",
                color = MediumGray,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.clickable { 
                    // TODO: Navigate to Forgot Password
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Register Link
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Don't have an account? ",
                    color = MediumGray,
                    fontSize = 14.sp
                )
                Text(
                    text = "Register",
                    color = PrimaryBlue,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.clickable {
                        navController.navigate("register")
                    }
                )
            }
        }
    }
}
