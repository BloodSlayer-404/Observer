package org.example;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class World {

    private List<Observer> observers = new ArrayList<>();
    @Getter
    private int level;

    public World(){
        this.level = 1;
    }

    /**
     * Adds a new Observer to the World
     * @param observer: The new observer
     */
    public void addObserver(Observer observer) {
        observers.add(observer);
        observer.update(level);
    }

    /**
     * Removes an observer from the World
     * @param observer: The observer to be removed
     */
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Sets the new level of the world and call notify the observers
     * @param level: The new level of the world
     */
    public void setLevel(int level) {
        this.level = level;
        notifyObservers();
    }

    /**
     * Notify all the observers to update some of its attributes based on the world level
     */
    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(level);
        }
    }
}
