package org.example;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Enemy implements Observer{
    private final String name;
    private final int rank;
    @Getter
    int level;

    /**
     * Sets the level of the enemy based on the world's level
     * @param worldLevel: The level of the world
     */
    @Override
    public void update(int worldLevel) {
        this.level = worldLevel * 4 * rank;
        System.out.println("The level of the " + name + " is now: " + level);
    }
}
