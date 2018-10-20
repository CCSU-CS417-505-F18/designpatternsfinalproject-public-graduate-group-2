<h1>CS505 State Management System</h1>
<h2>What is it?</h2>
<p>This is a system that allows you to create and manage global state for
your application and have different parts of your application behave
dynamically based on this state. More specifically, you use this system to
create a Store object, store global variable (global state) in this object, and
give the store methods to call when certain state (specified by you) changes.
We are open to adding additional functionality if it would be helpful.</p>
<h2>Why use it?</h2>
<p>This is great for when you want you application to have different modes
of some sort or if you want your app to react and behave differently when certain
global values change.
<h2>Relevant Classes/Interfaces</h2>
We have the:
<ul>
	<li><strong>StoreFactory Interface:</strong> This is the interface implemented
	by the StateManagement class (see below). It specifies a method for creating
	Store objects (Stores store the global state, see below). The main reason for this
	interface is to follow the Factory design pattern. It has little other use.</li>
	<li><strong>StateManagement Class:</strong> This will definitely have the
	functionality to create Stores. We may decide to add  more functionality later.</li>
	<li><strong>Store Interface:</strong> Details functionality for addings state
	to the store, reading the state, updating the state (and thereby runnign the
	subscription methods for that state), and attaching subscription methods to states.
	You will be able to get concrete implementations of the Store interface
	through the StateManagement Class.</li>
	<li><strong>Subscriber Interface:</strong> Remember earlier when we said you
	could attach methods to state that will run whenever the state changes? Well, you
	can't directly pass methods in Java, so we instead have you pass objects that
	implement this interface. This interface only has one method--the method to
	be called when certain state changes.</li>
</ul>
<h2>How to use it</h2>
Here's how to get started:
<ol>
	<li>Import ccsu.cs505.statemanagement</li>
	<li>Create a StateManagement object (public constructor--no parameters)</li>
	<li>Create a store by calling the StateManagement object's createStore() method
	(returns a Store).</li>
	<li>Use the store's addState() method to create state values to be stored there.
	You'll need to pass a String for later referencing the state variable and an initial
	value for that variable.</li>
	<li>Create at least one class implementing the Subscriber interface (or make
	the class you're already in implement it). Make sure to implement the interface's
	handleSubscription() method.</li>
	<li>Use the store's addSubscriber() method to add subscription methods (i.e
	Subscriber.handleSubscription()) the state you just added. You'll need to pass the String
	tag for the state and a Subscriber with the subscription method to be called when the
	state changes.</li>
	<li>Use the store's setState() method to update the state's value. You'll need
	to pass the state's String tag and the new value. This will also call the
	handleSubscritoin() method in all Subscribers attached to this state.</li>
	<li>Add more state and more Subscribers and watch how much more reactive
	your application is.</li>
	<li>Also note that the store has a getState() method that returns the value
	of the state with the specified String tag. Use this if you want your app to
	behave differently based on the state's value.</li>
</ol>
