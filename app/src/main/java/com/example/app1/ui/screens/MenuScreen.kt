package com.example.app1.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.app1.model.MenuListItem
import com.example.app1.model.MenuViewModel

@Composable
fun MenuScreen(modifier: Modifier = Modifier) {
    val viewModel: MenuViewModel = viewModel()
    val menuItems by viewModel.menuItems.collectAsState()

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
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(
                items = menuItems,
                key = { item ->
                    when (item) {
                        is MenuListItem.SectionHeader -> "header_${item.title}"
                        is MenuListItem.SettingItem -> "setting_${item.id}"
                    }
                }
            ) { item ->
                when (item) {
                    is MenuListItem.SectionHeader -> SectionHeaderRow(item)
                    is MenuListItem.SettingItem -> SettingItemRow(item)
                }
            }
        }

        Button(
            onClick = { },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text("Apply Changes", fontSize = 18.sp)
        }
    }
}

@Composable
fun SectionHeaderRow(header: MenuListItem.SectionHeader) {
    Text(
        text = header.title,
        fontSize = 22.sp,
        fontWeight = FontWeight.SemiBold,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF5F5F5))
            .padding(vertical = 12.dp, horizontal = 16.dp)
    )
}

@Composable
fun SettingItemRow(item: MenuListItem.SettingItem) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = item.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(Modifier.height(6.dp))
            Text(
                text = item.description,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}