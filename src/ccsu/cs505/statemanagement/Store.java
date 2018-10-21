/**
 *  @ package statemanagement
 *  contain functionality for global state management. It allow users to add
 * and manage global state as well as connect tothe global state so that components can
 * dynamically react to changes in the global state.
 */
package ccsu.cs505.statemanagement;

/**
 * @ store storethe global state and provide method for managing the global state
 */
public interface Store {
    /**
     * @ addState() add a new variable to the state with an initial value
     * @param stateName
     * @param value
     * @param <T>
     */
    public abstract <T> void addState(String stateName, T value);

    /**
     * @ getState() returns the value for the specified state
     * @param stateName
     * @param <T>
     * @return
     */
    public abstract <T> T getState(String stateName);

    /**
     * @ setState() changes the specified state and call handle on all associate subscriber
     * @param stateName
     * @param value
     * @param <T>
     */
    public abstract <T> void setState(String stateName, T value);

    /**
     * @ addSubscriber() add a specific subsriber to the specified state
     *   the subscriber handle method whenever the state changes
     * @param stateName
     * @param subscriber
     * @param <T>
     */
    public abstract <T> void addSubscription(String stateName,
                                             Subscriber subscriber);
}

