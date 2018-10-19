package ccsu.cs505.statemanagement;

public abstract class Store {
    public abstract <T> void addState(String stateName, T value);
    public abstract <T> T getState(String stateName);
    public abstract <T> void setState(String stateName, T value);
    public abstract <T> void addSubscription(String stateName,
            Subscriber subscriber);    
}
