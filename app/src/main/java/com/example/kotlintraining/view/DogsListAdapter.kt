package com.example.kotlintraining.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintraining.databinding.ItemDogBinding
import com.example.kotlintraining.model.DogBreed

class DogsListAdapter(private val dogsList: ArrayList<DogBreed>) :
    RecyclerView.Adapter<DogsListAdapter.DogViewHolder>() {


    private lateinit var binding: ItemDogBinding

    fun updateDogList(newDogList:List<DogBreed>){
        dogsList.clear()
        dogsList.addAll(newDogList)
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        binding= ItemDogBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DogViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        binding.dog=dogsList[position]
    }

    override fun getItemCount() = dogsList.size


    class DogViewHolder(binding: ItemDogBinding) : RecyclerView.ViewHolder(binding.root)



}