package CustomUI;

import javax.swing.*;

public class CustomButton extends JButton{
	
	public CustomButton(ImageIcon icon)
	{
        this.setIcon(icon);
        //this.setBorder(null);
        this.setBorderPainted(false);
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        this.setContentAreaFilled(false);
	}
	
	public void setImageBtn(ImageIcon icon)
	{
		this.setIcon(icon);
	}

}
