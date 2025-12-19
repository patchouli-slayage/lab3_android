package com.example.app1.model

import androidx.compose.ui.graphics.vector.ImageVector

sealed class MenuListItem {
    data class SectionHeader(val title: String) : MenuListItem()

    data class SettingItem(
        val id: Int,
        val title: String,
        val description: String
    ) : MenuListItem()
}