/**
 *  @ package statemanagement
 *  contain functionality for global state management. It allow users to add
 * and manage global state as well as connect tothe global state so that components can
 * dynamically react to changes in the global state.
 */
package ccsu.cs505.statemanagement;

/**
 * @ StoreFactory
 *   specifies a method for creating Store objects.
 */

public interface StoreFactory {
    public Store createStore();
}
