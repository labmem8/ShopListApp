package com.example.shoplistapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoplistapp.data.ShopListRepositoryImpl
import com.example.shoplistapp.domain.EditShopItemUseCase
import com.example.shoplistapp.domain.GetShopListUseCase
import com.example.shoplistapp.domain.RemoveShopItemUseCase
import com.example.shoplistapp.domain.ShopItem

class MainViewModel : ViewModel() {

    // breaking logic because for now dont know how to do injection of dependency
    private val repository = ShopListRepositoryImpl


    private val getShopListUseCase = GetShopListUseCase(repository)
    private val removeShopItemUseCase = RemoveShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()


    fun removeShopItem(id: Int) {
        removeShopItemUseCase.removeShopItem(id)
    }

    fun editShopItem(id: Int, name:String? = null, count: Int? = null, enabled: Boolean? = null){
        editShopItemUseCase.editShopItem(id, name, count, enabled)
    }

}

