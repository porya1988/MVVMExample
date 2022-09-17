package com.example.kotlintraining.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlintraining.databinding.FragmentListBinding
import com.example.kotlintraining.model.DogBreed
import com.example.kotlintraining.viewmodel.ListViewModel


class ListFragment : Fragment() {

    private lateinit var viewModel: ListViewModel
    private var dogsListAdapter = DogsListAdapter(arrayListOf())
    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(layoutInflater)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[ListViewModel::class.java]
        viewModel.refresh()
        Log.e("", "")
        observeViewModel()

        binding.dogsList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = dogsListAdapter
        }
    }

    private fun observeViewModel() {
        viewModel.dogs.observe(viewLifecycleOwner) { dogs: List<DogBreed> ->
            dogs.let {
                binding.dogsList.visibility = View.VISIBLE
                dogsListAdapter.updateDogList(dogs)
            }
        }

              viewModel.dogsLoadError.observe(viewLifecycleOwner) {
                  it?.let {
                      binding.listError.visibility = if (it) View.VISIBLE else View.GONE
                  }
              }
        viewModel.loading.observe(viewLifecycleOwner) {
            it?.let {
                binding.loadingView.visibility = if (it) View.VISIBLE else View.GONE
                if (it){
                    binding.listError.visibility=View.GONE
                    binding.dogsList.visibility=View.GONE
                }
            }
        }
    }
    }
