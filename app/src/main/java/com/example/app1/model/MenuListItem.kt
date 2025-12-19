package com.example.app1.model


data class SettingItem(
    val id: Int,
    val title: String,
    val description: String
)

data class Section(
    val title: String,
    val items: List<SettingItem>,
    val isHorizontal: Boolean = false)

typealias MenuSections = List<Section>