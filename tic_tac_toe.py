# Creator: Aryan Patel
# Date created: February 27, 2021

# import libraries
from tkinter import *
from tkinter import messagebox

root = Tk()
root.title("Tic Tac Toe Game")

# variables to cycle through X and O
clicked = True
count = 0

# disables all the buttons after a win
def disable_buttons():
    for b in buttons:
        b.config(state = DISABLED)
    
# Function to determine the winner
def checkifwon(player):
    global winner
    winner = False

    if(b1["text"] == b2["text"] == b3["text"] == player):
        winner = True
        message = "CONGRATULATIONS! " + player + " wins!!"

        messagebox.showinfo("Tic Tac Toe", message)
        disable_buttons()
    elif(b4["text"] == b5["text"] == b6["text"] == player):
        winner = True
        message = "CONGRATULATIONS! " + player + " wins!!"

        messagebox.showinfo("Tic Tac Toe", message)
        disable_buttons()
    elif(b7["text"] == b8["text"] == b9["text"] == player):
        winner = True
        message = "CONGRATULATIONS! " + player + " wins!!"

        messagebox.showinfo("Tic Tac Toe", message)
        disable_buttons()
    elif(b1["text"] == b4["text"] == b7["text"] == player):
        winner = True
        message = "CONGRATULATIONS! " + player + " wins!!"

        messagebox.showinfo("Tic Tac Toe", message)
        disable_buttons()
    elif(b2["text"] == b5["text"] == b8["text"] == player):
        winner = True
        message = "CONGRATULATIONS! " + player + " wins!!"

        messagebox.showinfo("Tic Tac Toe", message)
        disable_buttons()
    elif(b3["text"] == b6["text"] == b9["text"] == player):
        winner = True
        message = "CONGRATULATIONS! " + player + " wins!!"

        messagebox.showinfo("Tic Tac Toe", message)
        disable_buttons()
    elif(b1["text"] == b5["text"] == b9["text"] == player):
        winner = True
        message = "CONGRATULATIONS! " + player + " wins!!"

        messagebox.showinfo("Tic Tac Toe", message)
        disable_buttons()
    elif(b3["text"] == b5["text"] == b7["text"] == player):
        winner = True
        message = "CONGRATULATIONS! " + player + " wins!!"

        messagebox.showinfo("Tic Tac Toe", message)
        disable_buttons()

    
    if((count == 9) and (winner == False)):
        messagebox.showinfo("Tic Tac Toe", "Bummer! The game is tied!! :(")
        disable_buttons()

# Button clicked function
def b_click(b):
    global clicked, count

    if ((b["text"] == " ") and (clicked == True)):
        b["text"] = "X"
        clicked = False
        count += 1

        checkifwon("X")
    elif ((b["text"] == " ") and (clicked == False)):
        b["text"] = "O"
        clicked = True
        count += 1

        checkifwon("O")
    else:
        messagebox.showerror("Tic Tac Toe", "The box is already been selected\nPlease select another one!")

# Creates or resets the game
def reset():
    global b1, b2, b3, b4, b5, b6, b7, b8, b9
    global count, clicked, buttons

    clicked = True
    count = 0

    # create buttons for the tic tac toe grid
    b1 = Button(root, text = " ", font = ("Helvetica", 20), height = 3, width = 6, bg = "White", command = lambda: b_click(b1))
    b2 = Button(root, text = " ", font = ("Helvetica", 20), height = 3, width = 6, bg = "White", command = lambda: b_click(b2))
    b3 = Button(root, text = " ", font = ("Helvetica", 20), height = 3, width = 6, bg = "White", command = lambda: b_click(b3))
    b4 = Button(root, text = " ", font = ("Helvetica", 20), height = 3, width = 6, bg = "White", command = lambda: b_click(b4))
    b5 = Button(root, text = " ", font = ("Helvetica", 20), height = 3, width = 6, bg = "White", command = lambda: b_click(b5))
    b6 = Button(root, text = " ", font = ("Helvetica", 20), height = 3, width = 6, bg = "White", command = lambda: b_click(b6))
    b7 = Button(root, text = " ", font = ("Helvetica", 20), height = 3, width = 6, bg = "White", command = lambda: b_click(b7))
    b8 = Button(root, text = " ", font = ("Helvetica", 20), height = 3, width = 6, bg = "White", command = lambda: b_click(b8))
    b9 = Button(root, text = " ", font = ("Helvetica", 20), height = 3, width = 6, bg = "White", command = lambda: b_click(b9))

    buttons = [b1, b2, b3, b4, b5, b6, b7, b8, b9]

    # variable for column counter
    c_counter = 0

    for b in buttons:
        if (buttons.index(b) < 3):
            b.grid(row = 0, column = c_counter)
        elif (buttons.index(b) < 6):
            b.grid(row = 1, column = c_counter - 3)
        elif (buttons.index(b) < 9):
            b.grid(row = 2, column = c_counter - 6)
        
        c_counter += 1

# Create a menu
my_menu = Menu(root)
root.config(menu = my_menu)

# Create Options menu
options_menu = Menu(my_menu, tearoff = False)
my_menu.add_cascade(label = "Options", menu = options_menu)
options_menu.add_command(label = "Reset Game", command = reset)

reset()
root.mainloop()