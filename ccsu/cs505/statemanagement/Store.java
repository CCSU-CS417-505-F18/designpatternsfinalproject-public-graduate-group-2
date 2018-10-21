package ccsu.cs505.statemanagement;

public interface Store {
    public <T> void addState(String stateName, T value);
    public <T> T getState(String stateName);
    public <T> void setState(String stateName, T value);
    public <T> void addSubscription(String stateName, Subscriber subscriber);    
}
