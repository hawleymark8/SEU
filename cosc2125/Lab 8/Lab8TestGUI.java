//Mark Hawley
//Lab8TestGUI

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lab8TestGUI extends JFrame
{
	/** these are all of the widgets (parts) that go on the Frame
	   *  Buttons for execution control, TextFields for input and output
	   */
	  JButton addButton = new JButton("Add");
	  JButton clearButton = new JButton("Clear Input");
	  JButton add1Button = new JButton("Enter 1st Value");
	  JButton add2Button = new JButton("Enter 2nd Value");
	  JTextField add1Field = new JTextField(30);
	  JTextField add2Field = new JTextField(30);
	  JTextField answerField = new JTextField(30);
	  JLabel add1Label = new JLabel("First Value: ");
	  JLabel add2Label = new JLabel("Second Value: ");
	  JLabel answerLabel = new JLabel("Answer: ");
	  JPanel buttonPanel = new JPanel();  // used to keep the buttons together
	  JPanel add1Panel = new JPanel();
	  JPanel add2Panel = new JPanel();
	  JPanel answerPanel = new JPanel();
	  
		StackL<String> linearStack_ = new StackL();
		StackA<String> arrayStack_ = new StackA();

	  /* Default Frame constructor, initializes the frame's components */
	  public Lab8TestGUI()
	    {
	      this.setTitle("Lab 8 GUI Test");
	      this.getContentPane().setLayout(new FlowLayout());
	      buttonPanel.add(addButton);
	      buttonPanel.add(clearButton);
	      add1Panel.add(add1Label);
	      add1Panel.add(add1Field);
	      add1Panel.add(add1Button);
	      add2Panel.add(add2Label);
	      add2Panel.add(add2Field);
	      add2Panel.add(add2Button);
	      answerPanel.add(answerLabel);
	      answerPanel.add(answerField);
	   
	      this.getContentPane().add(add1Panel);
	      this.getContentPane().add(add2Panel);
	      this.getContentPane().add(answerPanel);
	      this.getContentPane().add(buttonPanel);  
	      
	      add1Field.setEditable(false);
	      add2Field.setEditable(false);
	      answerField.setEditable(false);
	      
	      /* ------------actionListeners--------------- */
	      
	      addButton.addActionListener( new ActionListener() {
	          public void actionPerformed (ActionEvent e) {
	            executeAdd();//method call
	          }});

	      clearButton.addActionListener( new ActionListener() {
	          public void actionPerformed (ActionEvent e) {
	            executeClear();//method call
	          }});
	    }// end of constructor
	  
	  /*------------------methods-------------------------*/
	    
	  void executeAdd() //Fix from Here on \/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/
	  {
		String value = JOptionPane.showInputDialog("Enter value to add");
		this.arrayStack_.push(value);
		this.linearStack_.push(value);
		String output = "Just pushed " + value + "\n" + "ArrayList Stack: \n" +
						arrayStack_ + "\n ***** \n" + "Linear Stack: " + linearStack_;
		textField.setText("ArrayList pushed: " + value + "\n" + "LinearList pushed: " + value);
	  }
	  
	  // clears the text fields
	  void executeClear() 
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
