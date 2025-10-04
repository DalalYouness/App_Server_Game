# 🎮 Java Multiplayer Number Guessing Game

This project is a **multithreaded client-server game** built in Java using **TCP sockets**.  
Multiple players can connect simultaneously to the server and try to guess a secret number.  
Each client plays independently — the server checks each guess and responds  
with hints until the player finds the correct number.

---

## 🚀 Features

- 🧩 **Multithreaded server** that handles multiple clients concurrently.  
- 🔢 Randomly generated secret number between 0 and 19.  
- 💬 Real-time communication between server and clients using socket streams.  
- 🧠 Each client plays independently (no broadcast between players).  
- ⚙️ Clean separation of logic between:
  - `ServerGame` → controls the main game logic.
  - `Communication` → handles messages and guesses from each client.

---



