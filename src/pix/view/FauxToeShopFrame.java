package pix.view;

import javax.swing.JFrame;

import pix.controller.FauxToeShopController;

public class FauxToeShopFrame extends JFrame
{
	private FauxToeShopPanel mainPanel;

	public FauxToeShopFrame(FauxToeShopController baseController)
	{
		mainPanel = new FauxToeShopPanel(baseController);
		setupFrame();
	}

	private void setupFrame()
	{
		this.setSize(600, 600);
		this.setContentPane(mainPanel);
		this.setVisible(true);
		this.setResizable(true);
	}
}
