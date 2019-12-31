import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class TickTacToe extends JFrame{
	private  JPanel gamePanel;
	private  JPanel resetPanel;
	private static JButton gameButton[];
	private  JButton resetButton;

	private int moveCounter = 9;
	
	
	public TickTacToe() {
		setTitle("TicTacToe");
		setSize(450, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout( new BorderLayout());
		buildGamePanel();
		buildResetPanel();
		add(gamePanel, BorderLayout.NORTH);
		add(resetPanel, BorderLayout.SOUTH);
		setVisible(true);		
	}

	private void buildGamePanel() {
		gamePanel = new JPanel();
		gamePanel.setLayout (new GridLayout (3, 3));

		gameButton= new JButton[9];
		for(int x = 0; x<9; x++) {
			gameButton[x] = new JButton();  
			gameButton[x].setPreferredSize(new Dimension(150, 150));
			gameButton[x].setText("");
			Font f = new Font("Dialog", 1, 80);
			gameButton[x].setFont(f);
			gameButton[x].addActionListener(new moveActionListener());
			gameButton[x].setBackground (Color.white);
			gamePanel.add(gameButton[x]); 
			}
		}
		
	private void buildResetPanel() {
		resetPanel = new JPanel();
		resetButton = new JButton("Reset");
		resetPanel.setLayout(new GridLayout(1, 1));
		resetButton.setPreferredSize(new Dimension(450, 59));
		resetButton.setBackground (Color.white);
		resetButton.addActionListener(new moveActionListener());
		resetPanel.add(resetButton);
	}
	
    private static Boolean checkWinner(){
    	if(equal(gameButton[0], gameButton[4], gameButton[8])) return true;
        else if(equal(gameButton[2], gameButton[4], gameButton[6])) return true;
        else if(equal(gameButton[2], gameButton[5], gameButton[8])) return true;
        else if(equal(gameButton[1], gameButton[4], gameButton[7])) return true;
        else if(equal(gameButton[0], gameButton[3], gameButton[6])) return true;
        else if(equal(gameButton[0], gameButton[1], gameButton[2])) return true;
        else if(equal(gameButton[3], gameButton[4], gameButton[5])) return true;
        else if(equal(gameButton[6], gameButton[7], gameButton[8])) return true;
        else return false;
    }
    
    private static Boolean equal(JButton b1, JButton b2, JButton b3){
    	if((b1.getText()==b2.getText())&&(b2.getText()==b3.getText())&&(b1.getText()!="")) {
    		return true;
    	}
    	return false;
    }
	
	private class moveActionListener implements ActionListener{
		 public void actionPerformed(ActionEvent a) {
			 JButton click = (JButton)a.getSource();
			 
			 for(int x=0; x<9;x++) {
				 if(click==gameButton[x]) {
					 if(moveCounter%2==0) {
						 gameButton[x].setText("O");
						 gameButton[x].setEnabled(false);
						 moveCounter--;
					 }					 
					 else {
						gameButton[x].setText("X");
						gameButton[x].setEnabled(false);
						 moveCounter--;
					 }
				 }
			}
			 			 
			if(click==resetButton) {
				for(int x=0; x<9;x++) {
					gameButton[x].setText("");
					gameButton[x].setEnabled(true);
				}
				moveCounter=9;
			}
			
			if (checkWinner()==true) {
					JOptionPane.showMessageDialog(null, click.getText()+ " Win!");
					for(int x=0; x<9;x++) {
					gameButton[x].setEnabled(false);
					 }
			 }		

			if(moveCounter ==0 && checkWinner() ==false) {
				JOptionPane.showMessageDialog(null, "The game was tie!");
			}

			
		 }
	}
	
    public static void main(String args[])  
    {  
    	new TickTacToe();
    }
    	
}
