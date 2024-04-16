package com.example.shoplistapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shoplistapp.domain.ShopItem
import com.example.shoplistapp.domain.ShopListRepository
import java.lang.RuntimeException

object ShopListRepositoryImpl : ShopListRepository {

    private val shopListLD = MutableLiveData<List<ShopItem>>()

    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementId = 0

    init {
        for (i in 1..10){
            val item = ShopItem("Name $i",true, i)
            addShopItem(item)
        }
    }

    override fun addShopItem(item: ShopItem): Boolean {
        var isAdded = false
        if (item.id == ShopItem.UNDEFINED_ID) {
            item.id = autoIncrementId++
        }

        isAdded = shopList.add(item)
        updateList()

        return isAdded
    }

    override fun editShopItem(id: Int, name: String?, count: Int?, enabled: Boolean?) {
        val item = getShopItem(id)
        item.count = count ?: item.count
        item.enabled = enabled ?: item.enabled
        item.name = name ?: item.name

        updateList()

    }

    override fun removeShopItem(id: Int): Boolean {
        val item = getShopItem(id)
        val isRemoved = shopList.remove(item)

        updateList()
        return isRemoved
    }

    override fun getShopItem(id: Int): ShopItem {
        return shopList.find {
            it.id == id
        } ?: throw RuntimeException("Element with id $id not found")
    }

    override fun getShopList():LiveData<List<ShopItem>> {
        return shopListLD
    }

    private fun updateList() {
        shopListLD.value = shopList.toList()
    }
}