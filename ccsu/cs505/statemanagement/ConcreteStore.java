package ccsu.cs505.statemanagement;

import java.util.LinkedList;
import java.util.HashMap;

/**
 * Stores the global state and provides method for managing it.
 */
class ConcreteStore {
    private class State<T> {
		T value;
		private LinkedList<Subscriber> subscribers;
		
		State(value) {
			this.value = value;
			subscribers = new LinkedList<Subscriber>();
		}
		
		void addSubscriber(Subscriber<T> sub) {
			subscribers.add(sub);
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
    public <T> void addState(String name, T value) {
		states.put(name, new State<T>(value));
	}

    /**
     * Returns the value for the specified state
     * @param name the tag associated with the desired state
     * @param <T> the type of the expected value
     * @return the value of the state with the specified tag
     */
    public <T> T getState(String name) {
		return states.getKey(name).value;
	}

    /**
     * Changes the specified state's value and calls handleSubscription()
     * on all Subscribers associated with the state.
     * @param name the tag associated with the desired state
     * @param newValue the new value for the state
     * @param <T> the type of the new value
     */
    public <T> void setState(String name, T newValue) {
		State<T> state = states.getKey(name);
		state.value = newValue;
		state.callSubscribers();
	}

    /**
     * Adds a specific Subscriber to the specified state. The Subscriber's 
     * handleSubscription() method will be called whenever the state changes.
     * @param name the tag associated with the desired state
     * @param subscriber the Subscriber to attach to the state
     */
    public void addSubscription(String name, Subscriber subscriber) {
		states.getKey(name).addSubscriber(subscriber);
	}
}