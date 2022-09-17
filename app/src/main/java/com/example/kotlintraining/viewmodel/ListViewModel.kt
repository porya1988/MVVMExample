package com.example.kotlintraining.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlintraining.model.DogBreed

class ListViewModel: ViewModel() {
    val dogs=MutableLiveData<List<DogBreed>>()
    val dogsLoadError=MutableLiveData<Boolean>()
    val loading=MutableLiveData<Boolean>()

    fun refresh(){
        val dog1=DogBreed("1","Rotwailer","10 years","breedGroup","bredFor","temperament","")
        val dog2=DogBreed("1","Rotwailer","15 years","breedGroup","bredFor","temperament","")
        val dog3=DogBreed("1","Rotwailer","12 years","breedGroup","bredFor","temperament","")
        val dog4=DogBreed("1","Rotwailer","12 years","breedGroup","bredFor","temperament","")
        val dogList= arrayListOf(dog1,dog2,dog3,dog4)
        dogs.value=dogList
        dogsLoadError.value=false
        loading.value=false

    }
}