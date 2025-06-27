package com.ComPany;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//            Demonstrate Polymorphism
            Animal jack = new Dog("Jack",10,"House");
            Animal herry =  new Cat("herry",2,"House");
            jack.makeSound();
            herry.makeSound();

//            Animal Shelter Service
        AnimalShelterService animalShelterService = new AnimalShelterService();
        animalShelterService.registAnimal(jack);
        animalShelterService.registAnimal(herry);
        animalShelterService.registAnimal(new Dog("colombus",23,"house"));
        animalShelterService.registAnimal(new Cat("Marry",23,"house"));
        List<Animal> animals = animalShelterService.animals();
        for (int i = 0 ; i < animals.size(); i++)
        {
            System.out.println(animals.get(i).toString());
        }

//        Already implemented in AnimalShelterService
        animalShelterService.AnimalsDetials();
    }
}