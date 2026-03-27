# Day 1: Object Creation, Beans, and Inversion of Control

## 1. What is happening in `Main.java`?

In `Main.java`, this line creates objects and connects them:

```java
CoursePurchaser coursePurchaser = new CoursePurchaser(new SanketCourse());
coursePurchaser.giveMePriceOfCourse();
```

- `new SanketCourse()` creates an instance of `SanketCourse`.
- `new CoursePurchaser(...)` creates an instance of `CoursePurchaser`.
- The `SanketCourse` object is given to `CoursePurchaser` through its constructor.

## 2. What does "bean" mean here?

In Spring, a "bean" is simply an object managed by the Spring container. In plain Java, the object created with `new` is not yet a Spring bean.

So in this example:

- `SanketCourse` is a normal Java object instance.
- `CoursePurchaser` is a normal Java object instance.
- If we were using Spring, these could become beans when Spring creates and manages them.

## 3. What is Inversion of Control (IoC)?

Inversion of Control means we do not let a class create its own dependencies. Instead, the dependency is provided to the class from the outside.

For example, `CoursePurchaser` does not create a `SanketCourse` itself. It only knows about the interface `JavaCourse`:

```java
public class CoursePurchaser {
    private final JavaCourse javaCourse

    public CoursePurchaser(JavaCourse javaCourse) {
        this.javaCourse = javaCourse;
    }

    public void giveMePriceOfCourse() {
        javaCourse.purchaseCourse();
    }
}
```

The control of creating the course object is inverted: instead of `CoursePurchaser` controlling it, the caller (`Main`) controls it.

## 4. What is Dependency Injection?

Dependency Injection is a specific way to implement IoC. It means providing required dependencies to a class rather than letting the class create them.

In this code, constructor injection is used:

- `CoursePurchaser` requires a `JavaCourse`
- `Main` injects a `SanketCourse` into `CoursePurchaser`

This is the core idea of IoC and DI.

## 5. Why this is useful

- `CoursePurchaser` depends on the abstraction `JavaCourse`, not a concrete class.
- This makes the code easier to change: you can pass any other `JavaCourse` implementation later.
- It makes testing easier because you can pass a mock or stub implementation.

## 6. Summary for this example

- `new SanketCourse()` is object creation.
- In plain Java, this is not a Spring bean yet.
- `CoursePurchaser` receives the dependency from outside.
- That external provision of the dependency is Inversion of Control.
- When a framework like Spring manages object creation and wiring, the objects are called beans.

## 7. Important note

In this code, the IoC pattern is manually implemented: `Main` wires the objects.

If you add Spring later, Spring will automatically create the objects and inject them for you, and then `SanketCourse` and `CoursePurchaser` become Spring beans.
