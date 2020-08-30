package com.stackAndQueue.learn.stack.catAndDog;

public class Pet {

    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getPetType() {
        return type;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "type='" + type + '\'' +
                '}';
    }
}
