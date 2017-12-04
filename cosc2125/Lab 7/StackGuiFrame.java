//Mark Hawley
//StackGuiTest

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class StackGuiFrame extends JFrame
{
	
	 /** these are all of the widgets (parts) that go on the Frame
	   *  Buttons for execution control, TextFields for input and output
	   */
	  JButton sizeButton = new JButton("Size");
	  JButton checkEmptyButton = new JButton ("Check Empty");
	  JButton viewButton = new JButton("View");
	  JButton pushButton = new JButton("Push");
	  JButton popButton = new JButton("Pop");
	  JButton peekButton = new JButton("Peek");
	  JButton clearButton = new JButton("Clear");
	  JTextField textField = new JTextField(30);
	  JLabel inputLabel = new JLabel("Text Field: ");
	  JPanel buttonPanel = new JPanel();  // used to keep the buttons together
	  
		StackL<String> linearStack_ = new StackL();
		StackA<String> arrayStack_ = new StackA();

	  /* Default Frame constructor, initializes the frame's components */
	  public StackGuiFrame()
	    {
	      this.setTitle("Stack GUI Test");
	      this.getContentPane().setLayout(new FlowLayout());
	      buttonPanel.add(sizeButton);
	      buttonPanel.add(checkEmptyButton);
	      buttonPanel.add(viewButton);
	      buttonPanel.add(pushButton);
	      buttonPanel.add(popButton);
	      buttonPanel.add(peekButton);
	      buttonPanel.add(clearButton);
	   
	      this.getContentPane().add(inputLabel);
	      this.getContentPane().add(textField);
	      this.getContentPane().add(buttonPanel);  
	      
	      
	      textField.setEditable(true);
	      
	      /* ------------actionListeners--------------- */
	      
	      sizeButton.addActionListener( new ActionListener() {
	          public void actionPerformed (ActionEvent e) {
	            sizeMessage();//method call
	          }});
	      
	      checkEmptyButton.addActionListener( new ActionListener() {
	          public void actionPerformed (ActionEvent e) {
	            checkEmptyMessage();//method call
	          }});
	      
	      viewButton.addActionListener( new ActionListener() {
	          public void actionPerformed (ActionEvent e) {
	            viewButtonMessage();//method call
	          }});
	      
	      pushButton.addActionListener( new ActionListener() {
	          public void actionPerformed (ActionEvent e) {
	            pushMessage();//method call
	          }});
	      
	      popButton.addActionListener( new ActionListener() {
	          public void actionPerformed (ActionEvent e) {
	            popMessage();//method call
	          }});
	      
	      peekButton.addActionListener( new ActionListener() {
	          public void actionPerformed (ActionEvent e) {
	            peekMessage();//method call
	          }});

	      clearButton.addActionListener( new ActionListener() {
	          public void actionPerformed (ActionEvent e) {
	            clearAll();//method call
	          }});
	    }// end of constructor
	  
	  void sizeMessage()
	  {
		  int lSize = linearStack_.size();
		  int aSize = arrayStack_.size();
		  String output = "Linear Stack Size: " + lSize + "\n Array Stack Size: " + aSize;
		  textField.setText(output);
	  }
	  
	  void checkEmptyMessage()
	  {
		  String output = "";
		  if(linearStack_.isEmpty())
		  {
			  output += "LinearList Stack is Empty \n";
		  }		  
		  else
		  {
			  output += "LinearList Stack is not empty \n";
		  }
		  if(arrayStack_.isEmpty())
		  {
			  output += "ArrayList Stack is Empty";
		  }
		  else
		  {
			  output += "ArrayList Stack is not empty";
		  }
		  textField.setText(output);
	  }

	  void viewButtonMessage()
	  {
		  textField.setText("ArrayList Stack: \n" + arrayStack_ + "\n ***** \n" + "Linear Stack: " + linearStack_);
	  }
	  
	  void pushMessage()
	  {
		String value = JOptionPane.showInputDialog("Enter value to push");
		this.arrayStack_.push(value);
		this.linearStack_.push(value);
		String output = "Just pushed " + value + "\n" + "ArrayList Stack: \n" +
						arrayStack_ + "\n ***** \n" + "Linear Stack: " + linearStack_;
		textField.setText("ArrayList pushed: " + value + "\n" + "LinearList pushed: " + value);
	  }
	  
	  void popMessage()
	  {
		  if(this.arrayStack_.isEmpty() || this.linearStack_.isEmpty())
		  {
			textField.setText("one of the stacks is empty, unable to pop");  
		  }
		  else
		  {
		  String aValue = arrayStack_.pop();
		  String lValue = linearStack_.pop();
		  textField.setText("ArrayList pop: " + aValue + "\n" + "LinearList pop: " + lValue);
		  }
	  }
	  
	  void peekMessage()
	  {
		  if(this.arrayStack_.isEmpty() || this.linearStack_.isEmpty())
		  {
			textField.setText("one of the stacks is empty, unable to pop");  
		  }
		  else
		  {
			  String aValue = arrayStack_.peek();
			  String lValue = linearStack_.peek();
			  textField.setText("ArrayList peek: " + aValue + "\n" + "LinearList peek: " + lValue);
		  }
	  }
	  
	  // clears the text fields
	  void clearAll() 
	    {
	      arrayStack_.clear();
	      linearStack_.clear();
	      textField.setText("ArrayList and LinearList cleared");
	    }

	/** main method, really just creates the frame (window) and
	 *  waits (listens) for user actions (inputs).
	 * @param args - command line arguments - none expected
	 */ 
	  public static void main(String[] args) {
	    //Schedule a job for the event-dispatching thread:
	    //creating and showing this application's GUI.
	    javax.swing.SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	          createAndShowGUI();
	        }
	      });
	  }
	  /**
	   * Create the GUI and show it.  For thread safety,
	   * this method should be invoked from the
	   * event-dispatching thread.
	   */
	  private static void createAndShowGUI() {
	    //Make sure we have nice window decorations so use default for system
	    JFrame.setDefaultLookAndFeelDecorated(true);    
	     
	    //Create and set up the window.
	    StackGuiFrame frame = new StackGuiFrame();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(700, 200);
	    //Display the window.
	    frame.setVisible(true);

	  } // end createAndShowGui

}
