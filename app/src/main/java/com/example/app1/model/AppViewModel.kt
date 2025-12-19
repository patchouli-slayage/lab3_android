package com.example.app1.model

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

import com.example.app1.model.MenuSections
import com.example.app1.model.Section
import com.example.app1.model.SettingItem

class AppViewModel : ViewModel() {

    // === Стан для Home екрану ===
    private val _homeLabel = MutableStateFlow("Welcome to Home!")
    val homeLabel: StateFlow<String> = _homeLabel.asStateFlow()

    fun updateHomeLabel(newText: String) {
        _homeLabel.value = newText
    }

    // === Стан для Search екрану ===
    private val _searchLabel = MutableStateFlow("Search something...")
    val searchLabel: StateFlow<String> = _searchLabel.asStateFlow()

    fun updateSearchLabel(newText: String) {
        _searchLabel.value = newText
    }

    // === Дані для Menu екрану (список налаштувань з горизонтальною прокруткою в одному розділі) ===
    private val _menuSections = MutableStateFlow<MenuSections>(emptyList())
    val menuSections: StateFlow<MenuSections> = _menuSections.asStateFlow()

    init {
        loadMenuData()
    }

    private fun loadMenuData() {
        val sections = listOf(
            Section(
                title = "General Settings",
                isHorizontal = true,  // ← тільки цей розділ з горизонтальною прокруткою
                items = listOf(
                    SettingItem(1, "Profile", "Edit your personal information"),
                    SettingItem(2, "Language", "Choose app language"),
                    SettingItem(3, "Dark Mode", "Toggle dark theme"),
                    SettingItem(4, "Backup Data", "Save your data to cloud"),
                    SettingItem(5, "Storage", "Manage app storage"),
                    SettingItem(6, "Updates", "Check for new versions")
                )
            ),
            Section(
                title = "Notifications",
                isHorizontal = false,
                items = listOf(
                    SettingItem(7, "Push Notifications", "Enable/disable push alerts"),
                    SettingItem(8, "Email Alerts", "Receive updates via email"),
                    SettingItem(9, "Sound", "Notification sound settings")
                )
            ),
            Section(
                title = "Privacy & Security",
                isHorizontal = false,
                items = listOf(
                    SettingItem(10, "Privacy Policy", "Read our policy"),
                    SettingItem(11, "Two-Factor Auth", "Enable extra security"),
                    SettingItem(12, "Clear Cache", "Free up storage")
                )
            ),
            Section(
                title = "About",
                isHorizontal = false,
                items = listOf(
                    SettingItem(13, "Version", "App version 1.0.0"),
                    SettingItem(14, "Contact Support", "Get help"),
                    SettingItem(15, "Rate App", "Leave feedback")
                )
            )
        )
        _menuSections.value = sections
    }
}