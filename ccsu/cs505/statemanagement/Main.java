/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccsu.cs505.statemanagement;

/**
 *
 * @author Daniel
 */
public class Main {
    public static void main(String[] args) {
        StateManagement sm = new StateManagement();
        Store store = sm.createStore();
        store.addState("test", "this is a test");
        System.out.println(store.getState("test").toString());
        store.addSubscription("test", new Subscriber1());
        store.addSubscription("test", new Subscriber2());
        store.setState("test", "NEW TEST");
        System.out.println(store.getState("test").toString());
        System.out.println(store.<String>getState("test").replace("E", "O"));        
        //store.addState("number", 5.05);
        //System.out.println(store.getState("number").toString());
    }
    
    static class Subscriber1 implements Subscriber<String> {
        @Override
        public void handleSubscription(String newValue) {
            System.out.println("Value was just chnaged to: " + newValue);
        }
    }
    
    static class Subscriber2 implements Subscriber<String> {
        @Override
        public void handleSubscription(String newValue) {
            System.out.println("The new value's length is: " + newValue.length());
        }
    }
}
