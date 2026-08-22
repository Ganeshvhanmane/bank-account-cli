# Bank Account CLI

A simple command-line bank account program written in Java. This was one of my early practice projects while learning Object-Oriented Programming (OOP) in Java.

## What it does

The program lets a user create an account by choosing a type, then manage it through a text menu:

**Account types:**
1. Savings Account (fixed 4% interest, shown as a yearly estimate on creation)
2. Current Account (allows withdrawing beyond balance, up to a fixed overdraft limit)

**Menu (after account creation):**
1. Deposit money
2. Withdraw money
3. Check balance
4. Exit

## Concepts practiced

- **Classes and Objects** — `BankAccount`, `SavingsAccount`, and `CurrentAccount` are classes; an object is created based on the account type the user picks.
- **Constructors** — set up the account holder's name and starting balance, including chaining child constructors to the parent with `super()`.
- **Methods** — `deposit()`, `withdraw()`, `showBalance()`, `getBalance()` handle core account logic.
- **Input validation** — checks for invalid inputs, like negative deposit amounts or withdrawing more than allowed.
- **Exception handling** — `try-catch` blocks handle non-numeric input so the program doesn't crash.
- **Loops and Switch statements** — a `while` loop keeps the menu running until exit; a `switch` statement handles each choice.
- **Encapsulation** — `accountHolder` and `balance` are `private`, forcing all access through methods instead of direct field access. A `protected debitBalance()` method gives subclasses controlled write-access without exposing the raw field.
- **Inheritance** — `SavingsAccount` and `CurrentAccount` both `extend BankAccount`, inheriting shared fields and methods instead of duplicating them. Each adds its own fields (`interestRate`, `overdraftLimit`) and behavior.
- **Method Overriding (runtime polymorphism)** — `CurrentAccount` overrides `withdraw()` to allow overdraft, using `@Override`. Confirmed with dynamic dispatch: a variable declared as `BankAccount` but holding a `CurrentAccount` object correctly calls the overridden version at runtime.
- **Declared type vs actual object type** — practiced the distinction between what a variable is *declared* as (controls which methods you can call) and what object it *actually holds* (controls which overridden method runs).

## OOP pillars — current status

- ✅ Encapsulation — done
- ✅ Inheritance — done
- 🔶 Polymorphism — runtime polymorphism (overriding) done; compile-time polymorphism (method overloading) not yet added
- ⬜ Abstraction — not yet added (planned: make `BankAccount` an `abstract class`, since a generic account doesn't exist in real banking)

## How to run it

1. Make sure you have Java installed.
2. Compile the program:
   ```
   javac BankAccountCLI.java
   ```
3. Run it:
   ```
   java BankAccountCLI
   ```
4. Choose an account type, then use the menu to deposit, withdraw, or check your balance.

## What I'm working on next

Adding method overloading and turning `BankAccount` into an abstract class, to complete all four OOP pillars in this project.

## Note

This is a learning project, not a production banking system. It's meant to demonstrate core Java and OOP concepts as I build toward backend development with Spring Boot.