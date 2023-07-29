import Tre.MyNode;
import encode.Encodedemo;
import encode.Callme;
import Pqr.Abcd;
import java.util.Scanner;
import java.util.regex.*;
import java.util.StringTokenizer;  
import java.util.Hashtable;
import java.util.Enumeration;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.nio.file.*;
import org.xml.sax.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
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
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.io.*;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import java.util.Optional;
import java.util.Arrays;
public class RXPF {
public double beta;

 private double[] weights;

 private double learningRate = 0.0001d;

 private int epochs;
 public static void main(String[] args) throws IOException{
 	
	try{
	//String[] cmd = {"sh profiling.sh", "/home/ali/code/AllParser2023/code_28july2023_Github"};
	
 
      String filename= "Results25july.txt";
    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
	String FileName="";
	String CSV_FN="";
	RXPF[] ooo1=new RXPF[9];
	for(int ob=0; ob<9; ob++)
	ooo1[ob]=new RXPF();
	ArrayList<Double> B0 = new ArrayList<Double>();
	ArrayList<Double> B1 = new ArrayList<Double>();
	ArrayList<Double> B2 = new ArrayList<Double>();
	//String ss = new String(Files.readAllBytes(Paths.get("DOM.txt")));
	//   System.out.println("111111111111111111111111111111\n"+ss);
	//FileWriter fw_new = new FileWriter("codefile.txt",true);
	//fw_new.write(ss);
	//fw_new.close();
	for(int fi=1; fi<10; fi++)
	{
	CSV_FN="CSV"+String.valueOf(fi)+".csv";
	 ooo1[fi-1].CSV_to_Arrays(CSV_FN);
	 //System.out.println("******************************************************"+ooo1[fi-1].beta); 
	 B0.add(ooo1[fi-1].beta);
	  B1.add(ooo1[fi-1].weights[0]);
	   B2.add(ooo1[fi-1].weights[1]);
	//System.out.println("***************************"+CSV_FN);
	}
	//System.out.println("***************************"+B0);
	//System.out.println("***************************"+B1);
	//System.out.println("***************************"+B2);
 Double b0[] = new Double[B0.size()];
 b0 = B0.toArray(b0);

 Double b1[] = new Double[B1.size()];
b1 = B1.toArray(b1);

 Double b2[] = new Double[B2.size()];
b2 = B2.toArray(b2);

//for(int bbb=0; bbb<Beta2.length; bbb++)
//System.out.println("***************************"+Beta2[bbb]);
long startTime = System.nanoTime();
        //double[] b0={0.405,0.581,0.612,0.649,0.415,0.107,0.095,0.120,0.068};
       // double[] b1={0.167,0.126,0.156,0.154,0.112,0.145,0.147,0.152,0.153};
       // double[] b2={-0.015,-0.036,-0.043,-0.043,-0.029,0.005,0.017,0.011,0.015};
        double[] res=new double[9];
      	FileName=args[0];
       int size=Integer.parseInt(args[1]);
       int core=Integer.parseInt(args[2]);
        for(int i=0; i<9; i++)
        {
        res[i]=b0[i]+ (size*b1[i]) +(core*b2[i]);
         System.out.println(res[i]);
	}
	double min=res[0];
	int ind=-1;
	for(int i=1; i<9; i++)
	{
	if(min>res[i])
	{
	min=res[i];
        ind=i;
        }
        }
        System.out.println("minimum value is.."+min+".. at index .."+ind);
        //int processor=Integer.parseInt(args[1]);
	
	
	//System.out.println(".................................................DOM................................................");
	//ooo1.DOM(FileName);
	//System.out.println(".................................................SAX................................................");
	//ooo1.SAX(FileName);
	//System.out.println(".................................................PXTG................................................");
	//ooo1.PXTG(FileName);
	//System.out.println(".................................................StAX................................................");
	//ooo1.StAX(FileName);
	//System.out.println(".................................................JDOM................................................");
	//ooo1.JDOM(FileName);
	String ss0 = new String(Files.readAllBytes(Paths.get("RXPFTemplateImport.java")));
	String ss2 = new String(Files.readAllBytes(Paths.get("RXPFTemplate.java")));
	String ss=ss0+"\n"
	+ "	class RXPFParser{\n"
	+"public static void main(String args[])\n"
	+"{\n"
	  +"int ind=" + ind + ";\n"
	  +"RXPFParser rp= new RXPFParser();\n"
	  +"callParser(ind,rp,\"" + FileName+"\");\n"
	+"}\n"
	+ ss2 
	+ "\n"
	//+"}\n"
	;
	
       FileWriter fw_new = new FileWriter("RXPFParser.java",false);
	fw_new.write(ss);
	fw_new.close();
       /*  
	
	*/
	//long endTime = System.nanoTime();
 
    //long durationInNano = (endTime - startTime);
//System.out.println("Execution Time : " +durationInNano);
//fw.write("Core:::"+core+":::Size:::"+size+"::: and minimum value is.."+min+".. at index .."+ind+":::\n");//appends the string to the file
   // fw.close();
      }  catch(IOException ioe) {
         ioe.printStackTrace();
      }
 }// end main
 public void CSV_to_Arrays(String CSV_file)
 {
 try{
 Scanner scan = new Scanner(new File(CSV_file));
ArrayList<String[]> records = new ArrayList<String[]>();
String[] record = new String[2];
while(scan.hasNext()) {
        record = scan.nextLine().split(",");
        records.add(record);
}
int rows = records.size();
String[] a = new String[rows];
String[] b = new String[rows];
String[] c = new String[rows];
int csv_count=0;
int j = 0;
for (String[] temp : records) {
    a[j] = temp[0];
    b[j] = temp[1];
    c[j] = temp[2];
     j++;
csv_count++;
}
int sum=0;
double y[]=new double[csv_count];
for(int g=0; g<a.length; g++)
{
y[g]=Double.parseDouble(c[g]);
}

double x[][]=new double[csv_count][2];
 for (int  i = 0; i < x.length; ++i) {
      for(int  cc = 0; cc < x[i].length; ++cc) {
      if (cc==0)
      x[i][cc]=Double.parseDouble(a[i]);
      if(cc==1)
      x[i][cc]=Double.parseDouble(b[i]);
      }
      }
     LinearRegression(x[0].length,1);
 	trainSGD(x, y);
}//end try of CSV_to_arrays
catch(IOException ioe) {
         ioe.printStackTrace();
      }
 
 }
 public void LinearRegression(int featuresCount, int epochs) {
  weights = new double[featuresCount];
  this.epochs = epochs;
 }

