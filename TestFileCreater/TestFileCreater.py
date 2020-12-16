# The MIT License (MIT)
# Copyright (c) 2020 Joost Wagensveld-van Veen
#
# Permission is hereby granted, free of charge, to any person obtaining a copy
# of this software and associated documentation files (the "Software"), to deal
# in the Software without restriction, including without limitation the rights
# to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
# copies of the Software, and to permit persons to whom the Software is
# furnished to do so, subject to the following conditions:
#
# The above copyright notice and this permission notice shall be included in
# all copies or substantial portions of the Software.
#
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
# EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
# MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
# IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
# DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
# OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE
# OR OTHER DEALINGS IN THE SOFTWARE.

import os
import random

from tkinter import *
from tkinter import messagebox
from tkinter import filedialog


FILENAME = "testfile.xml"
FILEPATH = os.path.abspath(os.getcwd())
SAVEPATH = ""
NUM_OF_LINES = 100
MAX_NUM_OF_STEPS = 25
STEP_RANGE = 20

# root is the root window
root = Tk()
root.title('Create a test XML file')
root.iconbitmap('agent_icon.ico')
root.filename = "nothing yet"
root.geometry("400x330+200+150")
#.geometry("window width x window height + position right + position down")

# set the spinbox variables to be tk int variables,
# needed to use the .get function.
linesbox = IntVar()
stepsbox = IntVar()
rangebox = IntVar()


def insertFilePopUp():
    root.filename = filedialog.askopenfilename(
        title="Select a file", filetypes=(("XML files", "*.xml"),\
        ("all files", "*.*")))


# saveLocation the value that is stored in root.filename
def saveLocation():
    global SAVEPATH
    print("SAVEPATH= " + SAVEPATH)
    SAVEPATH = filedialog.askdirectory() + "/"
    print("now SAVEPATH= " + SAVEPATH)


# remove existing file
def removeFile():
    if os.path.exists(FILENAME):
        os.remove(FILENAME)  # this deletes the file

    else:
        print("The file does not exist")  # add this to prevent errors


def createFile():
    global NUM_OF_LINES
    global MAX_NUM_OF_STEPS
    global STEP_RANGE
    global FILENAME
    global SAVEPATH

    NUM_OF_LINES = int(linesbox.get())
    MAX_NUM_OF_STEPS = int(stepsbox.get())
    STEP_RANGE = int(rangebox.get())

    FILENAME = os.path.splitext(filenameField.get())[0]
    FILENAME += ".xml"

    if os.path.exists(FILENAME):
        os.remove(FILENAME)  # this deletes the file
    else:
        print("The file does not exist (yet), so nothing deleted")
        # added this to prevent errors

    print("SAVEPATH = " + SAVEPATH + " and FILENAME = " + FILENAME)

    f = open(SAVEPATH + FILENAME, "a+")
    f.write("<?xml version='1.0' encoding='utf-8'?>\n"
            "<root>\n")
    TEMPLATE = '<P>P{}<NPS>{}</NPS><STEPS>{}</STEPS></P>'
    for i in range(0, NUM_OF_LINES):
        steps = random.randint(1, MAX_NUM_OF_STEPS)
        step_values = [str(random.randint(0, STEP_RANGE))
        for x in range(0, steps)]
        line = TEMPLATE.format(i, steps, ','.join(step_values))
        f.write("\t" + line + "\n")
    f.write("</root>")
    f.close()
    messagebox.showinfo("File Created", "\"" + FILENAME +
    "\" saved in \"" + SAVEPATH + "\"")


def close():
    root.destroy()


def print_item_values():
    a = linesbox.get()
    print(a)


# create a label widget
infoLabel = Label(root, justify="left", text="This program helps you to create\
test XML files with random values", )
# create the spinboxes where to insert the values
# first box is the NUM_OF_LINES box, second box is MAX_NUM_OF_STEPS
# and the third STEP_RANGE
var_num = IntVar(value=100)  # initial value linesbox
var_step = IntVar(value=25)  # initial value linesbox
var_ran = IntVar(value=10)  # initial value linesbox
NUMlabel = Label(root, text='How many products need to be created (<P> lines)')
STEPSlabel = Label(root, text='How many productionsteps (<NPS>)')
RANGElabel = Label(root, text='Maximum number of productionsteps (number of Esuiplets)')
linesbox = Spinbox(root, from_=1, to=1500, textvariable=var_num, width=10)
stepsbox = Spinbox(root, from_=1, to=50, textvariable=var_step, width=10)
rangebox = Spinbox(root, from_=1, to=25, textvariable=var_ran, width=10)

# create a button
blankline = Label(root, text="").grid(row=8, columnspan=2, sticky=N + S + E + W)
infoLabel2 = Label(root, wraplength=400, justify="left", text=
"The file will be saved in " + os.path.abspath(os.getcwd()) + " by default."
" If you want to place the file somewhere else you can change \
the location with the bottum below", pady=10)

locationButton = Button(root, text="Select where to create the file.", pady=5,
command=saveLocation)
createButton = Button(root, text="Create testfile!!", pady=5, command=createFile)
closeButton = Button(root, text="close window", pady=5, command=close)

# create a insertfield... probably not necessary
filenameField = Entry(root, width=50, borderwidth=2)
filenameField.insert(0, "Insert filename")

# place everything
infoLabel.grid(row=1, column=0, columnspan=2, sticky=N + S + E + W)
infoLabel2.grid(row=6, columnspan=2, sticky=N + S + E + W)
filenameField.grid(row=8, column=0)

NUMlabel.grid(row=2, column=0, sticky=W)
linesbox.grid(row=2, column=1, sticky=W)
STEPSlabel.grid(row=3, column=0, sticky=W)
stepsbox.grid(row=3, column=1, sticky=W)
RANGElabel.grid(row=4, column=0, sticky=W)
rangebox.grid(row=4, column=1, sticky=W)

# buttons
closeButton.grid(row=11, columnspan=2, sticky=N + S + E + W)
createButton.grid(row=10, columnspan=2, sticky=N + S + E + W)
locationButton.grid(row=9, columnspan=2, sticky=N + S + E + W)

# run the main window loop
root.mainloop()
