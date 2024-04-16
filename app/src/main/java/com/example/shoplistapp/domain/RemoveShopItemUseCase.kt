package com.example.shoplistapp.domain

class RemoveShopItemUseCase (private val shopListRepository: ShopListRepository) {
    fun removeShopItem(id:Int): Boolean {
        return shopListRepository.removeShopItem(id)
    }
}