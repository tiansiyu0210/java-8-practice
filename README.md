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
intern() method

- [protected](https://blog.csdn.net/jinyongqing/article/details/19756291)



