package CustomUI;

import javax.swing.*;
import java.awt.*;

public class CustomJLabel extends JLabel{

	public CustomJLabel(String title, Color color, Font font)
	{
		this.setText(title);
		this.setFont(font);
		this.setForeground(color);
	}
	
}
