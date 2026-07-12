# Bank Account CLI

A simple command-line bank account program written in Java. This was one of my early practice projects while learning Object-Oriented Programming (OOP) in Java.

## What it does

The program lets a user manage a bank account through a text menu:

1. Deposit money
2. Withdraw money
3. Check balance
4. Exit

## Concepts practiced

- **Classes and Objects** — `BankAccount` is a class, and a `BankAccount` object is created for the user.
- **Constructors** — used to set up the account holder's name and starting balance.
- **Methods** — `deposit()`, `withdraw()`, and `showBalance()` handle the account logic.
- **Input validation** — the program checks for invalid inputs, like negative deposit amounts or withdrawing more money than the balance.
- **Exception handling** — `try-catch` blocks handle cases where the user types something that isn't a number, so the program doesn't crash.
- **Loops and Switch statements** — a `while` loop keeps the menu running until the user chooses to exit, and a `switch` statement handles each menu choice.

## How to run it

1. Make sure you have Java installed.
2. Compile the program:
   ```
   javac BankAccountDemo.java
   ```
3. Run it:
   ```
   java BankAccountDemo
   ```
4. Follow the on-screen menu to deposit, withdraw, or check your balance.

## What I'm working on next

This project used basic classes and methods. My next step is learning encapsulation properly (using `private` fields with getters/setters), followed by inheritance, polymorphism, and abstraction — the remaining OOP pillars.

## Note

This is a learning project, not a production banking system. It's meant to demonstrate basic Java and OOP concepts as I build toward backend development with Spring Boot.
