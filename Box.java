package ru.geekbrains.oop.lesson4.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Box<T extends Fruit> {

    private ArrayList<T> fruits;

    public Box(T... fruits){
        this.fruits.addAll((Collection<? extends T>) Arrays.asList(fruits));
    }

    public void remove(T... fruits){
        for (T fruit : fruits) {
            this.fruits.remove(fruit);
        }
    }

    public ArrayList<T> getFruits(){
        return new ArrayList<>(fruits);
    }

    public void clear(){
        fruits.clear();
    }

    public float getWeight() {
        if (fruits.size() == 0) {
            return 0;           
        }
        float weight = 0;
        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box<Orange> box2){
        return this.getWeight() == box2.getWeight();
    }

    public void transfer(Box<? super T> box){
        box.fruits.addAll(this.fruits);
        clear();
    }
}
