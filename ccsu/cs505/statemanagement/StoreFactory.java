package ccsu.cs505.statemanagement;

/**
 * Implemented by objects that create Stores.
 */

public interface StoreFactory {
    /**
     * Creates and returns a Store.
     * @return the created Store
     */
    public Store createStore();
}
