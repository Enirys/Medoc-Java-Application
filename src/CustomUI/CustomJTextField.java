package CustomUI;

import javax.swing.*;

import java.awt.*;

public class CustomJTextField extends JTextField{
	
	public CustomJTextField(Color color, Font font, int size)
	{
		super(size);
		this.setBackground(color);
		this.setFont(font);
		this.setBorder(null);
	}
}
