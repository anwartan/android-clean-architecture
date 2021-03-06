package com.example.mealapp.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealapp.R
import com.example.mealapp.core.data.Resource
import com.example.mealapp.core.ui.MealAdapter
import com.example.mealapp.core.ui.ViewModelFactory
import com.example.mealapp.databinding.FragmentHomeBinding
import com.example.mealapp.detail.DetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {
    private val  homeViewModel: HomeViewModel by viewModel()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val mealAdapter = MealAdapter()
            mealAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            homeViewModel.meal.observe(viewLifecycleOwner, { meal ->
                if (meal != null) {
                    when (meal) {
                        is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            mealAdapter.setData(meal.data)
                        }
                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.viewError.root.visibility = View.VISIBLE
                            binding.viewError.tvError.text = meal.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
            })

            with(binding.rvMeal) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter =mealAdapter
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}