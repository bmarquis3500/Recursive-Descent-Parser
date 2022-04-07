import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;

//Benjamin Marquis
//CMSC 330 6381
//Project 1
//This project takes input from file and converts into desired GUI
public class Project1 {
	static JFrame myFrame;
	public static String text;
	public static void main(String[] args) throws Exception {
		try {
			File myFile = new File("input.txt");
			Scanner myScanner = new Scanner(myFile);
			String line = new String();
			String input = "";
			boolean myBool = false;
			line=myScanner.nextLine();
			if(line.startsWith("Window")) {
				input = line.substring(7);
				while(!myBool){
					line = myScanner.nextLine();
					if(line.equals("End.")) {
						myBool = true;
					}
					else {
						input = input+"\n"+line;
					}
					
					//System.out.println(input);
				}
				windowMethod(input);
				
				
			}
			else {
				System.out.println("incorrect input file");
			}
			
		}
		
		catch(FileNotFoundException e){
			System.out.println("File not found");
			
		}
		
	}
	public static void windowMethod(String input){
		text = input;
		
		Scanner myScanner = new Scanner(text);
		String title = myScanner.next();
		
		text = text.substring(title.length());
		//System.out.println("-----------------");
		//System.out.println(text);
		title = title.substring(1, title.length()-1);
		String size1 = myScanner.next();
		text = text.substring(size1.length());
		size1 = size1.substring(1, size1.length()-1);
		
		String size2 = myScanner.next();
		text = text.substring(size2.length()+2);
		size2 = size2.substring(0, size2.length()-1);
		//System.out.println("Size2: "+size2);
		
		myFrame = new JFrame(title);
		myFrame.setSize(Integer.parseInt(size1),Integer.parseInt(size2));
		
		
		//System.out.println("------2-----------");
		//System.out.println(text);
		
		
		String token = myScanner.next();
		text = text.substring(token.length()+1);
		
		//System.out.println("---------------layout:-------------");
		//System.out.println(token);
		
		//token = myScanner.next();
		//text = text.substring(token.length()+1);
		
		//System.out.println(token);
		
		if(token.equalsIgnoreCase("layout")) {
			//System.out.println("Here");
			myFrame.setLayout(layoutMethod(text));
			token = myScanner.next();
			text = text.substring(token.length()+1);
		}
		else {
			System.out.println("Incorrect input file.  1");
		}
		System.out.println("--------------3---------");
		//System.out.println(text);
		
		
		
		
		
		while(myScanner.hasNext()) {
			myFrame.add(widgetMethod(text));
		
			//String line  = myScanner.nextLine();
			//line  = myScanner.nextLine();
			//text = text.substring(line.length()+1);		
			System.out.println(text);
		}
		
		myFrame.setVisible(true);
	}
	
