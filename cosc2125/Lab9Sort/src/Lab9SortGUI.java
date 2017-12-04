//Mark Hawley
//Lab9SortGUI.java

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class Lab9SortGUI extends JFrame {

	/**
	 * these are all of the widgets (parts) that go on the Frame Buttons for
	 * execution control, TextFields for input and output
	 */
	JButton sortButton = new JButton("Sort");
	JButton stopButton = new JButton("Stop");
	JButton resetButton = new JButton("Reset");
	String[] sortStrings = { "Quick Sort", "Insertion Sort", "Merge Sort" };
	JComboBox sortList = new JComboBox(sortStrings);

	final int MYWIDTH = 500;
	final int MYHEIGHT = 600;
	final int DELAY = 500;

	JPanel buttonPanel = new JPanel();
	JPanel optionPanel = new JPanel();
	JPanel panel = new MyPanel();

	int list_[] = new int[500];
	Random generator = new Random();
	{ // <---needed bracket for compiler error?
		for (int i = 0; i < 500; i++) {
			int randomInt = generator.nextInt(501);
			list_[i] = randomInt;
		}
	}// <----needed extra bracket for compiler error?

	public Lab9SortGUI() {

		this.setTitle("Lab 9 Sort GUI");
		this.getContentPane().setLayout(new FlowLayout());
		buttonPanel.add(sortButton);
		buttonPanel.add(stopButton);
		buttonPanel.add(resetButton);
		optionPanel.add(sortList);
		this.getContentPane().add(buttonPanel);
		this.getContentPane().add(optionPanel);
		this.getContentPane().add(panel);
		sortList.setSelectedIndex(2);

		/* ------------actionListeners--------------- */

		sortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				executeSort();// method call
			}
		});

		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				executeReset();// method call
			}
		});

		/*
		 * stopButton.addActionListener( new ActionListener() { public void
		 * actionPerformed (ActionEvent e) { executeStop();//method call }});
		 */

	}// end of constructor

	class MyPanel extends JPanel {
		MyPanel() {
			this.setPreferredSize(new Dimension(MYWIDTH, MYHEIGHT));
		}

		public void paintComponent(Graphics g) {
			super.paintComponents(g);
			drawSort(g);
		}

		void drawSort(Graphics g) {
			try {
				Thread.sleep(DELAY);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < 500; i++) {
				int x = i;
				int yBase = MYHEIGHT;
				int yTop = MYHEIGHT - list_[i];
				g.drawLine(x, yBase, x, yTop);
			}
		}
	}// end of Mypanel

	/*------------------methods-------------------------*/

	void executeSort() {
		insertionSort();
//		quickSort(list_, 0, 499);

	}

	void executeReset() {
		for (int i = 0; i < 500; i++) {
			int randomInt = generator.nextInt(501);
			list_[i] = randomInt;
		}
		repaint();
	}

	void quickSort(int arr[], int left, int right) {
		repaint();
		int index = partition(arr, left, right);
		if (left < index - 1) {
			quickSort(arr, left, index - 1);
			repaint();
		}
		repaint();
		if (index < right) {
			quickSort(arr, index, right);
			repaint();
		}
		repaint();
	}

	void mergeSort() {

	}

	void insertionSort() {
		for(int i = 1; i < 500; i ++)
		{
			int k = i;
			while (k > 0)
			{
				if(list_[k] < list_[k-1])
				{
					int temp = list_[k];
					list_[k] = list_[k-1];
					list_[k-1] = temp;
					k--;
					repaint();
				}
				else
				{
					k = 0;
				}
				repaint();
			}//end of while
		}//end of for

	}

	int partition(int arr[], int left, int right) {
		repaint();
		int i = left, j = right;
		int tmp;
		int pivot = arr[(left + right) / 2];

		while (i <= j) {
			while (arr[i] < pivot)
				i++;
			while (arr[j] > pivot)
				j--;
			if (i <= j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		;

		return i;
	}

	/**
	 * main method, really just creates the frame (window) and waits (listens)
	 * for user actions (inputs).
	 * 
	 * @param args
	 *            - command line arguments - none expected
	 */
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		// Make sure we have nice window decorations so use default for system
		JFrame.setDefaultLookAndFeelDecorated(true);

		// Create and set up the window.
		Lab9SortGUI frame = new Lab9SortGUI();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 700);
		// Display the window.
		frame.setVisible(true);

	} // end createAndShowGui

}
