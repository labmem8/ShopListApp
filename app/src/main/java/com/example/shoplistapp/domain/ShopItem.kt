package com.example.shoplistapp.domain

data class ShopItem(
    var name: String,
    var enabled: Boolean,
    var count: Int,
    var id: Int = UNDEFINED_ID
)
{
    companion object{
        const val UNDEFINED_ID = -1
    }
}
