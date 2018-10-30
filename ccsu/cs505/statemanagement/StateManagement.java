package ccsu.cs505.statemanagement;

/**
 * Can create stores. May do other things later on.
 * Note to instructor: Object.equals() and Object.hashCode() are not
 * implemented here because they wouldn't make sense; this class has no fields
 * to do comparisons with.
 */
public class StateManagement implements StoreFactory {
    
    /**
     * Creates and returns a Store.
     * @return the created Store
     */
    @Override
    public Store createStore() {
        return new ConcreteStore();
    }
}
