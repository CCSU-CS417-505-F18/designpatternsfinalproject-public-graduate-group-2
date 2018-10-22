package ccsu.cs505.statemanagement;

/**
 * Objects implementing this can be attached to a state in Store. If done,
 * the handleSubscription() method will be called whenever the state's value
 * changes.
 * @param <T> the type of the value of the state that this Subscriber is to be
 * attached to.
 */
public interface Subscriber<T> {
    /**
     * Called whenever the values of states associated with this subscriber
     * change.
     * @param newValue the new value the state this Subscriber is attached
     * to was (just) given.
     */
    public void handleSubscription(T newValue);
}
