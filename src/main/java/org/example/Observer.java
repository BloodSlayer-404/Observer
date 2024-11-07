package org.example;

public interface Observer {

    /**
     * Update some parameter based on a variable
     * @param worldLevel: A variable that affect the new value of a parameter
     */
    void update(int worldLevel);

}