 public Optional<Double> predict(double[] inputs) {
  if (inputs == null || inputs.length <= 0) {
   return Optional.empty();
  }

  double result = 0d;
  for (int i = 0; i < inputs.length; i++) {
   result = inputs[i] * weights[i] + result;
  }

  result = result + beta;

  return Optional.of(result);
 }
 public void trainSGD(double[][] trainData, double[] result) {
  
  if (trainData == null || trainData.length <= 0) {
   throw new RuntimeException("Input data can not be null");
  }
  // Stochastic Gradient descent
  for (int e = 0; e < epochs; e++) {
   double mse = 0d;
   for (int i = 0; i < trainData.length; i++) {
    double[] tempInput = trainData[i];

    Optional<Double> predictedValueOptional = this.predict(tempInput);

    double predictedValue = predictedValueOptional.get();

    double error = predictedValue - result[i];
    mse = error * error + mse;

    for (int j = 0; j < weights.length; j++) {
     weights[j] = weights[j] - learningRate * error * tempInput[j];

    }
    beta = beta - learningRate * error;

   }

   mse = (Math.sqrt(mse)) / trainData.length;
   System.out.println(" MSE " + mse + " Weights " + Arrays.toString(weights) + " Beta " + beta);
  }
  
 }
 public void JDOM(String fn)
 {
 try {
      StringBuffer total_buffer = new StringBuffer();
 
	String FileName="";
	FileName=fn;
         File inputFile = new File(FileName);
         SAXBuilder saxBuilder = new SAXBuilder();
         org.jdom2.Document document = saxBuilder.build(inputFile);
         System.out.println("Root element :" + document.getRootElement().getName());
         org.jdom2.Element classElement = document.getRootElement();

         List<org.jdom2.Element> studentList = classElement.getChildren();
         System.out.println("----------------------------");

         for (int temp = 0; temp < studentList.size(); temp++) {    
            org.jdom2.Element student = studentList.get(temp);
            System.out.println("\nCurrent Element :" 
               + student.getName());
            System.out.println("Name : "
               + student.getChild("name").getText());
            System.out.println("AGE : "
               + student.getChild("age").getText());
            System.out.println("ROLE : "
               + student.getChild("role").getText());
            System.out.println("GENDER : "
               + student.getChild("gender").getText());
         }
    
      } catch(JDOMException e) {
         e.printStackTrace();
      } catch(IOException ioe) {
         ioe.printStackTrace();
      }
 } 

