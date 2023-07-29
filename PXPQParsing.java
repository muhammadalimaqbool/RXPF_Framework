import Tre.MyNode;
import encode.Encodedemo;
import encode.Callme;
import Pqr.Abcd;
import java.util.Scanner;
import java.io.*;
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

public class PXPQParsing {

 public static void main(String[] args) throws IOException{
try{

	String FileName="";
	FileName=args[0];
	String filename="";
	int size=Integer.parseInt(args[1]);
	int core=Integer.parseInt(args[2]);
	int threads=Integer.parseInt(args[3]);
	if(threads==1)
	filename= "CSV"+String.valueOf(5) +".csv";
	else if(threads==4)
	filename= "CSV"+String.valueOf(6) +".csv";
	else if(threads==8)
	filename= "CSV"+String.valueOf(7) +".csv";
	else if(threads==12)
	filename= "CSV"+String.valueOf(8) +".csv";
	else if(threads==16)
	filename= "CSV"+String.valueOf(9) +".csv";
	else 
	System.out.println("unable to create file");
    FileWriter fw = new FileWriter(filename,true); //the true will append the new data	
	List<String> dtd_elements = new ArrayList<>();
	Abcd obj=new Abcd();
	String FileName1="";
	FileName1="dtd_emp.txt";
	dtd_elements=obj.mycode(FileName1);
	String ss = new String(Files.readAllBytes(Paths.get(FileName)));
	    //	System.out.println(ss.lines().count());
	//for(int k=0; k<dtd_elements.size(); k++)
	 //     System.out.println(dtd_elements.get(k));
long startTime = System.nanoTime();
String value_underrootnode="";
long lines =ss.lines().count();
int str_length=ss.length();  
			int cores=threads;// actually representing chunk(s)
                  	int n=ss.length()/cores;
                       int v;
                   	String[] str_part=new String[cores];
                   	
                   	List<String> str_token = new ArrayList<String>();
                   for(v=0; v<cores-1; v++)
                   {
                   str_part[v]=ss.substring(n*v,n*(v+1));
                   }
                   str_part[v]=ss.substring(n*(cores-1),str_length-1);
                 //  for(v=0; v<cores; v++)
                   //  System.out.println("111111111111111111111111111111:"+str_part[v]);              
                      for(v=0; v<cores-1; v++)
                      {
                    //  System.out.println("111111111111111111111111111111");
                     StringTokenizer sstt2 = new StringTokenizer(str_part[v+1],"\n"); 
                   	String sssstttt=sstt2.nextToken();
                   	str_token.add(sssstttt);
                   //	System.out.println("2222222222222222222222222222222222"+sssstttt);
                      }  
              //           System.out.println("111111111111111111111111111111"+str_token);          
                  
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

//System.out.println("size tree1..."+target1.treeRootNode.children.get(0).getId());
//System.out.println("size tree2..."+target2.treeRootNode.children.get(0).children.size());

//System.out.println("size tree1..."+target1.treeRootNode.children.size());
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


long endTime = System.nanoTime();
long durationInNano = (endTime - startTime);
System.out.println("Execution Time : " +durationInNano);
fw.write(size+","+core+","+durationInNano+"\n");//appends the string to the file
 fw.close();
} // end try
catch (Exception e) {
         e.printStackTrace();
      }
 }// end main
 }// end class TreeDemo1.java

