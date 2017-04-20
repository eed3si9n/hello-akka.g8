Hello Akka
==========

This is a guide to create a simple Akka application.  You can get source code for this guide from <https://example.lightbend.com/v1/download/hello-akka?name=hello-akka> or from [Tech Hub project starter](http://developer.lightbend.com/start?category=akka&template=hello-akka).

In short, <a href="http://akka.io">Akka</a> is a toolkit and runtime for building highly concurrent,
distributed, and fault-tolerant event-driven applications on the JVM. Akka can be used with both Java
and Scala. One of the most powerful features of Akka is its <a href="http://en.wikipedia.org/wiki/Actor_model">
Actor Model</a> of concurrency, which you will learn more about in this tutorial.

Akka can be used from either Java or Scala and this tutorial has both Java and Scala sample code.

### Source code

The `src/main/java` directory contains the Java
source code `HelloAkkaJava.java`
and the `src/main/scala` directory contains the Scala
source code `HelloAkkaScala.scala`.

The sample in this tutorial is pretty simple; it consists of a <code>Greeter</code> Actor who holds
onto the latest defined <code>greeting</code> string and can respond to two actions; set a new greeting
string and return the latest greeting string.

Next let's get started.

@@@index

* [Define our messages](define-messages.md)
* [Define our messages](define-actor.md)
* [Create our Actor](create-actor.md)
* [Tell the Actor (to do something)](tell-actor.md)
* [Replying to Actor](replying-to-actor.md)
* [Using Inbox](using-inbox.md)
* [Test the App](test-app.md)
* [Run the App](run-app.md)

@@@
