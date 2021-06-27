package CustomUI;

import javax.swing.*;
import java.awt.*;

public class CustomAuthButton extends JButton{
	
	public CustomAuthButton(String title, Font font, Color color)
	{
		this.setText(title);
		this.setFont(font);
		this.setForeground(color);
        this.setBorder(null);
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
	}

}