	public static Component widgetMethod(String text) {
		Scanner myScanner = new Scanner(text);
		String widgetType = myScanner.next();
		
		System.out.println("WidgetType: " + widgetType);
		
		String token = widgetType;
		text = text.substring(token.length()+2);
		
		if(widgetType.equalsIgnoreCase("button")) {
			widgetMethod(text);
			return buttonMethod(text);
		}
		else if(widgetType.equalsIgnoreCase("label")) {
			widgetMethod(text);
			return labelMethod(text);
		}
		else if(widgetType.equalsIgnoreCase("textfield")) {
			System.out.println("adding textfield");
			//widgetMethod(text);
			return textFieldMethod(text);
		}
		else if(widgetType.equalsIgnoreCase("radio_button")) {
			widgetMethod(text);
			return radioButtonMethod(text);
		}
		else if(widgetType.equalsIgnoreCase("End;")) {
			return null;
		}
		
		
		//System.out.println(text);
		
		
		return widgetMethod(text);
		
	}
	public static JButton buttonMethod(String text) {
		Scanner myScanner = new Scanner(text);
		String buttonLabel = myScanner.next();
		
		String token = buttonLabel;
		text = text.substring(token.length()+1);
		
		JButton myButton = new JButton(buttonLabel);
		return myButton;
	}
	public static JLabel labelMethod(String text) {
		Scanner myScanner = new Scanner(text);
		String labelText = myScanner.next();
		
		String token = labelText;
		text = text.substring(token.length()+1);
		
		JLabel myLabel = new JLabel(labelText);
		return myLabel;
	}
	public static JTextField textFieldMethod(String text) {
		Scanner myScanner = new Scanner(text);
		String fieldLengthString = myScanner.next();
		
		fieldLengthString = fieldLengthString.substring(0, fieldLengthString.length()-1);
		
		System.out.println("Field length string: " +fieldLengthString);
		
		int fieldLength = Integer.parseInt(fieldLengthString);
		
		String token = fieldLengthString;
		text = text.substring(token.length()+1);
		
		//token = myScanner.nextLine();
		//text=text.substring(token.length()+1);
		
		JTextField myField = new JTextField(fieldLength);
		return myField;
		
	}
	public static JRadioButton radioButtonMethod(String text) {
		//make recursive
		
		Scanner myScanner = new Scanner(text);
		String radioButtonLabel = myScanner.next();
		
		String token = radioButtonLabel;
		text = text.substring(token.length()+1);
		
		JRadioButton myRadioButton = new JRadioButton(radioButtonLabel);
		
		if(!myScanner.next().equals("radio_button")){
			return myRadioButton;
		}
		else {
			return radioButtonMethod(text);
		}
	}
	public static JPanel panelMethod(String text) {
		Scanner myScanner = new Scanner(text);
		String panelLayout = myScanner.next();
		
		String token = panelLayout;
		text = text.substring(token.length()+1);
		
		JPanel myPanel = new JPanel(layoutMethod(text));
		return myPanel;
		
		
	}
	
	
	
	
	
		Scanner myScanner = new Scanner(text);
		//System.out.println(text);
		String layout = myScanner.next();
		
		System.out.println("layout: " + layout);
		
		String token = layout;
		text = text.substring(token.length()+1);
		
		LayoutManager myLayout;
		//System.out.println("layout: "+layout);
		if(layout.startsWith("Flow")) {
			System.out.println("Here 2");
			myLayout = new FlowLayout();
			
			//text=text.substring(layout.length());
			
			
			
			System.out.println("returning layout");
			
			
			
			
			return myLayout;
			
			
		}
		else if(layout.startsWith("Grid")) {
			String passString1 = layout.substring(4);
			passString1 = passString1.substring(1, passString1.length()-1);
			System.out.println("pass String1:"+passString1);
			int myPass1 = Integer.parseInt(passString1);
			
			
			boolean moreThan2 = false;
			
			
			String passString2 = myScanner.next();
			token = passString2;
			text = text.substring(token.length()+1);
			
			if(passString2.endsWith(",")) {
				moreThan2=true;
			}
			passString2 = passString2.substring(0, passString2.length()-1);
			//System.out.println("pass String2:"+passString2);
			int myPass2 = Integer.parseInt(passString1);
			
			
			myLayout = new GridLayout(myPass1,myPass2);
			
			
			
			if(moreThan2) {
				
				String myHgapString = myScanner.next();
				token = myHgapString;
				text = text.substring(token.length()+1);
				myHgapString = myHgapString.substring(0, myHgapString.length()-1);
				int myHgap = Integer.parseInt(myHgapString);
				((GridLayout) myLayout).setHgap(myHgap);
				//System.out.println("myHgap " + myHgap);
				
				
				String myVgapString = myScanner.next();
				token = myVgapString;
				text = text.substring(token.length()+1);
				myVgapString = myVgapString.substring(0, myVgapString.length()-2);
				int myVgap = Integer.parseInt(myVgapString);
				((GridLayout) myLayout).setVgap(myVgap);
				//System.out.println("myVgap " + myVgap);
				
				
			}
			
			return myLayout;
			
		}
		else {
			System.out.println("2Incorrect input file.");
		}
		//return myLayout;
		return null;
		
		
	}

}
