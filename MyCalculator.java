import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class Calculator extends JFrame implements ActionListener { 
	private JPanel displayPanel;
	private JPanel buttonPanel;
   
	private JButton b10,b11,b12,b13,b14,b15,pb; 
	private JButton btns[]=new JButton[10];

	private int i,r,n1,n2;
	private JTextField txt1;
	private char op; 

 Calculator(){
	setSize(360, 400);
	setTitle("Calc");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	displayPanel = new JPanel();
		
	txt1 = new JTextField();
	txt1.setPreferredSize(new Dimension(320, 50));
	txt1.setFont(new Font("Serif", Font.BOLD, 20));
	txt1.setCursor(new Cursor(Cursor.TEXT_CURSOR));
	displayPanel.add(txt1);
		
	buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5));
	for(int i=0;i<=9;i++) {
		btns[i]=new JButton(i+"");
        buttonPanel.add(btns[i]);
        btns[i].addActionListener(this);
	}
	b10=new JButton("+");
    buttonPanel.add(b10);
    b10.addActionListener(this);
 
    b11=new JButton("-");
    buttonPanel.add(b11);
    b11.addActionListener(this);
 
	b12=new JButton("*");
    buttonPanel.add(b12);
    b12.addActionListener(this);
 
    b13=new JButton("/");
    buttonPanel.add(b13);
    b13.addActionListener(this);
 
    b14=new JButton("=");
	buttonPanel.add(b14);
    b14.addActionListener(this);
 
    b15=new JButton("C");
    buttonPanel.add(b15);
    b15.addActionListener(this);
    
    
    add(buttonPanel,BorderLayout.CENTER);
    add(txt1,BorderLayout.PAGE_START);
    
  }
public void actionPerformed(ActionEvent ae){
	pb=(JButton)ae.getSource();
	if(pb==b15){
		r=n1=n2=0;
		txt1.setText("");
	} else if(pb==b14) {
 		n2=Integer.parseInt(txt1.getText());
  		eval();
  		txt1.setText(""+r);
	} else {
 		boolean opf=false;
 		if(pb==b10){ 
			op='+';
			opf=true;
		}
		if(pb==b11){
			op='-';
			opf=true;
		}
		if(pb==b12){ 
			op='*';
			opf=true;
		}
		if(pb==b13){ 
			op='/';
			opf=true;
		}
		if(opf==false){
			for(i=0;i<10;i++){
				if(pb==btns[i]){
					String t=txt1.getText();
					t+=i;
            		txt1.setText(t);
				}
			}
		}else{
			n1=Integer.parseInt(txt1.getText());
     		txt1.setText("");
		}
	}
}

int eval(){
	switch(op) {
		case '+':    r=n1+n2;   break;
		case '-':    r=n1-n2;   break;
		case '*':    r=n1*n2;   break;
		case '/':    r=n1/n2;   break;
	}
	return 0;
}
}

class MyCalculator {
	public static void main(String args[]){
		Calculator c1 = new Calculator();
		c1.setVisible(true);
	}
}