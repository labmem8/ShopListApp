package com.example.shoplistapp.domain

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun editShopItem(id:Int, name: String?, count:Int?, enabled: Boolean?) {
        shopListRepository.editShopItem(id, name, count, enabled)
    }
}