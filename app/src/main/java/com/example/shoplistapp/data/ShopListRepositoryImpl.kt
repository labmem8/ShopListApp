package com.example.shoplistapp.data

import com.example.shoplistapp.domain.ShopItem
import com.example.shoplistapp.domain.ShopListRepository
import java.lang.RuntimeException

object ShopListRepositoryImpl : ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementId = 0

    override fun addShopItem(item: ShopItem): Boolean {
        var isAdded = false
        if (item.id == ShopItem.UNDEFINED_ID) {
            item.id = autoIncrementId++
        }

        isAdded = shopList.add(item)

        return isAdded
    }

    override fun editShopItem(id: Int, name: String?, count: Int?, enabled: Boolean?) {
        val item = getShopItem(id)
        item.count = count ?: item.count
        item.enabled = enabled ?: item.enabled
        item.name = name ?: item.name
    }

    override fun removeShopItem(id: Int): Boolean {
        val item = getShopItem(id)
        return shopList.remove(item)
    }

    override fun getShopItem(id: Int): ShopItem {
        return shopList.find {
            it.id == id
        } ?: throw RuntimeException("Element with id $id not found")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toMutableList()
    }
}