 public void StAX(String fn)
 {
       boolean bName = false;
   boolean bAge = false;
   boolean bRole = false;
   boolean bGender = false;
      
      try {
	 XMLInputFactory factory = XMLInputFactory.newInstance();
         XMLEventReader eventReader =
         factory.createXMLEventReader(new FileReader(fn));

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

       

	}catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (XMLStreamException e) {
         e.printStackTrace();
      }

 }
public void PXTG(String fn)
{
try{

	List<String> dtd_elements = new ArrayList<>();
	//Node nNode=new Node();
	Abcd obj=new Abcd();
	
	String FileName1="";
	FileName1="dtd_emp.txt";
	dtd_elements=obj.mycode(FileName1);
	String ss = new String(Files.readAllBytes(Paths.get(fn)));
	   //System.out.println("111111111111111111111111111111"+ss);
String value_underrootnode="";
long lines =ss.lines().count();
int str_length=ss.length();  
			int processor=1;
			int cores=processor;// actually representing chunk(s)
                  	int n=ss.length()/cores;
                       int v;
                   	String[] str_part=new String[cores];
                   	
                   	List<String> str_token = new ArrayList<String>();
                   for(v=0; v<cores-1; v++)
                   {
                   str_part[v]=ss.substring(n*v,n*(v+1));
                   }
                   str_part[v]=ss.substring(n*(cores-1),str_length-1);
                          
                   for(v=0; v<cores-1; v++)
                      {
                   
                     StringTokenizer sstt2 = new StringTokenizer(str_part[v+1],"\n"); 
                   	String sssstttt=sstt2.nextToken();
                   	str_token.add(sssstttt);
                      }  
                      for(v=0; v<cores-1; v++)
                      {
            //          System.out.println("111111111111111111111111111111");
                    str_part[v]= str_part[v].concat(str_token.get(v));
                      }
               
              for(v=1; v<cores; v++)
              {
              str_part[v]=str_part[v].substring(str_token.get(v-1).length()+1,str_part[v].length());
              }
          
long size_in_line=lines/cores;

Callme[] target = new Callme[cores];

for(v=0; v<cores; v++)
target[v]=new Callme();

//Encodedemo ob[];

Encodedemo[] ob= new Encodedemo[cores];
ob[0]= new Encodedemo(target[0],0,str_part[0],dtd_elements,true);
for(v=1; v<cores; v++)
{
ob[v]= new Encodedemo(target[v],v,str_part[v],dtd_elements,false);
}


for(v=0; v<cores; v++)
ob[v].t.join();


for(v=1; v<cores; v++)
{
for(int o=0; o<target[v-1].value.size(); o++)
target[v].treeRootNode.children.get(0).children.get(o).children.get(0).setId(target[v-1].value.get(o));
}

for(v=0; v<cores; v++)
{
if(target[v].treeRootNode.children.get(target[v].emp_count-1).children.size()<4)
target[v].treeRootNode.children.remove(target[v].emp_count-1);
}

for(v=0; v<cores; v++)
{
System.out.println(".......................................tree"+"  "+(v+1));
target[v].printTree(target[v].treeRootNode, " ");
}
} // end try
catch (Exception e) {
         e.printStackTrace();
      }
} 
public void DOM(String fn)
 {
 try {
 
	String FileName="";
	
	FileName=fn;
         File inputFile = new File(FileName);
         //startTime = System.nanoTime();
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
    } catch (Exception e) {
         e.printStackTrace();
      }
   }
      public void SAX(String fn)
      {
      try {

	String FileName="";
	FileName=fn;

         File inputFile = new File(FileName);
         SAXParserFactory factory = SAXParserFactory.newInstance();
         SAXParser saxParser = factory.newSAXParser();
         UserHandler userhandler = new UserHandler();
         saxParser.parse(inputFile, userhandler);     
           } catch (Exception e) {
         e.printStackTrace();
      }
      
}
 }// end class TreeDemo1.java
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

