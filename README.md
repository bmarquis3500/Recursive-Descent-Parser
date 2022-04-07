# Recursive-Descent-Parser
This is a Java class that takes a text file as input. The Java class will output a GUI built to the specifications of the input.

The input txt file must be in the proper format. Starting with a Window line that includes a title dimensions and layout followed by a colon.
The file will then specify the contents of the window; including panels, buttons, labels and textfields.
Layouts for individual panels are supported.
Each layout must end with an End line followed by a semi colon.
The file must end with an End line followed by a period.

Example:

Window "Calculator" (200, 200) Layout Flow:
 Textfield 20;
 Panel Layout Grid(4, 3, 5, 5):
 Button "7";
 Button "8";
 Button "9";
 Button "4";
 Button "5";
 Button "6";
 Button "1";
 Button "2";
 Button "3";
 Label "";
 Button "0";
 End;
End.

This file will produce a "Calculator" with ten buttons.
