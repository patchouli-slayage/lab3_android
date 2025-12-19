package com.example.app1.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.app1.model.MenuListItem

class MenuViewModel : ViewModel() {
    private val _menuItems = MutableStateFlow<List<MenuListItem>>(emptyList())
    val menuItems: StateFlow<List<MenuListItem>> = _menuItems

    init {
        loadTestData()
    }

    private fun loadTestData() {
        val items = mutableListOf<MenuListItem>()

        items.add(MenuListItem.SectionHeader("General Settings"))
        items.add(MenuListItem.SettingItem(1, "Profile", "Edit your personal information"))
        items.add(MenuListItem.SettingItem(2, "Language", "Choose app language"))
        items.add(MenuListItem.SettingItem(3, "Dark Mode", "Toggle dark theme"))
        items.add(MenuListItem.SettingItem(4, "Backup Data", "Save your data to cloud"))

        items.add(MenuListItem.SectionHeader("Notifications"))
        items.add(MenuListItem.SettingItem(5, "Push Notifications", "Enable/disable push alerts"))
        items.add(MenuListItem.SettingItem(6, "Email Alerts", "Receive updates via email"))
        items.add(MenuListItem.SettingItem(7, "Sound", "Notification sound settings"))

        items.add(MenuListItem.SectionHeader("Privacy & Security"))
        items.add(MenuListItem.SettingItem(8, "Privacy Policy", "Read our policy"))
        items.add(MenuListItem.SettingItem(9, "Two-Factor Auth", "Enable extra security"))
        items.add(MenuListItem.SettingItem(10, "Clear Cache", "Free up storage"))

        items.add(MenuListItem.SectionHeader("About"))
        items.add(MenuListItem.SettingItem(11, "Version", "App version 1.0.0"))
        items.add(MenuListItem.SettingItem(12, "Contact Support", "Get help"))
        items.add(MenuListItem.SettingItem(13, "Rate App", "Leave feedback"))

        _menuItems.value = items
    }
}