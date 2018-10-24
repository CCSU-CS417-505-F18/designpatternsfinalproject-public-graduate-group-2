package ccsu.cs505.statemanagement;

/**
 * Can create stores. May do other things later on.
 */
public class StateManagement implements StoreFactory {
    
    /**
     * Creates and returns a Store.
     * @return the created Store
     */
    public Store createStore() {
        return new ConcreteStore();
    }
}
