package org.example;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Reward implements Observer{

    private final String name;
    private final int category;
    @Getter
    int quantity;

    /**
     * Sets the quantity of the reward based on the world's level
     * @param worldLevel: The level of the world
     */
    @Override
    public void update(int worldLevel) {
        this.quantity = Math.round( worldLevel* ((float) 10 /category));
        System.out.println("The quantity of " + name + " is now: " + quantity + " per chest");
    }
}
