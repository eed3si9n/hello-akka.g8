Define our Actor
----------------

The Actor is the unit of execution in Akka.  Actors are object-oriented in the sense that they encapsulate
state and behavior, but they have much stronger isolation than regular objects in Java or Scala. The Actor
model prevents sharing state between Actors and the only way to observe another actor's state is by sending
it a message asking for it. Actors are extremely lightweight, they are only constrained by memory of which
they consume only a few hundred bytes each &#8212; this means you can easily create millions of concurrent
Actors in a single application. Their strong isolation principles together with the event-driven model (that
we will talk about later on) and location transparency makes it easy to solve hard concurrency and scalability
problems in an intuitive way.

You create an Actor in Java by defining a class that extends `UntypedActor` and implement the
`onReceive` method (in Scala you have to extend `Actor` trait and implement the
`receive` method). It is in the `onReceive` method that you define the behavior; how
the Actor should react to the different messages it receives.  An Actor can have &#8212; and often has &#8212;
state.  Accessing or mutating the internal state of an Actor is fully thread safe since protected by the Actor model.

So, let's now create a `Greeter` Actor with a single variable `greeting` as its state, holding on to the latest
defined greeting, and in its `onReceive` method let's add the behavior for how it should react upon receiving
the `WhoToGreet` and the `Greet` messages.

Let's start by creating our Actor in Java (you can find the code in the <a href="#code/src/main/java/HelloAkkaJava.java"
 class="shortcut">HelloAkkaJava.java</a> file):

Java
:    @@snip [HelloAkkaJava.java]($g8src$/java/HelloAkkaJava.java) { #actor_snippet }

Actors like this one are "untyped" in the sense that the type of message received is not restricted—it is 
`Object` as shown above. There are also typed actors, but we will 
not concern ourselves with those now, the normal actors are the untyped ones.

Don't worry about the `getSender()`, `tell(..)` and `getSelf()` API calls,
we will get to that soon when we talk about sending and replying to messages.

Now let's implement it in Scala. As you can see, Scala's pattern matching features really simplify working
with Actors, but apart from that it's pretty similar to the Java version (you can find the code in the
<a href="#code/src/main/scala/HelloAkkaScala.scala" class="shortcut">HelloAkkaScala.scala</a> file).

Scala
:    @@snip [HelloAkkaScala.scala]($g8src$/scala/HelloAkkaScala.scala) { #actor_snippet }

You will notice one difference to the Java version: here we do not
explicitly pass unhandled messages to the `unhandled()` method.
This is not necessary since the behavior defined by the
`receive` method is expressed as a so-called <em>partial
  function</em>, which means that all messages for which no matching
`case` statement is written down will be recognized as being not
handled and Akka will automatically pass them to the
`unhandled()` method for you.

Another difference is that the trait from which the Scala actor inherits is just called
`Actor`. This is the Scala API while `UntypedActor` is the Java API
for the same kind of actor.
