# Java Strings

`String` is a class used to represent text. String literals use double quotes, for example `"Hello"`.

Useful basics:

- `length()` returns the number of UTF-16 code units.
- `charAt(index)` reads one character.
- `substring(start, end)` extracts a range; `end` is exclusive.
- `toUpperCase()` and `toLowerCase()` return changed copies.

Strings are objects, so compare their contents with `equals()`.
