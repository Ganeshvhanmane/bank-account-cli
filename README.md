# Bank Account CLI

A simple command-line bank account program written in Java. This was one of my early practice projects while learning Object-Oriented Programming (OOP) in Java.

## What it does

The program lets a user create an account by choosing a type, then manage it through a text menu:

**Account types:**
1. Savings Account (4% interest rate, calculated on request)
2. Current Account (allows withdrawing beyond balance, up to a fixed overdraft limit)

**Menu (after account creation):**
1. Deposit money
2. Withdraw money
3. Check balance
4. Show interest (calculates interest for Savings Account; shows a "not applicable" message for Current Account)
5. Exit

## Concepts practiced

- **Classes and Objects** — `BankAccount`, `SavingsAccount`, and `CurrentAccount` are classes; an object is created based on the account type the user picks.
- **Constructors** — set up the account holder's name and starting balance, including chaining child constructors to the parent with `super()`.
- **Methods** — `deposit()`, `withdraw()`, `showBalance()`, `getBalance()` handle core account logic.
- **Method Overloading (compile-time polymorphism)** — `deposit()` has multiple versions with different parameters.
- **Input validation** — checks for invalid inputs, like negative or zero deposit/withdrawal amounts, or withdrawing more than allowed.
- **Exception handling** — `try-catch` blocks handle non-numeric input so the program doesn't crash.
- **Loops and Switch statements** — a `while` loop keeps the menu running until exit; a `switch` statement handles each choice.
- **Encapsulation** — `accountHolder` and `balance` are `private`, forcing all access through methods instead of direct field access. A `protected debitBalance()` method gives subclasses controlled write-access without exposing the raw field.
- **Inheritance** — `SavingsAccount` and `CurrentAccount` both `extend BankAccount`, inheriting shared fields and methods instead of duplicating them. Each adds its own fields (`interestRate`, `overdraftLimit`) and behavior.
- **Method Overriding (runtime polymorphism)** — `CurrentAccount` overrides `withdraw()` to allow overdraft. `SavingsAccount` and `CurrentAccount` both override `showAccountType()`. `BankAccount` defines a default `showInterest()` ("not applicable"), which `SavingsAccount` overrides with its actual interest calculation — `CurrentAccount` inherits the default as-is. Confirmed with dynamic dispatch: a variable declared as `BankAccount` but holding a child object correctly calls the overridden version at runtime.
- **Declared type vs actual object type** — practiced the distinction between what a variable is *declared* as (controls which methods you can call) and what object it *actually holds* (controls which overridden method runs).
- **Abstraction** — `BankAccount` is an `abstract class`, so it can never be instantiated directly — only `SavingsAccount` or `CurrentAccount` can. It declares `abstract void showAccountType()`, forcing every subclass to define its own implementation.
- **Packages** — classes are organized into a `bank` package rather than one flat file.
- **Resource management** — a single `Scanner` is created in `main()` and passed into `operations()` as a parameter, then closed at the end of the program, instead of creating a separate `Scanner` inside each method.

## OOP pillars — status

- Encapsulation — done
- Inheritance — done
- Polymorphism — done (both runtime overriding and compile-time overloading)
- Abstraction — done

## How to run it

1. Make sure you have Java installed.
2. From the project root, compile:
   ```
   javac bank/*.java
   ```
3. Run it:
   ```
   java bank.BankAccountCLI
   ```
4. Choose an account type, then use the menu to deposit, withdraw, check your balance, or view interest.

## Note

This is a learning project, not a production banking system. It's meant to demonstrate core Java and OOP concepts as I build toward backend development with Spring Boot.