# java-8-practice
- [Basic](#basic)

## Basic
- Primitive data types 

|Data  Type	| Size	| Description|
| :------------- | :------------- | :------------- |
|byte	| 1 byte	|Stores whole numbers from -128 to 127|
|short	| 2 bytes | Stores whole numbers from -32,768 to 32,767|
|int	| 4 bytes	|Stores whole numbers from -2,147,483,648 to 2,147,483,647|
|long	| 8 bytes	|Stores whole numbers from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807|
|float	| 4 bytes	|Stores fractional numbers from 3.4e−038 to 3.4e+038. Sufficient for storing 6 to 7 decimal digits|
|double	| 8 bytes	|Stores fractional numbers from 1.7e−308 to 1.7e+038. Sufficient for storing 15 decimal digits|
|boolean	| 1 bit	|Stores true or false values|
|char	| 2 bytes	|Stores a single character/letter or ASCII values|

> 1 byte = 8 bits

- Non-primitive data types

> Non-primitive data types - such as `String`, `Arrays` and `Classes`
> A primitive type has always a value, while non-primitive types can be null.


- Integer
  - Integer cache

  ```java
  private static class IntegerCache {
        static final int low = -128;
        static final int high;
        static final Integer[] cache;

        private IntegerCache() {
        }

        static {
            int var0 = 127;
            String var1 = VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
            int var2;
            if (var1 != null) {
                try {
                    var2 = Integer.parseInt(var1);
                    var2 = Math.max(var2, 127);
                    var0 = Math.min(var2, 2147483518);
                } catch (NumberFormatException var4) {
                }
            }

            high = var0;
            cache = new Integer[high - -128 + 1];
            var2 = -128;

            for(int var3 = 0; var3 < cache.length; ++var3) {
                cache[var3] = new Integer(var2++);
            }

            assert high >= 127;

        }
    }
  ```
  
  - valueOf()
    
    ```java
    public static Integer valueOf(int var0) {
        return var0 >= -128 && var0 <= Integer.IntegerCache.high ? Integer.IntegerCache.cache[var0 + 128] : new Integer(var0);
      }
    ```
  
- String

java 8
```java
public final class String implements java.io.Serializable, Comparable<String>, CharSequence {
    /** The value is used for character storage. */
    private final char value[];
}
```

java 9
```java
public final class String implements java.io.Serializable, Comparable<String>, CharSequence {
    /** The value is used for character storage. */
    private final byte[] value;

    /** The identifier of the encoding used to encode the bytes in {@code value}. */
    private final byte coder;
}
```

  - String, StringBuffer and StringBuilder
  
    [String, StringBuffer, and StringBuilder](https://stackoverflow.com/questions/2971315/string-stringbuffer-and-stringbuilder)
 
 - String Pool
 
 [intern() method](https://www.geeksforgeeks.org/interning-of-string/)
 
    - When the intern() method is executed then it checks whether the String equals to this String Object is in the pool or not.
    - If it is available, then the string from the pool is returned. Otherwise, this String object is added to the pool and a reference to      this String object is returned.
    - It follows that for any two strings s and t, s.intern() == t.intern() is true if and only if s.equals(t) is true.
  
  ```java
  class GFG {  
    public static void main(String[] args)  
    {  
        // S1 refers to Object in the Heap Area  
        String s1 = new String("GFG"); // Line-1  
  
        // S2 refers to Object in SCP Area 
        String s2 = s1.intern(); // Line-2  
          
        // Comparing memory locations 
        // s1 is in Heap 
        // s2 is in SCP 
        System.out.println(s1 == s2); //false
          
        // Comparing only values 
        System.out.println(s1.equals(s2)); //true
          
        // S3 refers to Object in the SCP Area  
        String s3 = "GFG"; // Line-3  
  
        System.out.println(s2 == s3);  //true
    }  
}  
```

```java
class GFG {  
    public static void main(String[] args)  
    {  
        // S1 refers to Object in the Heap Area  
        String s1 = new String("GFG"); // Line-1  
  
        // S2 now refers to Object in SCP Area  
        String s2 = s1.concat("GFG"); // Line-2  
  
        // S3 refers to Object in SCP Area 
        String s3 = s2.intern(); // Line-3  
  
        System.out.println(s2 == s3);  // true
  
        // S4 refers to Object in the SCP Area  
        String s4 = "GFGGFG"; // Line-4  
  
        System.out.println(s3 == s4);  //true
    }  
}  
```

> Explanation : We use intern() method to get the reference of corresponding SCP Object. In this case, when Line-2 executes s2 will have the value “GFGGFG” in it only creates one object. In Line-3, we try to intern s3 which is again with s2 in SCP area. s4 is also in SCP so all give output as true when compared.
  
- Static

1.父类（静态变量、静态语句块）

2.子类（静态变量、静态语句块）

3.父类（实例变量、普通语句块）

4.父类（构造函数）

5.子类（实例变量、普通语句块）

6.子类（构造函数）


- Exception

![alt text](https://github.com/CyC2018/CS-Notes/blob/master/notes/pics/PPjwP.png)


- Collection

![alt_text](https://github.com/CyC2018/CS-Notes/raw/master/notes/pics/73403d84-d921-49f1-93a9-d8fe050f3497.png)

## Set

- [TreeSet vs HashSet](https://stackoverflow.com/questions/25602382/java-hashset-vs-treeset-when-should-i-use-over-other/25602519)

- [TreeSet](https://www.callicoder.com/java-treeset/)

- [HashSet,TreeSet和LinkedHashSet的区别](https://www.cnblogs.com/Terry-greener/archive/2011/12/02/2271707.html)

## List

- [ArrayList vs LinkedList vs Vector](https://medium.com/@gilangkusumajati/arraylist-vs-linkedlist-vs-vector-22e1721a66b0)

- [ArrayList vs LinkedList](https://beginnersbook.com/2013/12/difference-between-arraylist-and-linkedlist-in-java/)


## Queue
- [priorityqueue](https://www.callicoder.com/java-priority-queue/);

## Map

![map](https://github.com/CyC2018/CS-Notes/raw/master/notes/pics/774d756b-902a-41a3-a3fd-81ca3ef688dc.png)

- [concurrenthashmap](https://www.cnblogs.com/yangming1996/p/8031199.html)

- [concurrenthashmap 2](https://www.baeldung.com/java-concurrent-map)

- Array to List

```java
Integer[] arr = {1, 2, 3};
List list = Arrays.asList(arr);
```

```
List list = Arrays.asList(1, 2, 3);
```



## Mutiplthread

![thread state](https://github.com/CyC2018/CS-Notes/raw/master/notes/pics/adfb427d-3b21-40d7-a142-757f4ed73079.png)

- [Threads and Executors](https://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/)
