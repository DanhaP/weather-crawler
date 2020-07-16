package org.ajou.realcoding.weathercrawler.repository;

import org.ajou.realcoding.weathercrawler.domain.Dog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DogManagementRepository {
    List<Dog> dogList = new ArrayList<>();


    public void insertDog(Dog dog){
        dogList.add(dog);
    }

    public Dog findDog(String name) {
        for(Dog dog : dogList){
            if(dog.getName().equals(name)){
                return dog;
            }
        }
        throw new RuntimeException();
    }

    public void updateDogsType(String name, String type) {
        Dog dog = this.findDog(name);
        dog.setType(type);
    }

    public void updateDog(Dog dog){
        Dog toBeUpdateDog = this.findDog(dog.getName());
        toBeUpdateDog.setType(dog.getType());
        toBeUpdateDog.setAge(dog.getAge());
    }
}
