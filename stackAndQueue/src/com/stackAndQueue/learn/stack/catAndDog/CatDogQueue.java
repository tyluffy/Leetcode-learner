package com.stackAndQueue.learn.stack.catAndDog;

import java.util.LinkedList;
import java.util.Queue;

public class CatDogQueue {

    private Queue<PetEnterQueue> dogQ;

    private Queue<PetEnterQueue> cat;

    private long count;

    public CatDogQueue() {
        this.dogQ = new LinkedList<>();
        this.cat = new LinkedList<>();
    }

    public void add(Pet pet) {
        if (pet.getPetType().equalsIgnoreCase("dog")) {
            dogQ.add(new PetEnterQueue(pet, this.count ++ ));
        } else if (pet.getPetType().equalsIgnoreCase("cat")) {
            cat.add(new PetEnterQueue(pet, this.count++));
        } else {
            throw new RuntimeException("pet type is not cat or dog.");
        }
    }

    public Pet pollAll() {
        if (!dogQ.isEmpty() && !cat.isEmpty()) {
            if (dogQ.peek().getCount() > cat.peek().getCount()) {
                return cat.poll().getPet();
            } else {
                return dogQ.poll().getPet();
            }
        } else if (!dogQ.isEmpty()) {
            return dogQ.poll().getPet();
        } else if (!cat.isEmpty()) {
            return cat.poll().getPet();
        }
        throw new RuntimeException("queue is empty.");
    }

    public Pet pooDog() {
        if (!dogQ.isEmpty()) {
            return dogQ.poll().getPet();
        }
        throw new RuntimeException("dog queue is empty.");
    }

    public Pet pooCat() {
        if (!cat.isEmpty()) {
            return cat.poll().getPet();
        }
        throw new RuntimeException("cat queue is empty.");
    }

    public boolean isEmpty() {
        if (!dogQ.isEmpty() || !cat.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean isDogEmpty() {
        if (!dogQ.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean isCatEmpty() {
        if (!cat.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        CatDogQueue catDogQueue = new CatDogQueue();
        catDogQueue.add(new Pet("dog"));
        catDogQueue.add(new Pet("dog"));
        catDogQueue.add(new Pet("dog"));
        catDogQueue.add(new Pet("cat"));
        catDogQueue.add(new Pet("dog"));
        catDogQueue.add(new Pet("cat"));

        System.out.println(catDogQueue.pooDog());
        System.out.println(catDogQueue.pooDog());
        System.out.println(catDogQueue.pooDog());
        System.out.println(catDogQueue.pooDog());
        System.out.println(catDogQueue.isEmpty());
        System.out.println(catDogQueue.isDogEmpty());
        System.out.println(catDogQueue.isCatEmpty());

    }
}
