package com.drezz.SamplePdfReader;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws TesseractException
    {
    	Tesseract tesseract = new Tesseract();
    	tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
    	File file = new File("C:\\Users\\hussain\\Downloads\\HeathCommunityForm.pdf");
    	String result = tesseract.doOCR(file);
    	System.out.println(result);
    	
    }
}
