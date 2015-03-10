package calculator;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import calculator.CalculatorFrame.NumField;

public class NumKey extends JButton implements ActionListener {
	private CalculatorFrame cf;
	private String label;
	private StackComputing sc;
	
	public NumKey(StackComputing sc, String label, CalculatorFrame cf) {
		super(label);
		this.sc = sc;
		this.cf = cf;
		this.label = label;
		setPreferredSize(new Dimension(100, 30));
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent event) {
		NumField nf1 = cf.getFields()[0];
		NumField nf2 = cf.getFields()[1];
		NumField nf3 = cf.getFields()[2];
		NumField nf4 = cf.getFields()[3];
		
		if (!nf1.getText().equals("0") && sc.getIsPressed() == false) {
			String num = nf1.getText() + label;
			nf1.setText(num);
			sc.getStack()[0] = Integer.parseInt(num);
		}
		
		if (sc.getIsOperated()) {
			sc.setIsOperated(false);
			sc.setIsPressed(false);
			
			nf1.setText(label);
			nf2.setText(Integer.toString(sc.getStack()[0]));
			nf3.setText(Integer.toString(sc.getStack()[1]));
			nf4.setText(Integer.toString(sc.getStack()[2]));
			
			sc.getStack()[3] = sc.getStack()[2];
			sc.getStack()[2] = sc.getStack()[1];
			sc.getStack()[1] = sc.getStack()[0];
			sc.getStack()[0] = Integer.parseInt(label);
		}
		
		if (sc.getIsPressed()) {
			sc.setIsPressed(false);
			nf1.setText(label);
			sc.getStack()[0] = Integer.parseInt(label);
		}
		
		if (nf1.getText().equals("0")) {
			nf1.setText(label);
			sc.getStack()[0] = Integer.parseInt(label);
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("This Stack:\n");
		for (int n : sc.getStack())
			sb.append(n + "\n");
		
		System.out.println(sb);
	}
}
