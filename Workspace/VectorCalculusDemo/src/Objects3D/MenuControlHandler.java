package Objects3D;

import ui.ControlHandler;

public class MenuControlHandler extends ControlHandler
{
	Panel3D panel;
	public MenuControlHandler(Panel3D panel)
	{
		this.panel = panel;
	}
	public void clickEvent(String id)
	{
		if (id.equals("Calculate"))
		{
			
		}
		else if (id.equals("Open Calculation Window"))
		{
			panel.setCalculationLabel.setVisible(false);
			panel.specialSettingsLabel.setVisible(false);
			panel.zLabel.setVisible(true);
			panel.zTextBox.setVisible(true);
			panel.backLabel.setVisible(true);
			panel.calculateButton.setVisible(true);
			panel.xMaxTextBox.setVisible(true);
			panel.xMinTextBox.setVisible(true);
			panel.yMaxTextBox.setVisible(true);
			panel.yMinTextBox.setVisible(true);
			panel.xMaxLabel.setVisible(true);
			panel.xMinLabel.setVisible(true);
			panel.yMaxLabel.setVisible(true);
			panel.yMinLabel.setVisible(true);
			panel.rangeLabel.setVisible(true);
			panel.paint = true;
		}
		else if (id.equals("Open Special Settings Window"))
		{
			panel.setCalculationLabel.setVisible(false);
			panel.specialSettingsLabel.setVisible(false);
			panel.saturnRadioButton.setVisible(true);
			panel.starsRadioButton.setVisible(true);
			panel.sunRadioButton.setVisible(true);
			panel.backLabel.setVisible(true);
			panel.paint = true;
		}
		else if (id.equals("back"))
		{
			panel.setCalculationLabel.setVisible(true);
			panel.specialSettingsLabel.setVisible(true);
			if (panel.starsRadioButton.isVisible())
			{
				panel.saturnRadioButton.setVisible(false);
				panel.starsRadioButton.setVisible(false);
				panel.sunRadioButton.setVisible(false);
			}
			else if (panel.zLabel.isVisible())
			{
				panel.zLabel.setVisible(false);
				panel.zTextBox.setVisible(false);
				panel.calculateButton.setVisible(false);
				panel.xMaxTextBox.setVisible(false);
				panel.xMinTextBox.setVisible(false);
				panel.yMaxTextBox.setVisible(false);
				panel.yMinTextBox.setVisible(false);
				panel.xMaxLabel.setVisible(false);
				panel.xMinLabel.setVisible(false);
				panel.yMaxLabel.setVisible(false);
				panel.yMinLabel.setVisible(false);
				panel.rangeLabel.setVisible(false);
			}
			panel.backLabel.setVisible(false);
			panel.paint = true;
		}
		else if (id.equals("Stars"))
		{
			if (panel.stars == false)
			{
				panel.stars = true;
			}
			else
			{
				panel.stars = false;
			}
			Test.worldSetUp(panel);
			panel.paint = true;
		}
		else if (id.equals("Sun"))
		{
			if (panel.sun == false)
			{
				panel.sun = true;
			}
			else
			{
				panel.sun = false;
			}
			Test.worldSetUp(panel);
			panel.paint = true;
		}
		else if (id.equals("Saturn"))
		{
			if (panel.saturn == false)
			{
				panel.saturn = true;
			}
			else
			{
				panel.saturn = false;
			}
			Test.worldSetUp(panel);
			panel.paint = true;
		}
	}
}
