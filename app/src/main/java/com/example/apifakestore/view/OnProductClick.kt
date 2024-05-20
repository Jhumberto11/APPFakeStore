package com.example.apifakestore.view

import com.example.apifakestore.data.ProductResponse

interface OnProductClick {
    fun onProductClick(product: ProductResponse)
}