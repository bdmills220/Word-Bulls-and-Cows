# Bulls & Cows (Word Mastermind)

## Overview

Bulls & Cows is a classic word-guessing game in which a player attempts to guess a secret four-letter word.

After each guess, feedback is provided in the form of:

* **Bulls**: Correct letters in the correct position.
* **Cows**: Correct letters in the wrong position.

The objective is to guess the secret word in as few turns as possible.

This project was developed in Java using object-oriented programming concepts and features both single-player and two-player game modes.

---

## Features

### Single Player Mode

* The computer randomly selects a secret four-letter word.
* The player attempts to guess the word.
* Bulls and Cows feedback is provided after each guess.

### Two Player Mode

* Player 1 enters a secret four-letter word.
* Player 2 attempts to guess it.
* The secret word is hidden before gameplay begins.

### Additional Features

* Menu-driven console interface
* Input validation
* Quit confirmation
* Win/loss statistics tracking
* Proper Bulls & Cows scoring
* Support for repeated letters according to official game rules

---

## Game Rules

1. A secret four-letter word is chosen.
2. The guessing player enters a four-letter word.
3. The game reports:

   * Bulls = correct letter in the correct position
   * Cows = correct letter in the wrong position
4. Bulls are counted before Cows.
5. Each letter can only contribute to the score once.
6. Continue guessing until the secret word is found.

### Example

Secret Word:

BOOK

Guess:

BOOT

Result:

3 Bulls, 0 Cows

Explanation:

* B is correct and in the correct position.
* O is correct and in the correct position.
* O is correct and in the correct position.
* T is not in the secret word.

---

## Project Structure

### BCGame.java

The driver class that:

* Displays the menu
* Starts game modes
* Handles user interaction
* Displays statistics

### BCBoard.java

The game board class that:

* Selects or stores the secret word
* Processes guesses
* Calculates Bulls and Cows
* Performs input validation

### BCPlayer.java

The player class that:

* Stores wins and losses
* Displays player statistics

---

## How to Run

### Compile

```bash
javac BCGame.java BCBoard.java BCPlayer.java
```

### Run

```bash
java BCGame
```

---

## Sample Gameplay

```text
=================================
         BULLS & COWS
=================================

Welcome to Bulls & Cows!

Rules:
- Guess the secret 4-letter word.
- Bulls = correct letter in the correct position.
- Cows = correct letter in the wrong position.
- Repeated letters count only once.
- Bulls are counted before Cows.

=========================
        MAIN MENU
=========================
1. Single Player
2. Two Player
3. Statistics
4. Quit

Select an option: 1

Turn 1 - Enter a 4-letter word: frog
Result: 2 Bull(s), 1 Cow(s)

Turn 2 - Enter a 4-letter word: fish

Congratulations!
You guessed the word: fish
```

---

## Learning Objectives

This project demonstrates:

* Object-oriented design
* Class interaction
* User input handling
* Validation techniques
* Game logic implementation
* Algorithm development
* Console application development in Java

---

## Author

Brady Mills
