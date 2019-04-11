package Objects3D;

import java.awt.Color;

import math.Expression;
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
			boolean pass = true;
			try {
				Test.xMin = Double.parseDouble(panel.xMinTextBox.getText());
				panel.xMinTextBox.setBackgroundColor(new Color(255,255,255));
			} catch (Exception e) {
				panel.xMinTextBox.setBackgroundColor(new Color(255,0,0));
				pass = false;
			}
			try {
				Test.yMin = Double.parseDouble(panel.yMinTextBox.getText());
				panel.yMinTextBox.setBackgroundColor(new Color(255,255,255));
			} catch (Exception e) {
				panel.yMinTextBox.setBackgroundColor(new Color(255,0,0));
				pass = false;
			}
			try {
				Test.xMax = Double.parseDouble(panel.xMaxTextBox.getText());
				panel.xMaxTextBox.setBackgroundColor(new Color(255,255,255));
			} catch (Exception e) {
				panel.xMaxTextBox.setBackgroundColor(new Color(255,0,0));
				pass = false;
			}
			try {
				Test.yMax = Double.parseDouble(panel.yMaxTextBox.getText());
				panel.yMaxTextBox.setBackgroundColor(new Color(255,255,255));
			} catch (Exception e) {
				panel.yMaxTextBox.setBackgroundColor(new Color(255,0,0));
				pass = false;
			}
			try {
				Test.zMin = Double.parseDouble(panel.zMinTextBox.getText());
				panel.zMinTextBox.setBackgroundColor(new Color(255,255,255));
			} catch (Exception e) {
				panel.zMinTextBox.setBackgroundColor(new Color(255,0,0));
				pass = false;
			}
			try {
				Test.zMax = Double.parseDouble(panel.zMaxTextBox.getText());
				panel.zMaxTextBox.setBackgroundColor(new Color(255,255,255));
			} catch (Exception e) {
				panel.zMaxTextBox.setBackgroundColor(new Color(255,0,0));
				pass = false;
			}
			if (Test.xMax - Test.xMin <= 0)
			{
				panel.xMaxTextBox.setBackgroundColor(new Color(255,0,0));
				panel.xMinTextBox.setBackgroundColor(new Color(255,0,0));
				pass = false;
			}
			if (Test.yMax - Test.yMin <= 0)
			{
				panel.yMaxTextBox.setBackgroundColor(new Color(255,0,0));
				panel.yMinTextBox.setBackgroundColor(new Color(255,0,0));
				pass = false;
			}
			if (Test.zMax - Test.zMin <= 0)
			{
				panel.zMaxTextBox.setBackgroundColor(new Color(255,0,0));
				panel.zMinTextBox.setBackgroundColor(new Color(255,0,0));
				pass = false;
			}
			try {
				Expression e = new Expression(panel.zTextBox.getText());
				panel.zTextBox.setBackgroundColor(new Color(255,255,255));
				if (pass)
				{
					Test.e = e;
					Test.graphEquation(panel);
				}
			} catch (Exception e) {
				panel.zTextBox.setBackgroundColor(new Color(255,0,0));
			}
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
			panel.zMaxLabel.setVisible(true);
			panel.zMinLabel.setVisible(true);
			panel.zMaxTextBox.setVisible(true);
			panel.zMinTextBox.setVisible(true);
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
				panel.zMaxLabel.setVisible(false);
				panel.zMinLabel.setVisible(false);
				panel.zMaxTextBox.setVisible(false);
				panel.zMinTextBox.setVisible(false);
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
