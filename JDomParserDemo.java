import java.io.File;
import java.io.IOException;
import java.util.List;
import java.io.*;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class JDomParserDemo {

   public static void main(String[] args) {

      try {
      StringBuffer total_buffer = new StringBuffer();
      String filename= "CSV4.csv";
    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
	String FileName="";
	FileName=args[0];
	int size=Integer.parseInt(args[1]);
	int core=Integer.parseInt(args[2]);
long startTime = System.nanoTime();
         File inputFile = new File(FileName);
         SAXBuilder saxBuilder = new SAXBuilder();
         Document document = saxBuilder.build(inputFile);
         System.out.println("Root element :" + document.getRootElement().getName());
         Element classElement = document.getRootElement();

         List<Element> studentList = classElement.getChildren();
         System.out.println("----------------------------");

         for (int temp = 0; temp < studentList.size(); temp++) {    
            Element student = studentList.get(temp);
          /*  total_buffer.append(student.getName()+"\n");
            total_buffer.append("Name : " + student.getChild("name").getText()+"\n");
               total_buffer.append("Age : "  + student.getChild("age").getText()+"\n");
               total_buffer.append("Role : " + student.getChild("role").getText()+"\n");
               total_buffer.append("Gender : " + student.getChild("gender").getText()+"\n");*/
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
     //    String comp_string=total_buffer.toString();
//System.out.println(comp_string);
         long endTime = System.nanoTime();
 
    long durationInNano = (endTime - startTime);
System.out.println("Execution Time : " +durationInNano);
fw.write(size+","+core+","+durationInNano+"\n");//appends the string to the file
    fw.close();
      } catch(JDOMException e) {
         e.printStackTrace();
      } catch(IOException ioe) {
         ioe.printStackTrace();
      }
   }
}
