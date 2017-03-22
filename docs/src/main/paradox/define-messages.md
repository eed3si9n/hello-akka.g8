
Define our Messages
-------------------

An Actor does not have a public API in terms of methods that you can invoke. Instead its public
API is defined through messages that the actor handles. Messages can be of arbitrary
type (any subtype of `Object` in Java or `Any` in Scala).  This means that we
can send boxed primitive values (such as `String`, `Integer`,
`Boolean` etc.) as messages or plain data structures like arrays and
collection types. However, since the messages are the Actor's public API, you should define
messages with good names and rich semantic and domain specific meaning, even if it's just wrapping
your data type. This will make it easier to use, understand and debug actor-based systems.

Now we want to define three different messages;

- `WhoToGreet` redefines the new greeting
- `Greet` asks the Actor for latest greeting
- `Greeting` returns the latest greeting

Let's start by defining the messages in Java (we are putting them inside an outer `HelloAkkaJava` class,
containing our full sample). It is **very important** that the messages we create are immutable (meaning that
they cannot be changed), if not we run the risk of accidentally sharing state between two different Actors
which will violate the Actor Model. In this sample we will not use any remoting, but it is a good practice to
always mark your messages as `Serializable` since then you will not run in to any runtime issues if
you decide to scale out (on to multiple nodes) with Akka but forget to go back and reimplement your messages.

```java
// Java code

public static class Greet implements Serializable {}

public static class WhoToGreet implements Serializable {
    public final String who;
    public WhoToGreet(String who) {
        this.who = who;
    }
}

public static class Greeting implements Serializable {
    public final String message;
    public Greeting(String message) {
        this.message = message;
    }
}
```

This is the way we would define the messages in Scala.  In Scala case classes and case objects make
excellent messages since they are immutable and have support for pattern matching, something we will
take advantage of in the Actor when matching on the messages it has received. Another advantage case
classes has is that they are marked as serializable by default.

```scala
// Scala code

case object Greet
case class WhoToGreet(who: String)
case class Greeting(message: String)
```
