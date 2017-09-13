import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

public class frame extends JFrame {
	JPanel panel = new JPanel();
	JLabel textLabel = new JLabel("Podaj wartoœæ: ");
	JTextField textField = new JTextField(15);
	ButtonGroup group = new ButtonGroup();
	JRadioButton brutto = new JRadioButton("Brutto", true);
	JRadioButton netto = new JRadioButton("Netto", false);
	JLabel text1 = new JLabel("Wynik to ");
	JLabel text2 = new JLabel("");
	JButton button = new JButton("Oblicz");

	frame() {
		setTitle("Zamiana brutto na netto i na odwrót");
		setResizable(false);
		setSize(300, 150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		group.add(brutto);
		group.add(netto);
		main();
	}

	private void main() {
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		panel.add(textLabel, c);
		c.gridx = 1;
		panel.add(textField, c);
		c.gridy = 1;
		c.gridx = 0;
		panel.add(brutto, c);
		c.gridx = 1;
		panel.add(netto, c);
		c.gridy = 2;
		c.gridx = 0;
		panel.add(text1, c);
		c.gridx = 1;
		panel.add(text2, c);
		c.gridy = 3;
		c.gridx = 0;
		c.gridwidth = 2;
		panel.add(button, c);
		button.addActionListener(listener);
		add(panel);
	}

	ActionListener listener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (!isNumber(textField.getText())) {
				text2.setText("B³ad liczby");
				return;
			}
			float number = Float.parseFloat(textField.getText());
			float c;
			if (brutto.isSelected()) {
				c = bruttoNetto(number);
			} else {
				c = nettoBrutto(number);
			}
			text2.setText(c + "");
		}
	};

	private boolean isNumber(String text) {
		float number = 0;
		try {
			number = Float.parseFloat(text);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private float bruttoNetto(float number) {
		float vat = (float) 1.23;
		float c = number / vat;
		System.out.println(c);
		return c;

	}

	private float nettoBrutto(float number) {
		float vat = (float) 0.23;
		float c = number + (number * vat);
		System.out.println(c);
		return c;
	}

}
