package com.example.apifakestore.view

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apifakestore.R
import com.example.apifakestore.data.ProductResponse
import com.example.apifakestore.data.RetrofitService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

class MainActivity : AppCompatActivity(), OnProductClick {

    private lateinit var rvProducts: RecyclerView
    var listProducts:MutableList<ProductResponse> = mutableListOf()
    private lateinit var adapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        CoroutineScope(Dispatchers.IO).launch {
        val response = RetrofitService.getProductsJewelery()
            listProducts.addAll(response)

        }
        initRecyclerView()


    }



    private fun showDialog(product: ProductResponse) {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_product)
        val tvDescription = dialog.findViewById<TextView>(R.id.tvDescriptionDialog)
        tvDescription.text = product.description
        dialog.show()

    }

    private fun initRecyclerView() {
        rvProducts = findViewById(R.id.rvProducts)
        this.adapter = ProductsAdapter(listProducts,this)
        rvProducts.adapter = adapter
        rvProducts.layoutManager = LinearLayoutManager(this)
        adapter.notifyDataSetChanged()



    }

    override fun onProductClick(product: ProductResponse) {
        showDialog(product)
    }
}