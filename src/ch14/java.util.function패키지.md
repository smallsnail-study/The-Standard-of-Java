# 14-7 java.util.fuction패키지(1/3)

### 자주 사용되는 다양한 함수형 인터페이스를 제공

| 함수형 인터페이스        | 메서드                           | 설명                                      |
|------------------|-------------------------------|-----------------------------------------|
| java.lang.Runnable | void run()                    | 매개변수도 없고, 반환값도 없음.                      |
| ``Supplier<T>``                            | T get() → T                    | 매개변수는 없고, 반환값만 있음                       |
| ``Consumer<T>``     | T→ void accept(T t)           | Supplier와 반대로 매개변수만 있고,반환값이 없음.         |
| ``Function<T,R>``    | T→ R apply(T t) → R           | 일반적인 함수, 하나의 매개변수를 받아서 결과를 반환.          |
| ``Predicate<T>``     | T→ boolean test(T t) → boolean | 조건식을 표현하는데 사용됨.매개변수는 하나, 반환타입은 boolean. |

```java
Predicate<String> isEmptyStr = s -> s.length()==0;
String s = "";

if(isEmptyStr.test(s)) // if(s.length()==0)
	System.out.println("This is an empty String.");
```

Q. 아래의 빈 칸에 알맞은 함수형 인터페이스(java.util.function패키지)를 적으시오.

```java
[ Supplier<Integer>         ] f = ()-> (int)(Math.random()*100)+1;
[ Consumer<Integer>         ] f = i -> System.out.print(i+", ");
[ Predicate<Integer>        ] f = i -> i%2==0;
[ Function<Integer,Integer> ] f = i -> i/10*10;
```

# 14-7 java.util.fuction패키지(2/3)

### 매개변수가 2개인 함수형 인터페이스

함수명에 Bi가 들어간다.

| 함수형 인터페이스                                | 메서드 | 설명                                    |
|------------------------------------------| --- |---------------------------------------|
| ``BiConsumer<T,U>``                      | T,U→ void accept(T t, U u) | 두개의 매개변수만 있고,반환값이 없음.                 |
| ``BiPredicate<T,U>``                     | T,U→ boolean test(T t, U u) → boolean | 조건식을 표현하는데 사용됨. 매개변수는 둘, 반환값은 boolean |
| ``BiFuction<T,U,R>``<br>T,U는 입력값, R은 출력값 | T,U→ R apply(T t, U u) → R | 두개의 매개변수를 받아서 하나의 결과를 반환              |

매개변수가 3개 필요한 경우 직접 만들어 사용해야한다.

```java
@FunctionalInterface
interFace TriFunction<T,U,V,R> {
	R apply(T t, U u, V v);
}
```

# 14-7 java.util.fuction패키지(3/3)

### 매개변수의 타입과 반환타입이 일치하는 함수형 인터페이스

| 함수형 인터페이스                      | 메서드 | 설명 |
|--------------------------------| --- | --- |
| ``UnaryOperator<T>``<br>단항연산자  | T → T apply(T t) → T | Function의 자손, Function고 ㅏ달리 매개변수와 결과의 타입이 같다. |
| ``BinaryOperator<T>``<br>이항연산자 | T,T → T apply(T t, T t) → T | BiFunction의 자손, BiFunction과 달리 매개변수와 결과의 타입이 같다. |

```java
@FuctionalInterface
public interface UnaryOperator<T> extends Function<T,T> {
	static <T> UnaryOperator<T> identity(){ // identity는 항등함수
		return t -> t; // 항등함수 : t를 입력하면 아무 작업없이 그대로 t를 반환
	}
}
```