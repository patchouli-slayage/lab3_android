package com.example.app1.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.app1.model.AppViewModel

@Composable
fun SearchScreen(modifier: Modifier = Modifier) {
    val viewModel: AppViewModel = viewModel()
    val labelText by viewModel.searchLabel.collectAsState()

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
            onClick = {
                viewModel.updateSearchLabel("Search Updated!")
            },
            modifier = Modifier.fillMaxWidth(0.7f)
        ) {
            Text(
                text = "Update Label",
                fontSize = 16.sp
            )
        }
    }
}