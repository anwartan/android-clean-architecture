package com.example.mealapp.favorite

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealapp.MyApplication
import com.example.mealapp.core.ui.MealAdapter
import com.example.mealapp.core.ui.ViewModelFactory
import com.example.mealapp.databinding.FragmentFavoriteBinding
import javax.inject.Inject


class FavoriteFragment : Fragment() {
    @Inject
    lateinit var factory: ViewModelFactory
    private val  favoriteViewModel:FavoriteViewModel by viewModels {
        factory
    }
    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater,container,false);
        return binding.root

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MyApplication).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity!=null){
            val mealAdapter =MealAdapter()

            favoriteViewModel.favoriteMeal.observe(viewLifecycleOwner, { dataMeal ->
                mealAdapter.setData(dataMeal)
                binding.viewEmpty.root.visibility = if (dataMeal.isNotEmpty()) View.GONE else View.VISIBLE
            })

            with(binding.rvTourism) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = mealAdapter
            }
        }
    }


}