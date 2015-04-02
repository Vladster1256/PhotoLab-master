package pixLab.classes;

/**
 * This class contains class (static) methods that will help you test the
 * Picture class methods. Uncomment the methods and the code in the main to
 * test.
 * 
 * @author Barbara Ericson
 */
public class PictureTester
{
	/** Method to test zeroBlue */
	public static void testZeroBlue()
	{
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.zeroBlue();
		beach.explore();
	}
	
	/**Method to test keepBlue **/
	public static void testKeepBlue()
	{
		Picture beach = new Picture("beach.jpg");
		beach.keepOnlyBlue();
		beach.explore();
	}

	public static void testNegate()
	{
		Picture beach = new Picture("beach.jpg");
		beach.negate();
		beach.explore();
	}
	
	/** Method to test mirrorVertical */
	public static void testMirrorVertical()
	{
		Picture caterpillar = new Picture("caterpillar.jpg");
		caterpillar.explore();
		caterpillar.mirrorVertical();
		caterpillar.explore();
	}

	/** Method to test mirrorTemple */
	public static void testMirrorTemple()
	{
		Picture temple = new Picture("temple.jpg");
		temple.explore();
		temple.mirrorTemple();
		temple.explore();
	}

	/** Method to test the collage method */
	public static void testCollage()
	{
		Picture canvas = new Picture("640x480.jpg");
		canvas.createCollage();
		canvas.explore();
	}

	/** Method to test edgeDetection */
	public static void testEdgeDetection()
	{
		Picture swan = new Picture("swan.jpg");
		swan.edgeDetection(10);
		swan.explore();
	}

	public static void testGrayscale()
	{
		Picture poker = new Picture("poker.jpg");
		poker.grayscale();
		poker.explore();
	}
	
	public static void testFixUnderwater()
	{
		Picture water = new Picture("water.jpg");
		water.fixUnderwater();
		water.explore();
	}
	
	public static void testKeepOnlyRed()
	{
		Picture beach = new Picture("beach.jpg");
		beach.keepOnlyRed();
		beach.explore();
	}
	
	public static void testKeepOnlyGreen()
	{
		Picture beach = new Picture("beach.jpg");
		beach.keepOnlyGreen();
		beach.explore();
	}
	
	public static void testMirrorVerticalRightToLeft()
	{
		Picture caterpillar = new Picture("caterpillar.jpg");
		caterpillar.mirrorVerticalRightToLeft();
		caterpillar.explore();
	}
	
	public static void testMirrorHorizontalBottomToTop()
	{
		Picture motorcycle = new Picture("redMotorcycle.jpg");
		motorcycle.mirrorHorizontalBotToTop();
		motorcycle.explore();
	}
	
	public static void testMirrorHorizontalTopToBot()
	{
		Picture motorcycle = new Picture("redMotorcycle.jpg");
		motorcycle.mirrorHorizontal();
		motorcycle.explore();
	}
	
	public static void testKeepTopHalf()
	{
		Picture motorcycle = new Picture("redMotorcycle.jpg");
		motorcycle.keepTopHalf();
		motorcycle.explore();
	}
	
	public static void testMirrorDiagonal()
	{
		Picture motorcycle = new Picture("redMotorcycle.jpg");
		motorcycle.mirrorDiagonal();
		motorcycle.explore();
	}
	
	public static void testMirrorArms()
	{
		Picture snowman = new Picture("snowman.jpg");
		snowman.mirrorArms();
		snowman.explore();
	}
	
	public static void createAwesomePicture()
	{
		Picture poker = new Picture("poker.jpg");
		poker.mirrorVerticalRightToLeft();
		poker.mirrorHorizontal();
		poker.mirrorVertical();
		poker.keepOnlyRed();
		poker.grayscale();
		poker.explore();
	}
	
	public static void testSepiaTone()
	{
		Picture beach = new Picture("beach.jpg");
		beach.sepiaTone();
		beach.explore();
	}
	
	public static void testEdgeDetection2()
	{
		Picture swan = new Picture("swan.jpg");
		swan.edgeDetection2(30);
		swan.explore();
	}
	
	public static void testRandomChange()
	{
		Picture poker = new Picture("poker.jpg");
		poker.explore();
		poker.randomChange();
		poker.explore();
	}
	
	public static void testMirrorGull()
	{
		Picture gull = new Picture("seagull.jpg");
		gull.mirrorGull();
		gull.explore();
	}
	
	public static void testCopy()
	{
		Picture poker = new Picture("poker.jpg");
		poker.createExactCopy(poker, 399, 399);
		poker.explore();
	}
	
	public static void testCreateCollage()
	{
		Picture poker = new Picture("poker.jpg");
		poker.createCollage();
		poker.explore();
	}
	
	public static void createGiygas()
	{
		Picture giygas = new Picture("Giygas2.jpg");
		giygas.mirrorHorizontal();
		giygas.keepOnlyRed();
		giygas.mirrorVertical();
		giygas.mirrorVerticalRightToLeft();
		giygas.explore();
		giygas.write("awesomeaiygasaic.jpg");
	}
	
	public static void testChromaKey()
	{
		Picture wowOne = new Picture("wowOne.jpg");
		Picture wowTwo = new Picture("wowTwo.jpg");
		wowOne.chromaKey(wowTwo);
		wowOne.explore();
	}
	
	/**
	 * Main method for testing. Every class can have a main method in Java
	 */
	public static void main(String[] args)
	{
//		 uncomment a call here to run a test
//		 and comment out the ones you don't want
//		 to run
		
		
//		 testRandomChange();
//		 testSepiaTone();
//		 createAwesomePicture();
//		 testZeroBlue();
//		 testKeepBlue();
//		 testKeepOnlyRed();
//		 testKeepOnlyGreen();
//		 testNegate();
//		 testGrayscale();
//		 testFixUnderwater();
//		 testMirrorVertical();
//		 testMirrorHorizontalTopToBot();
//       testMirrorHorizontalBottomToTop();
//		 testMirrorVerticalRightToLeft();
//		 testMirrorTemple();
//     	 testMirrorArms();
//		 testMirrorGull();
//		 testMirrorDiagonal();
//		 testCollage();
//		 testCopy();
//		 testEdgeDetection();
//    	 testEdgeDetection2();
//		 testChromakey();
//		 testEncodeAndDecode();
//		 testGetCountRedOverValue(250);
//		 testSetRedToHalfValueInTopHalf();
//		 testClearBlueOverValue(200);
//		 testGetAverageForColumn(0);
//		 testKeepTopHalf();
//		createGiygas();
		testChromaKey();
	}
}