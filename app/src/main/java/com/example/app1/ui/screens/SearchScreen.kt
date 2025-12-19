package com.example.app1.ui.screens

import androidx.compose.foundation.layout.*
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

@Composable
fun SearchScreen(modifier: Modifier = Modifier) {
    var labelText by rememberSaveable { mutableStateOf("Search something...") }

    Column(
        modifier = modifier
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
            onClick = { labelText = "Search Updated!" },
            modifier = Modifier.fillMaxWidth(0.7f)
        ) {
            Text("Update Label", fontSize = 16.sp)
        }
    }
}