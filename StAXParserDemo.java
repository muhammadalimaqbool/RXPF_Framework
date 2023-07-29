//package com.tutorialspoint.xml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.io.*;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StAXParserDemo {
   public static void main(String[] args) {

      boolean bName = false;
   boolean bAge = false;
   boolean bRole = false;
   boolean bGender = false;
      
      try {
String filename= "CSV1.csv";
    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
	String FileName="";
	FileName=args[0];
	int size=Integer.parseInt(args[1]);
	int core=Integer.parseInt(args[2]);
long startTime = System.nanoTime();
         XMLInputFactory factory = XMLInputFactory.newInstance();
         XMLEventReader eventReader =
         factory.createXMLEventReader(new FileReader(FileName));

         while(eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();
               
            switch(event.getEventType()) {
               
               case XMLStreamConstants.START_ELEMENT:
                  StartElement startElement = event.asStartElement();
                  String qName = startElement.getName().getLocalPart();

               if (qName.equalsIgnoreCase("Employee")) {
                  System.out.println("Start Element : Employee");
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
               break;

               case XMLStreamConstants.CHARACTERS:
                  Characters characters = event.asCharacters();
               if(bName) {
                  System.out.println("Name: " + characters.getData());
                  bName = false;
               }
               if(bAge) {
                  System.out.println("Age: " + characters.getData());
                  bAge = false;
               }
               if(bRole) {
                  System.out.println("Role: " + characters.getData());
                  bRole = false;
               }
               if(bGender) {
                  System.out.println("Gender: " + characters.getData());
                  bGender = false;
               }
               break;

               case XMLStreamConstants.END_ELEMENT:
                  EndElement endElement = event.asEndElement();
                  
               if(endElement.getName().getLocalPart().equalsIgnoreCase("Employee")) {
                  System.out.println("End Element : Employee");
                  System.out.println();
               }
               break;
            } 
         }

       
long endTime = System.nanoTime();
 
    long durationInNano = (endTime - startTime);
System.out.println("Execution Time : " +durationInNano);
fw.write(size+","+core+","+durationInNano+"\n");//appends the string to the file
    fw.close();
	}catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (XMLStreamException e) {
         e.printStackTrace();
      }
	catch(IOException ioe)
{
    System.err.println("IOException: " + ioe.getMessage());
}

   }
}
