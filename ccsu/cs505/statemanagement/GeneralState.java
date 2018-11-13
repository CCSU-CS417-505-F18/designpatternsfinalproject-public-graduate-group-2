package ccsu.cs505.statemanagement;

import java.util.List;
import java.util.LinkedList;

/**
 * A general class for a state stored in the Store. Has functionality to
 * attach and remove subscribers as well as to notify the subscribers when the
 * state's value changes;
 */
class GeneralState<T> {
    private List<Subscriber> subscribers;
    
    protected GeneralState() {
        subscribers = new LinkedList<Subscriber>();
    }
    
    /**
     * attaches a subscriber to the state
     * @param sub the subscriber to attach
     */
    public void addSubscriber(Subscriber<? super T> sub) {
        subscribers.add(sub);
    }
    
    /**
     * removes a subscriber from the state
     * @param sub the subscriber to remove
     * @return true if the removal was successful, false otherwise
     */
    public boolean removeSubscriber(Subscriber sub) {
        return subscribers.remove(sub);
    }

    /**
     * calls handleSubscription on all the subscribers attached to this state
     * @param newValue the new value of the state to pass into the
     * handleSubscriptoin method
     */
    public void callSubscribers(T newValue) {
        for (Subscriber sub : subscribers) {
            sub.handleSubscription(newValue);
        }
    }
}
