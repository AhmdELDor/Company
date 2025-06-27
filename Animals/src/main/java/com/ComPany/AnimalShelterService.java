package com.ComPany;

import java.util.ArrayList;
import java.util.List;

public class AnimalShelterService {
    List<Animal> animals;

    public AnimalShelterService(){
        animals = new ArrayList<>();
    }
    public void registAnimal(Animal a){
        animals.add(a);
    }
    public List<Animal> animals(){
        return  animals;
    }
    public void AnimalsDetials(){
        for(int i = 0 ; i < animals.size();i++)
        {
            System.out.println(animals.get(i).toString());
        }
    }

}
