package ccsu.cs505.statemanagement;

/**
 * Stores the global state and provides method for managing it.
 */
public interface Store {
    /**
     * Adds a new variable to the state with an initial value.
     * @param name the tag to associate with the new state
     * @param value the initial value of the state
     * @param <T> the type of the initial value
     */
    public <T> void addState(String name, T value);
    
    /**
     * Removes the state with the specified name
     * @param name the name of the state to remove
     * @return true if the removal is successful, false if the state cannot
     * be found
     */
    public boolean removeState(String name);

    /**
     * Returns the value for the specified state
     * @param name the tag associated with the desired state
     * @param <T> the type of the expected value
     * @return the value of the state with the specified tag
     */
    public <T> T getState(String name);

    /**
     * Changes the specified state's value and calls handleSubscription()
     * on all Subscribers associated with the state.
     * @param name the tag associated with the desired state
     * @param newValue the new value for the state
     * @param <T> the type of the new value
     */
    public <T> void setState(String name, T newValue);

    /**
     * Adds a specific Subscriber to the specified state. The Subscriber's 
     * handleSubscription() method will be called whenever the state changes.
     * @param name the tag associated with the desired state
     * @param subscriber the Subscriber to attach to the state
     */
    public void addSubscription(String name, Subscriber subscriber);
    
    /**
     * Removes the specified Subscriber from the state with the specified
     * name. Uses the Subscriber's equals() method for comparison.
     * @param name the name of the state the subscriber is attached to
     * @param subscriber the subscriber to remove
     * @return true if the removal is successful, false if the Subscriber
     * it not found
     */
    public boolean removeSubscription(String name, Subscriber subscriber);
    
    
    /**
     * Removes the specified Subscriber all states.
     * Uses the Subscriber's equals() method for comparison.
     * @param subscriber the subscriber to remove
     * @return true if the removals are successful, false if the Subscriber
     * it not found
     */
    public boolean removeSubscription(Subscriber subscriber);
}