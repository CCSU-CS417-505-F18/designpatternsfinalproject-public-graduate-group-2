package ccsu.cs505.statemanagement;

import java.util.HashMap;
import java.util.Set;

/**
 * Stores the global state and provides method for managing it.
 * Note to Instructor: the Object.equals() and Object.hashCode() are not
 * overridden here because even though it is possible for two Stores to have
 * HashMaps with the same keys and values, the HashMap's contents are not meant
 * to identify the store. Two stores are meant to be interpreted as two
 * DIFFERENT places to store information--to be used DIFFERENTLY by different
 * parts of the app. The same can be said for the private State class within
 * this store.
 */
class ConcreteStore implements Store {
    private static class State<T> extends GeneralState<T> {
        private T value;

        State(T value) {
            super();
            this.value = value;
        }
        
        //the methods are public to match the observer pattern specification
        
        /**
         * gets the state's value
         * @return the state's value
         */
        public T getState() {
            return value;
        }
        
        /**
         * set's the state's value
         * @param newValue the new value for the state
         */
        public void setState(T newValue) {
            value = newValue;
            callSubscribers(newValue);
        }
    }
	
    private HashMap<String, State<?>> states;

    ConcreteStore() {
        states = new HashMap<String, State<?>>();
    }
	
    /**
     * Adds a new variable to the state with an initial value.
     * @param name the tag to associate with the new state
     * @param value the initial value of the state
     * @param <T> the type of the initial value
     */
    @Override
    public synchronized <T> void addState(String name, T value) {
        states.put(name, new State<T>(value));
    }
    
    /**
     * Removes the state with the specified name
     * @param name the name of the state to remove
     * @return true if the removal is successful, false if the state cannot
     * be found
     */
    @Override
    public synchronized boolean removeState(String name) {
        return states.remove(name) != null;
    }

    /**
     * Returns the value for the specified state. Note: you will likely need
     * to either typecast whatever is returned or pass the type you want via
     * type arguments in order to use the returned object properly.
     * @param name the tag associated with the desired state
     * @param <T> the type of the expected value
     * @return the value of the state with the specified tag
     */
    @Override
    public synchronized <T> T getState(String name) {
        return (T) states.get(name).getState();
    }

    /**
     * Changes the specified state's value and calls handleSubscription()
     * on all Subscribers associated with the state.
     * @param name the tag associated with the desired state
     * @param newValue the new value for the state
     * @param <T> the type of the new value
     */
    @Override
    public synchronized <T> void setState(String name, T newValue) {
        ((State<T>) states.get(name)).setState(newValue);
    }

    /**
     * Adds a specific Subscriber to the specified state. The Subscriber's 
     * handleSubscription() method will be called whenever the state changes.
     * @param name the tag associated with the desired state
     * @param subscriber the Subscriber to attach to the state
     */
    @Override
    public synchronized void addSubscription(String name, Subscriber subscriber) {
        states.get(name).addSubscriber(subscriber);
    }
    
    /**
     * Removes the specified Subscriber from the state with the specified
     * name. Uses the Subscriber's equals() method for comparison.
     * @param name the name of the state the subscriber is attached to
     * @param subscriber the subscriber to remove
     * @return true if the removal is successful, false if the Subscriber
     * it not found
     */
    @Override
    public synchronized boolean removeSubscription(String name, Subscriber subscriber) {
        return states.get(name).removeSubscriber(subscriber);
    }
    
    
    /**
     * Removes the specified Subscriber from all states.
     * Uses the Subscriber's equals() method for comparison.
     * @param subscriber the subscriber to remove
     * @return true if the removals are successful, false if the Subscriber
     * it not found
     */
    @Override
    public synchronized boolean removeSubscription(Subscriber subscriber) {
        Set<String> stateNames = states.keySet();
        boolean somethingRemoved = false;
        for (String name : stateNames) {
            somethingRemoved = removeSubscription(name, subscriber) ||
                    somethingRemoved;
        }
        return somethingRemoved;
    }
    
    @Override
    public String toString() {
        Set<String> stateNames = states.keySet();
        StringBuilder builder = new StringBuilder();
        for (String name : stateNames) {
            builder.append(name);
            builder.append(": ");
            builder.append(states.get(name).toString());
            builder.append(", ");
        }
        return builder.toString();
    }
}