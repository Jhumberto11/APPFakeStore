package com.example.apifakestore.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apifakestore.R
import com.example.apifakestore.data.ProductResponse

class ProductsAdapter(var listProducts:MutableList<ProductResponse>, var onClickListener: OnProductClick): RecyclerView.Adapter<ProductsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_products, parent, false)
        return ProductsViewHolder(view, onClickListener)
    }

    override fun getItemCount() = listProducts.size


    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.render(listProducts[position])
    }
}