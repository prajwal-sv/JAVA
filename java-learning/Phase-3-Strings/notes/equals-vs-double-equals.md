# equals() vs ==

- `equals()` compares String contents.
- `==` compares object references.

```java
String first = new String("Java");
String second = new String("Java");

first.equals(second); // true
first == second;      // false
```

Use `equalsIgnoreCase()` when letter case should not matter. For safe comparison when a value may be null, use `"Java".equals(value)`.
