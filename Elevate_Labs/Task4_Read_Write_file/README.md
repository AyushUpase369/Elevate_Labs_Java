
# 🗒️ Text-based Notes Manager (Java)

A simple console-based Notes Manager built in Java that allows users to write and view text notes. Notes are saved to a file using `FileWriter` and displayed using `BufferedReader`.

---

## 📁 Features

- Write notes via console input
- View all saved notes
- Notes are stored in a text file (`notes.txt`)
- Simple menu-driven interface
- Uses basic Java I/O (`FileWriter`, `BufferedReader`)

---

3. **Follow the Menu**
   - **Option 1:** Write a new note (saved to `notes.txt`)
   - **Option 2:** View all notes
   - **Option 3:** Exit the program

---

## 📂 Notes Storage

All notes are stored in a plain text file named `notes.txt` in the same directory as the program.

---

## 📝 Example

```
--- Notes Manager ---
1. Write a note
2. View notes
3. Exit
Enter your choice: 1
Enter your note: This is my first note!
Note saved successfully!

--- Notes Manager ---
1. Write a note
2. View notes
3. Exit
Enter your choice: 2

--- Your Notes ---
- This is my first note!
```

---

## 💡 Note

- If `notes.txt` does not exist, it will be created automatically.
- Notes are appended to the file, so previous notes are not overwritten.
