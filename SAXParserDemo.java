//package com.tutorialspoint.xml;

import java.io.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserDemo {
static long endTime = 0;
static long startTime=0;
long durationInNano1=0;
   public static void main(String[] args) {

      try {
String filename= "CSV2.csv";
    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
	String FileName="";
	FileName=args[0];
	int size=Integer.parseInt(args[1]);
	int core=Integer.parseInt(args[2]);
 startTime = System.nanoTime();
//for (int i=0; i<5; i++)
//{
         File inputFile = new File(FileName);
         SAXParserFactory factory = SAXParserFactory.newInstance();
         SAXParser saxParser = factory.newSAXParser();
         UserHandler userhandler = new UserHandler();
         saxParser.parse(inputFile, userhandler);     
//} 
endTime = System.nanoTime();
 long durationInNano = (endTime - startTime);
System.out.println("Execution Time"+FileName+ " : " +durationInNano);
fw.write(size+","+core+","+durationInNano+"\n");//appends the string to the file
        fw.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }   
}

class UserHandler extends DefaultHandler {

   boolean bName = false;
   boolean bAge = false;
   boolean bRole = false;
   boolean bGender = false;
   String str=null;

   @Override
   public void startElement(
      String uri, String localName, String qName, Attributes attributes)
      throws SAXException {
      
      if (qName.equalsIgnoreCase("Employee")) {
      } else if (qName.equalsIgnoreCase("name")) {
         bName = true;
      } else if (qName.equalsIgnoreCase("age")) {
         bAge = true;
      } else if (qName.equalsIgnoreCase("role")) {
         bRole = true;
      }
      else if (qName.equalsIgnoreCase("gender")) {
         bGender = true;
      }
   }

   @Override
   public void endElement(String uri, 
      String localName, String qName) throws SAXException {
      
      if (qName.equalsIgnoreCase("Employee")) {
         System.out.println("End Element :" + qName);
      }
      //System.out.println("yes");
   }
  
   public void endDocument()
   {
 
   }

   @Override
   public void characters(char ch[], int start, int length) throws SAXException {
	str=new String(ch, start, length);
      if (bName) {
	//String str=new String(ch, start, length);
        System.out.println("Name: " + new String(ch, start, length));
         bName = false;
      } else if (bAge) {
	//String str1=new String(ch, start, length);
         System.out.println("Age: " + new String(ch, start, length));
         bAge = false;
      } else if (bRole) {
	//String str2=new String(ch, start, length);
         System.out.println("Role: " + new String(ch, start, length));
         bRole = false;
      } else if (bGender) {
	//String str3=new String(ch, start, length);
         System.out.println("Gender: " + new String(ch, start, length));
         bGender = false;
      }
   }
}
