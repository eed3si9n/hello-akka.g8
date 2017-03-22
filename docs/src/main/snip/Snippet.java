// #tell_snippet
// Tell the 'greeter' to change its 'greeting' message
greeter.tell(new WhoToGreet("akka"), ActorRef.noSender());
// end #tell_snippet

// #self_snippet
// From within an Actor
greeter.tell(new Greet(), getSelf());
// end #self_snippet

// #sender_snippet
// From within the Greeter Actor
getSender().tell(new Greeting(greeting), getSelf());
// end #sender_snippet
