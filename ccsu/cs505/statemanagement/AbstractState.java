package ccsu.cs505.statemanagement;

import java.util.List;
import java.util.LinkedList;

/**
 * Abstract class for a state stored in the Store. Has functionality to attach
 * and remove subscribers as well as to notify the subscribers when the state's
 * value changes;
 */
class AbstractState<T> {
    private List<Subscriber> subscribers;
    
    protected AbstractState() {
        subscribers = new LinkedList<Subscriber>();
    }
    
    public void addSubscriber(Subscriber<? super T> sub) {
        subscribers.add(sub);
    }
        
    public boolean removeSubscriber(Subscriber sub) {
        return subscribers.remove(sub);
    }

    public void callSubscribers(T newValue) {
        for (Subscriber sub : subscribers) {
            sub.handleSubscription(newValue);
        }
    }
}
