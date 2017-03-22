Test the App
------------

Both the Java and Scala examples each have unit tests in the <a href="#code/src/test" class="shortcut">test</a>
directory.  The <a href="#code/src/test/java/HelloAkkaTest.java" class="shortcut">Java tests</a> use JUnit, while
the <a href="#code/src/test/scala/HelloAkkaSpec.scala" class="shortcut">Scala tests</a> use ScalaTest.

Both of these tests are making use of the excellent Akka
<a href="http://doc.akka.io/docs/akka/2.4.4/scala/testing.html" target="_blank">TestKit</a> module,
which makes it so much easier to test and verify concurrent code.

Making changes to the sample's source or the test source will cause the tests to be automatically re-run.
