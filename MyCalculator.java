import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class MyCalculator extends JFrame  {
	
    private JTextField number1, number2, result;
    private JButton add, sub, cheng, chu, ok,equal,operator;
	
	public static void main(String[] args) {
		 MyCalculator cal = new MyCalculator();
	     cal.setVisible(true);
	}
	
	 public MyCalculator() {

		 
		 this.setLayout(new GridLayout(2, 5));
		 //构建空的窗口
		  this.setTitle("Easy Calculator");
		  this.setSize(600, 300);
		  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  
		  //构建按钮
		  number1 = new JTextField("5");
		  number2 = new JTextField("5");
		  result = new JTextField();
		  add = new JButton("+");
	      sub = new JButton("-");
	      cheng = new JButton("*");
	      chu = new JButton("/");
	      ok = new JButton("OK");
	      equal = new JButton("=");
	      equal.setEnabled(false);
	      operator = new JButton("");
	      operator.setEnabled(false);
	      //添加到窗口中
	      this.add(number1);
	      this.add(operator);
	      this.add(number2);
	      this.add(equal);
	      this.add(result);
	      this.add(add);
	      this.add(sub);
	      this.add(cheng);
	      this.add(chu);
	      this.add(ok);
	      
	      //给按钮增加事件监听
	      add.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	            set('+');
	          }
	        });
	      sub.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	            set('-');
	          }
	        });
	      cheng.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	            set('*');
	          }
	        });
	      chu.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	            set('/');
	          }
	        });
	      ok.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	            calcular();
	          }
	        });
		 
	 }
	 void calcular() {
		 String flag = operator.getText();
		 double ans = 23;
		 double n1 = Double.valueOf(number1.getText());
		 double n2 = Double.valueOf(number2.getText());
		 if(flag.equals("+")) {
			ans = n1+n2;
		 }
		 else if(flag.equals("-")) {//不可以直接用等号！
			 ans = n1-n2;
		 }
		 else if(flag.equals("*")) {
			 ans = n1*n2;
		 }
		 else if(flag.equals("/")) {
			 ans = n1/n2;
		 }
		 String res;
		 res = Double.toString(ans);
		 result.setText(res);
	 }
	 void set(char op) {
		 operator.setText(String.valueOf(op));
	 }
	 
}
