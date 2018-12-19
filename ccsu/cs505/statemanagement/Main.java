package ccsu.cs505.statemanagement;

/**
 * for internal testing only
 */
class Main {
    /**
     * main method
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Store store = (new StateManagement()).createStore();
        store.addState("status", "dull");
        Subscriber sub = new Subscriber1();
        store.addSubscription("status", sub);
        store.setState("status", "fun");
        store.removeSubscription("status", sub);
        store.setState("status", "over");
        System.out.println(store.getState("status").toString());        
    }
    
    public static class Subscriber1 implements Subscriber<String> {
        public void handleSubscription(String newValue) {
            System.out.println("Changed to " + newValue);
        }
    }
    
}
