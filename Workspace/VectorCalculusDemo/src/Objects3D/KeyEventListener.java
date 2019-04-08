package Objects3D;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventListener implements KeyListener
{
	boolean wPressed = false;
	boolean aPressed = false;
	boolean sPressed = false;
	boolean dPressed = false;
	
	boolean gPressed = false;
	boolean hPressed = false;
	boolean rPressed = false;
	boolean lPressed = false;
	
	boolean upPressed = false;
	boolean rightPressed = false;
	boolean leftPressed = false;
	boolean downPressed = false;
	
	boolean spacePressed = false;
	boolean shiftPressed = false;
	
	boolean exit;
	@Override
	public void keyPressed(KeyEvent arg0) 
	{
		if (arg0.getKeyCode() == 87)// The w key
		{
			wPressed = true;
		}
		if (arg0.getKeyCode() == 65)// The a key
		{
			aPressed = true;
		}
		if (arg0.getKeyCode() == 83)// The s key
		{
			sPressed = true;
		}
		if (arg0.getKeyCode() == 68)// The d key
		{
			dPressed = true;
		}
		if (arg0.getKeyCode() == 38)// The up key
		{
			upPressed = true;
		}
		if (arg0.getKeyCode() == 39)// The right key
		{
			rightPressed = true;
		}
		if (arg0.getKeyCode() == 40)// The down key
		{
			downPressed = true;
		}
		if (arg0.getKeyCode() == 37)// The left key
		{
			leftPressed = true;
		}
		if (arg0.isShiftDown())
		{
			shiftPressed = true;
		}
		if (arg0.getKeyCode() == 32)
		{
			spacePressed = true;
		}
		if (arg0.getKeyCode() == 71)
		{
			gPressed = true;
		}
		if (arg0.getKeyCode() == 72)
		{
			hPressed = true;
		}
		if (arg0.getKeyCode() == 82)
		{
			rPressed = true;
		}
		if (arg0.getKeyCode() == 76)
		{
			lPressed = true;
		}
		if (arg0.getKeyCode() == arg0.VK_ESCAPE)
		{
			exit = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) 
	{
		if (arg0.getKeyCode() == 87)// The w key
		{
			wPressed = false;
		}
		if (arg0.getKeyCode() == 65)// The a key
		{
			aPressed = false;
		}
		if (arg0.getKeyCode() == 83)// The s key
		{
			sPressed = false;
		}
		if (arg0.getKeyCode() == 68)// The d key
		{
			dPressed = false;
		}
		if (arg0.getKeyCode() == 38)// The up key
		{
			upPressed = false;
		}
		if (arg0.getKeyCode() == 39)// The right key
		{
			rightPressed = false;
		}
		if (arg0.getKeyCode() == 40)// The down key
		{
			downPressed = false;
		}
		if (arg0.getKeyCode() == 37)// The left key
		{
			leftPressed = false;
		}
		if (arg0.getKeyCode() == 16)
		{
			shiftPressed = false;
		}
		if (arg0.getKeyCode() == 32)
		{
			spacePressed = false;
		}
		if (arg0.getKeyCode() == 71)
		{
			gPressed = false;
		}
		if (arg0.getKeyCode() == 72)
		{
			hPressed = false;
		}
		if (arg0.getKeyCode() == 82)
		{
			rPressed = false;
		}
		if (arg0.getKeyCode() == 76)
		{
			lPressed = false;
		}
		if (arg0.getKeyCode() == arg0.VK_ESCAPE)
		{
			exit = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) 
	{
		
	}

}
