import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener {
   static boolean newNumber = true;
   static JTextField text;
   static char operator = ' ';
   static double opnd1 = 0;
   static double opnd2 = 0;
   static double res = 0;
	public static void main(String[] args) {
      
   
      ActionListener AL = new Calculator();
      JButton B;
      
		JFrame frm = new JFrame("Calculator");
		Container contentPane = frm.getContentPane();
		contentPane.setLayout(new GridLayout(7,1,2,2));
         JPanel p = new JPanel(new GridLayout(1,1,2,2));
            p.add(new JLabel("CSC20 calculator", JLabel.CENTER));
 			   contentPane.add(p);
         JPanel t = new JPanel(new GridLayout(1,1));
            text = new JTextField("0");
            text.setHorizontalAlignment(JTextField.RIGHT);
            t.add(text);
            contentPane.add(t);
         JPanel r3 = new JPanel(new GridLayout(1,4,2,2));
            r3.add(B = new JButton("1"));
               B.addActionListener(AL);
            r3.add(B = new JButton("2"));
               B.addActionListener(AL);
            r3.add(B = new JButton("3"));
               B.addActionListener(AL);
            r3.add(B = new JButton("+"));
               B.addActionListener(AL);
            contentPane.add(r3);
            
         JPanel r4 = new JPanel(new GridLayout(1,4,2,2));
            r4.add(B = new JButton("4"));
               B.addActionListener(AL);
            r4.add(B = new JButton("5"));
               B.addActionListener(AL);
            r4.add(B = new JButton("6"));
               B.addActionListener(AL);
            r4.add(B = new JButton("-"));
               B.addActionListener(AL);
            contentPane.add(r4);
            
         JPanel r5 = new JPanel(new GridLayout(1,4,2,2));
            r5.add(B = new JButton("7"));
               B.addActionListener(AL);
            r5.add(B = new JButton("8"));
               B.addActionListener(AL);
            r5.add(B = new JButton("9"));
               B.addActionListener(AL);
            r5.add(B = new JButton("*"));
               B.addActionListener(AL);
            contentPane.add(r5);            
            
         JPanel r6 = new JPanel(new GridLayout(1,2,2,2));
            r6.add(B = new JButton("C"));
               B.addActionListener(AL);
            JPanel sub1 = new JPanel(new GridLayout(1,2,2,2));
               sub1.add(B = new JButton("0"));
                  B.addActionListener(AL);
               sub1.add(B = new JButton("/"));
                  B.addActionListener(AL);
            r6.add(sub1);
            contentPane.add(r6);
         contentPane.add(B = new JButton("="));   
            B.addActionListener(AL);
             
            
		frm.pack();
		frm.setSize(318,400);
		//frm.setResizable(false);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
	}
   
    public void actionPerformed(ActionEvent e) {
      char c = e.getActionCommand().charAt(0);
      switch(c) {
         case '0':
         case '1':
         case '2':
         case '3':
         case '4':
         case '5':
         case '6':
         case '7':
         case '8':
         case '9':
            if (newNumber) { 
               text.setText(""+c);
               newNumber = false;
               }
               else text.setText(text.getText()+c);
            return;
         case '+':
         case '-':
         case '*':
         case '/':
             opnd1 = Double.parseDouble(text.getText());
            newNumber = true;
            operator = c;
            return;
         case '=': opnd2 = Double.parseDouble(text.getText());
            switch (operator) {
               case '/': res = opnd1 / opnd2; break;
               case '*': res = opnd1 * opnd2; break;
               case '-': res = opnd1 - opnd2; break;
               case '+': res = opnd1 + opnd2; break;
            }
            text.setText(""+res);
            newNumber = true;
            return;
         case 'C':
            newNumber = true;
            text.setText("0");   
         }
   } 
}
   







