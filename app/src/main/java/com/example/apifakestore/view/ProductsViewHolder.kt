package com.example.apifakestore.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.apifakestore.data.ProductResponse
import com.example.apifakestore.databinding.ItemProductsBinding
import com.squareup.picasso.Picasso

class ProductsViewHolder(view: View, val onProductClick: OnProductClick) :
    RecyclerView.ViewHolder(view), View.OnClickListener {

    val binding = ItemProductsBinding.bind(view)

    //CREAMOS UN ESPACIO DE MEMORIA LOCAL
    private lateinit var product: ProductResponse

    init {
        view.setOnClickListener(this)
    }

    fun render(product: ProductResponse) {

        //HACEMOS REFERENCIA AL ESPACIO DE MEMORIA LOCAL
        this.product = product
        binding.textViewProductName.text = product.title
        binding.tvCategorieProduct.text = product.category
        binding.tvPriceProduct.text = product.price.toString()
        val image = binding.imageViewProduct

        Picasso.get().load(product.image).into(image)




    }


    override fun onClick(v: View?) {

        onProductClick.onProductClick(product)


    }
}
