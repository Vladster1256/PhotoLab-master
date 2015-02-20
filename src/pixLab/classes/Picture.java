package pixLab.classes;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture
{
	// /////////////////// constructors //////////////////////////////////

	/**
	 * Constructor that takes no arguments
	 */
	public Picture()
	{
		/*
		 * not needed but use it to show students the implicit call to super()
		 * child constructors always call a parent constructor
		 */
		super();
	}

	/**
	 * Constructor that takes a file name and creates the picture
	 * 
	 * @param fileName
	 *            the name of the file to create the picture from
	 */
	public Picture(String fileName)
	{
		// let the parent class handle this fileName
		super(fileName);
	}

	/**
	 * Constructor that takes the width and height
	 * 
	 * @param height
	 *            the height of the desired picture
	 * @param width
	 *            the width of the desired picture
	 */
	public Picture(int height, int width)
	{
		// let the parent class handle this width and height
		super(width, height);
	}

	/**
	 * Constructor that takes a picture and creates a copy of that picture
	 * 
	 * @param copyPicture
	 *            the picture to copy
	 */
	public Picture(Picture copyPicture)
	{
		// let the parent class do the copy
		super(copyPicture);
	}

	/**
	 * Constructor that takes a buffered image
	 * 
	 * @param image
	 *            the buffered image to use
	 */
	public Picture(BufferedImage image)
	{
		super(image);
	}

	// //////////////////// methods ///////////////////////////////////////

	/**
	 * Method to return a string with information about this picture.
	 * 
	 * @return a string with information about the picture such as fileName,
	 *         height and width.
	 */
	public String toString()
	{
		String output = "Picture, filename " + getFileName() + " height " + getHeight() + " width " + getWidth();
		return output;

	}

	/** Method to set the blue to 0 */
	public void zeroBlue()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setBlue(0);
			}
		}
	}

	/**
	 * This keeps only green and removes blue and red
	 */
	public void keepOnlyGreen()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setRed(0);
				pixelObj.setBlue(0);
			}
		}
	}

	/**
	 * this keeps only red and removes blue and green
	 */
	public void keepOnlyRed()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setBlue(0);
				pixelObj.setGreen(0);
			}
		}
	}

	/**
	 * this keeps only blue values and removes red and green values
	 */
	public void keepOnlyBlue()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setGreen(0);
				pixelObj.setRed(0);
			}
		}
	}

	/**
	 * This is what we use to negate the photos
	 */
	public void negate()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setGreen(255 - pixelObj.getGreen());
				pixelObj.setBlue(255 - pixelObj.getBlue());
				pixelObj.setRed(255 - pixelObj.getRed());
			}
		}
	}

	/**
	 * this turns the image grayscale
	 */
	public void grayscale()
	{
		Pixel[][] pixels = this.getPixels2D();
		
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				int averageColor = (pixelObj.getBlue() + pixelObj.getGreen() + pixelObj.getRed()/3);
				
					pixelObj.setGreen(averageColor/2);
					pixelObj.setBlue(averageColor/2);
					pixelObj.setRed(averageColor/2);
				
				
			}
		}
	}

	/**
	 * This fixes the underwater image by adding more red values to the image
	 */
	public void fixUnderwater()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setRed(pixelObj.getRed() * 5);
			}
		}
	}
	
	/**
	 * This is the method we use to copy the original gull and copy it to the right a bit
	 */
	public void mirrorGull()
	{
		int LeftstartCopy = 234;
		Pixel LefttopPixel = null;
		Pixel LeftbottomPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		int LeftendCopy = 340;
		

		// loop through the rows
		for (int row = 233; row < 323; row++)
		{
			
			// 
			for (int col = LeftstartCopy; col < LeftendCopy; col++)
			{
				LefttopPixel = pixels[row][col];
				LeftbottomPixel = pixels[row][col+105];
				LeftbottomPixel.setColor(LefttopPixel.getColor());

			}
		}
	}

	/**
	 * Method that mirrors the picture around a vertical mirror in the center of
	 * the picture from left to right
	 */
	public void mirrorVertical()
	{
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++)
		{
			for (int col = 0; col < width / 2; col++)
			{
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	/**
	 * This mirrors the image from right to left
	 */
	public void mirrorVerticalRightToLeft()
	{
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++)
		{
			for (int col = 0; col < width / 2; col++)
			{
				rightPixel = pixels[row][width - 1 - col];
				leftPixel = pixels[row][col];
				leftPixel.setColor(rightPixel.getColor());
			}
		}
	}

	/** Mirror just part of a picture of a temple */
	public void mirrorTemple()
	{
		int mirrorPoint = 276;
		int count = 0;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel[][] pixels = this.getPixels2D();

		// loop through the rows
		for (int row = 27; row < 97; row++)
		{
			// loop from 13 to just before the mirror point
			for (int col = 13; col < mirrorPoint; col++)
			{
				count++;
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
				rightPixel.setColor(leftPixel.getColor());
				System.out.println(count);
			}
		}
	}

	public void mirrorArms()
	{
		int LeftstartCopy = 100;
		Pixel LefttopPixel = null;
		Pixel LeftbottomPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		int LeftendCopy = 170;
		int Leftadding = LeftendCopy - LeftstartCopy;

		// loop through the rows
		for (int row = 155; row < 190; row++)
		{
			
			// 
			for (int col = LeftstartCopy; col < LeftendCopy; col++)
			{
				LefttopPixel = pixels[row][col];
				LeftbottomPixel = pixels[LeftstartCopy + row - LeftendCopy +140][col-5];
				LeftbottomPixel.setColor(LefttopPixel.getColor());

			}
		}
		 int RightstartCopy = 239;
		 Pixel RighttopPixel = null;
		 Pixel RightbottomPixel = null;
		 int RightendCopy = 290;
		 
		 for(int Rightrow = 155; Rightrow<190; Rightrow++)
		 {
			 for (int Rightcol = RightstartCopy; Rightcol < RightendCopy; Rightcol++)
			 {
				 RighttopPixel = pixels[Rightrow][Rightcol];
				 RightbottomPixel = pixels[RightstartCopy + Rightrow - RightendCopy + 130][Rightcol+5];
				 RightbottomPixel.setColor(RighttopPixel.getColor());
			 }
		 }
		
	}

	public void sepiaTone()
	{
		Pixel[][] pixels = this.getPixels2D();

		for (int row = 0; row < pixels.length; row++)
		{
			for (int col = 0; col < pixels[0].length; col++)
			{
				// Pseudocode for filter
				/**
				 * Change each pixel to a tint of brown (112,66,20) to (255,
				 * 255, 255) First algorithm: cut the red to fit between 112-255
				 * shift green to half of red shift blue to a third of green
				 */
				Pixel sepiaPixel = pixels[row][col];
				int averageColor = (sepiaPixel.getRed() + sepiaPixel.getBlue() + sepiaPixel.getGreen()) / 3;
				if (averageColor < 80)
				{
					sepiaPixel.setGreen(sepiaPixel.getRed() / 2);
					sepiaPixel.setBlue(sepiaPixel.getGreen() / 3);
				} else
				{
					sepiaPixel.setRed((int) (sepiaPixel.getRed() * .9));
					sepiaPixel.setGreen((int) (sepiaPixel.getRed() * .8));
					sepiaPixel.setBlue((int) (sepiaPixel.getRed() * .5));
				}

			}
		}
	}

	public void mirrorHorizontalBotToTop()
	{
		Pixel[][] pixels = this.getPixels2D();
		Pixel botPixel = null;
		Pixel topPixel = null;
		int height = pixels.length;
		for (int col = 0; col < pixels[0].length; col++)
		{
			for (int row = 0; row < height / 2; row++)
			{
				botPixel = pixels[height - 1 - row][col];
				topPixel = pixels[row][col];
				topPixel.setColor(botPixel.getColor());
			}
		}
	}

	public void mirrorHorizontal()
	{
		Pixel[][] pixels = this.getPixels2D();
		Pixel botPixel = null;
		Pixel topPixel = null;
		int height = pixels.length;
		for (int col = 0; col < pixels[0].length; col++)
		{
			for (int row = 0; row < height / 2; row++)
			{
				topPixel = pixels[row][col];
				botPixel = pixels[height - 1 - row][col];
				botPixel.setColor(topPixel.getColor());
			}
		}
	}

	public void keepTopHalf()
	{
		Pixel[][] pixels = this.getPixels2D();
		Pixel botPixel = null;
		Pixel topPixel = null;
		int height = pixels.length;
		for (int col = 0; col < pixels[0].length; col++)
		{
			for (int row = 0; row < height / 2; row++)
			{
				topPixel = pixels[row][col];
				botPixel = pixels[height - 1 - row][col];
				botPixel.setBlue(255);
				botPixel.setRed(255);
				botPixel.setGreen(255);
				botPixel.setAlpha(255);
			}
		}
	}

	public void mirrorDiagonal()
	{
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftSide = null;
		Pixel rightSide = null;
		int rowOn = 1;
		int colOn = 1;
		
		
		
		int slope = -(pixels[0].length/pixels.length);
		
		int height = pixels.length;
		for(int row = 0; row < height; row++)
		{
			for(int col = 0; col< pixels[0].length; col++)
			{
				if(rowOn > row && colOn > col)
				{
					
				}
			}
			rowOn++;
			colOn++;
			
		}
	}
	
	

	/**
	 * copy from the passed fromPic to the specified startRow and startCol in
	 * the current picture
	 * 
	 * @param fromPic
	 *            the picture to copy from
	 * @param startRow
	 *            the start row to copy to
	 * @param startCol
	 *            the start col to copy to
	 */
	public void copy(Picture fromPic, int startRow, int startCol)
	{
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length && toRow < toPixels.length; fromRow++, toRow++)
		{
			for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length && toCol < toPixels[0].length; fromCol++, toCol++)
			{
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}
	
	public void createExactCopy(Picture fromPic, int startRow, int startCol)
	{
		Picture poker = new Picture("poker.jpg");
		Pixel [][] pokerImage = fromPic.getPixels2D();
		this.copy(poker, 0, 0);
		this.copy(fromPic, startRow , startCol);
	}

	/** Method to create a collage of several pictures */
	public void createCollage()
	{
		Picture flower1 = new Picture("flower1.jpg");
		Picture flower2 = new Picture("flower2.jpg");
		Picture poker = new Picture("poker.jpg");
		this.copy(flower1, 0, 0);
		this.copy(flower2, 100, 0);
		this.copy(flower1, 200, 0);
		Picture flowerNoBlue = new Picture(flower2);
		flowerNoBlue.zeroBlue();
		this.copy(flowerNoBlue, 300, 0);
		this.copy(flower1, 400, 0);
		this.copy(flower2, 500, 0);
		this.mirrorVertical();
		this.write("collage.jpg");
		this.copy(poker, 0, 100);
	}

	/**
	 * Method to show large changes in color
	 * 
	 * @param edgeDist
	 *            the distance for finding edges
	 */
	public void edgeDetection(int edgeDist)
	{
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		Color rightColor = null;
		for (int row = 0; row < pixels.length; row++)
		{
			for (int col = 0; col < pixels[0].length - 1; col++)
			{
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][col + 1];
				rightColor = rightPixel.getColor();
				if (leftPixel.colorDistance(rightColor) > edgeDist)
					leftPixel.setColor(Color.BLACK);
				else
					leftPixel.setColor(Color.WHITE);
			}
		}
	}

	public void edgeDetection2(int edgeDist)
	{
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		Color rightColor = null;
		for (int row = 0; row < pixels.length; row++)
		{
			for (int col = 0; col < pixels[0].length - 5; col++)
			{
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][col + 5];
				rightColor = rightPixel.getColor();
				if (leftPixel.colorDistance(rightColor) > edgeDist)
					leftPixel.setColor(Color.BLACK);
				else
					leftPixel.setColor(Color.WHITE);
			}
		}
	}

	public void randomChange()
	{
		Pixel[][] imageMatrix = this.getPixels2D();
		for (int row = 0; row < imageMatrix.length; row += 2)
		{
			for (int col = 0; col < imageMatrix[0].length; col++)
			{
				int randomRed = (int) (Math.random() * 256);
				int randomGreen = (int) (Math.random() * 256);
				int randomBlue = (int) (Math.random() * 256);

				imageMatrix[row][col].setRed(randomRed);
				imageMatrix[row][col].setGreen(randomGreen);
				imageMatrix[row][col].setBlue(randomBlue);
			}
		}

	}

	/*
	 * Main method for testing - each class in Java can have a main method
	 */
	public static void main(String[] args)
	{
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.zeroBlue();
		beach.explore();
	}

} // this } is the end of class Picture, put all new methods before this
