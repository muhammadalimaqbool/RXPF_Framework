//package com.tutorialspoint.xml;

import java.io.*;
import java.nio.file.*;
import org.xml.sax.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DomParserDemo {

   public static void main(String[] args) {

      try {
      String filename= "CSV3.csv";
    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
	String FileName="";
	
	
       // System.out.println(myNumbers[i][j]);
	FileName=args[0];
	int size=Integer.parseInt(args[1]);
	int core=Integer.parseInt(args[2]);
         File inputFile = new File(FileName);
         long startTime = System.nanoTime();
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
         NodeList nList = doc.getElementsByTagName("Employee");
         System.out.println("----------------------------");
         
         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               
               System.out.println("Name : " 
                  + eElement
                  .getElementsByTagName("name")
                  .item(0)
                  .getTextContent());
               System.out.println("Age : " 
                  + eElement
                  .getElementsByTagName("age")
                  .item(0)
                  .getTextContent());
               System.out.println("Role : " 
                  + eElement
                  .getElementsByTagName("role")
                  .item(0)
                  .getTextContent());
               System.out.println("Gender : " 
                  + eElement
                  .getElementsByTagName("gender")
                  .item(0)
                  .getTextContent());
            }
         }
         long endTime = System.nanoTime();        
    long durationInNano = (endTime - startTime);
System.out.println("Execution Time"+FileName+ " : " +durationInNano);
fw.write(size+","+core+","+durationInNano+"\n");//appends the string to the file

    fw.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
