package com.example.shoplistapp.domain

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun addShopItem(item: ShopItem):Boolean {
        return shopListRepository.addShopItem(item)
    }
}