package com.example.mealapp.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.mealapp.R
import com.example.mealapp.core.domain.model.Meal
import com.example.mealapp.core.ui.ViewModelFactory
import com.example.mealapp.databinding.ActivityDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
    }
    private val detailViewModel: DetailViewModel by viewModel()
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)



        val detailMeal = intent.getParcelableExtra<Meal>(EXTRA_DATA)
        showDetailMeal(detailMeal)


    }

    private fun showDetailMeal(detailMeal: Meal?) {
        detailMeal?.let {
            supportActionBar?.title = detailMeal.strMeal
            binding.content.tvDetailDescription.text = detailMeal.strInstructions
            Glide.with(this)
                .load(detailMeal.strMealThumb)
                .into(binding.ivDetailImage)

            var statusFavorite = detailMeal.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailViewModel.setFavoriteMeal(detailMeal,statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this@DetailActivity, R.drawable.ic_favorite))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this@DetailActivity,
                R.drawable.ic_favorite_black
            ))

        }
    }
}