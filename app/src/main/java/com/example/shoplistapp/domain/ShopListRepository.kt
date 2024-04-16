package com.example.shoplistapp.domain

interface ShopListRepository {
    fun addShopItem(item: ShopItem):Boolean
    fun editShopItem(id:Int, name: String?, count:Int?, enabled: Boolean?)
    fun removeShopItem(id:Int): Boolean
    fun getShopItem(id: Int): ShopItem
    fun getShopList():List<ShopItem>
}