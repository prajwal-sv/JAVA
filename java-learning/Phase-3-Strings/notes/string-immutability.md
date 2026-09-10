# String Immutability

A `String` cannot be changed after it is created. Methods such as `concat()`, `replace()`, and `toUpperCase()` return a new String.

```java
String value = "java";
value.toUpperCase();
System.out.println(value); // java

value = value.toUpperCase();
System.out.println(value); // JAVA
```

For many changes, use `StringBuilder` to avoid creating many temporary String objects.
