package com.uilover.project2002.Activity

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.project1762.Helper.ManagmentCart
import com.uilover.project2002.Adapter.PicAdapter
import com.uilover.project2002.Adapter.SelectModelAdapter
import com.uilover.project2002.Model.ItemsModel
import com.uilover.project2002.databinding.ActivityDetailBinding

class DetailActivity : BaseActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var item: ItemsModel
    private var numberOrder = 1
    private lateinit var managmentCart: ManagmentCart


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        managmentCart = ManagmentCart(this)

        getBundle()
        initList()

    }

    private fun initList() {
        val modelList = ArrayList<String>()
        for (models in item.model) {
            modelList.add(models)
        }

        binding.modelList.adapter = SelectModelAdapter(modelList)
        binding.modelList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val picList = ArrayList<String>()
        for (imageUrl in item.picUrl) {
            picList.add(imageUrl)
        }

        Glide.with(this)
            .load(picList[0])
            .into(binding.img)

        binding.picList.adapter = PicAdapter(picList) { selectedImageUrl ->
            Glide.with(this)
                .load(selectedImageUrl)
                .into(binding.img)
        }

        binding.picList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun getBundle() {
        item = intent.getParcelableExtra("object")!!

        binding.titleTxt.text = item.title
        binding.descriptionTxt.text = item.description
        binding.priceTxt.text = "$" + item.price
        binding.ratingTxt.text = "${item.rating} Rating"
        binding.addToCartBtn.setOnClickListener {
            item.numberInCart = numberOrder
            managmentCart.insertItem(item)
        }
        binding.backBtn.setOnClickListener { finish() }
        binding.cartBtn.setOnClickListener {
            startActivity(Intent(this@DetailActivity,CartActivity::class.java))
        }
    }
}