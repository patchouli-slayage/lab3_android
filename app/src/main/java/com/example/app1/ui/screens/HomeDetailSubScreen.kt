package com.example.app1.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeDetailSubScreen(navController: NavController) {
    var labelText by rememberSaveable { mutableStateOf("This is Detail SubScreen") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = labelText,
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 64.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { labelText = "Detail Updated!" },
            modifier = Modifier.fillMaxWidth(0.7f)
        ) {
            Text("Update Detail Label", fontSize = 16.sp)
        }
    }
}