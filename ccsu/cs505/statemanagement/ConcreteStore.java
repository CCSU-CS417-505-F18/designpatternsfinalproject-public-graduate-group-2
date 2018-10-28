package ccsu.cs505.statemanagement;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.Set;

/**
 * Stores the global state and provides method for managing it.
 */
class ConcreteStore implements Store {
    private class State<T> {
        T value;
        private LinkedList<Subscriber> subscribers;

        State(T value) {
            this.value = value;
            subscribers = new LinkedList<Subscriber>();
        }

        void addSubscriber(Subscriber<T> sub) {
            subscribers.add(sub);
        }
        
        boolean removeSubscriber(Subscriber sub) {
            return subscribers.remove(sub);
        }

        void callSubscribers() {
            for (Subscriber sub : subscribers) {
                sub.handleSubscription(value);
            }
        }
    }
	
    HashMap<String, State<?>> states;

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
    public <T> void addState(String name, T value) {
        states.put(name, new State<T>(value));
    }
    
    /**
     * Removes the state with the specified name
     * @param name the name of the state to remove
     * @return true if the removal is successful, false if the state cannot
     * be found
     */
    @Override
    public boolean removeState(String name) {
        return states.remove(name) != null;
    }

    /**
     * Returns the value for the specified state
     * @param name the tag associated with the desired state
     * @param <T> the type of the expected value
     * @return the value of the state with the specified tag
     */
    @Override
    public <T> T getState(String name) {
        return (T) states.get(name).value;
    }

    /**
     * Changes the specified state's value and calls handleSubscription()
     * on all Subscribers associated with the state.
     * @param name the tag associated with the desired state
     * @param newValue the new value for the state
     * @param <T> the type of the new value
     */
    @Override
    public <T> void setState(String name, T newValue) {
        State<T> state = (State<T>) states.get(name);
        state.value = newValue;
        state.callSubscribers();
    }

    /**
     * Adds a specific Subscriber to the specified state. The Subscriber's 
     * handleSubscription() method will be called whenever the state changes.
     * @param name the tag associated with the desired state
     * @param subscriber the Subscriber to attach to the state
     */
    @Override
    public void addSubscription(String name, Subscriber subscriber) {
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
    public boolean removeSubscription(String name, Subscriber subscriber) {
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
    public boolean removeSubscription(Subscriber subscriber) {
        Set<String> stateNames = states.keySet();
        boolean somethignRemoved = false;
        for (String name : stateNames) {
            somethignRemoved = somethignRemoved ||
                    removeSubscription(name, subscriber);
        }
        return somethignRemoved;
    }
}