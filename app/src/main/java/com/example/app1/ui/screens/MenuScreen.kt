package com.example.app1.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.app1.model.Section
import com.example.app1.model.SettingItem
import com.example.app1.model.AppViewModel

@Composable
fun MenuScreen(modifier: Modifier = Modifier) {
    val viewModel: AppViewModel = viewModel()
    val sections by viewModel.menuSections.collectAsState()

    Column(modifier = modifier.fillMaxSize()) {
        Text(
            text = "App Settings & Features",
            fontSize = 32.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(16.dp)
        )

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            items(sections) { section ->
                if (section.isHorizontal) {
                    HorizontalSection(section)
                } else {
                    VerticalSection(section)
                }
            }
        }

        Button(
            onClick = { /* Apply changes */ },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text("Apply Changes", fontSize = 18.sp)
        }
    }
}

@Composable
fun HorizontalSection(section: Section) {
    Column {
        Text(
            text = section.title,
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF5F5F5))
                .padding(vertical = 12.dp, horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(horizontal = 8.dp)
        ) {
            items(section.items) { item ->
                SettingCard(item, isHorizontal = true)
            }
        }
    }
}

@Composable
fun VerticalSection(section: Section) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text(
            text = section.title,
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF5F5F5))
                .padding(vertical = 12.dp, horizontal = 16.dp)
        )
        section.items.forEach { item ->
            SettingCard(item, isHorizontal = false)
        }
    }
}

@Composable
fun SettingCard(
    item: SettingItem,
    isHorizontal: Boolean
) {
    Card(
        modifier = if (isHorizontal) {
            Modifier
                .width(280.dp)
                .height(140.dp)
        } else {
            Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        },
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        onClick = { /* Navigate to setting */ }
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = item.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = item.description,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}