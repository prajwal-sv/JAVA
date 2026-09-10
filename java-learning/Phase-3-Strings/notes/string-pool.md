# String Pool

Java stores string literals in a shared string pool. Equal literals can refer to the same pooled object.

```java
String first = "Java";
String second = "Java";
System.out.println(first == second); // true
```

A String created with `new` is a separate object. Use `equals()` for content comparison. `intern()` returns the pooled representation.
