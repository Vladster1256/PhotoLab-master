package pix.view;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;

import pix.controller.FauxToeShopController;
import pixLab.classes.ImageDisplay;
import pixLab.classes.Picture;

public class FauxToeShopPanel extends JPanel
{
	private FauxToeShopController mainController;
	private SpringLayout baseLayout;
	private JScrollPane imagePane;
	private JComboBox <String>filterBox;
	private Picture basePicture;
	private String [] imageArray;
	private JComboBox <String> imageBox;
	
	
	public FauxToeShopPanel(FauxToeShopController mainController)
	{
		this.mainController = mainController;
		baseLayout = new SpringLayout();
		imagePane = new JScrollPane();
		basePicture = new Picture("poker.jpg");
		
		
		//setupPicture();
		//setupComboBox();
		setupPanel();
		//setupLayout();
		//setupListeners();
		
	}

	private void setupComboBox()
	{
		String[] filterArray = {
				"TestRotateColor",
				"TestRandomChange",
				"TestZeroBlue",
				"testCollage",
				"testCopy",
				"testEdgeDetection",
				"testEdgeDetection2",
				"testChromakey",
				"TestEndodeAndDecode",
				"TestGetCountRedOverValue",
				"testClearBlueOverValue",
				"testGetAverageForColumn"
		};
		filterBox = new JComboBox(filterArray);
		
		imageArray = new String [] {
				"kitten2.jpg",
				"water.jpg",
				"wall.jpg",
				"barbaraS.jpg",
				"moon-surface.jpg",
				"koala,jpg",
				"poker.jpg",
				"redMotorcycle.jpg"
				
		};
		
				
	}
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(filterBox);
	//	this.add(imagePane);
	}

	private void loadPicture()
	{
		basePicture = new Picture (imageArray[imageBox.getSelectedIndex()]);
		setupPicture();
	}
	private void setupPicture()
	{
		BufferedImage bufferedPic = basePicture.getBufferedImage();
		ImageDisplay picDisplay = new ImageDisplay(bufferedPic);
		imagePane.setViewportView(picDisplay);
	}
	
	private void setupListeners()
	{
		imageBox.addItemListener(new ItemListener()
		{
			@Override
			public void itemStateChanged(ItemEvent currentEvent)
			{
				loadPicture();
			}
		});
		
		filterBox.addItemListener(new ItemListener()
		{
			@Override
			public void itemStateChanged(ItemEvent currentEvent)
			{
			if(filterBox.getSelectedIndex()==0)
			{
				loadPicture();
				basePicture.randomChange();
				setupPicture();
			}
		
			}});
	}
	
	private void setupLayout()
	{
		
	}
	
}

