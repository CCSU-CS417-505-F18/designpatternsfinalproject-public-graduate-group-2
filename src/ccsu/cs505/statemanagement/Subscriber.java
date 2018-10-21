/**
 *  @ package statemanagement
 *  contain functionality for global state management. It allow users to add
 * and manage global state as well as connect tothe global state so that components can
 * dynamically react to changes in the global state.
 */
package ccsu.cs505.statemanagement;

/**
 * @ subscriber
 *   allow object to be attached to a state in the store so that the handle method
 *   get called whenever state value changes.
 */
public interface Subscriber {
    public void handleSubscription();
}
