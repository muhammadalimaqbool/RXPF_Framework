 package Pqr;
 import java.util.*;
 import java.io.IOException;
 import java.util.ArrayList;
import java.util.List;
 import java.io.*;
 
 public class Abcd 
{  
     
//public List<String>[] li= new ArrayList[20];
public List<String> child_elements = new ArrayList<>();
public int g;
public int i,j,k,l,m,p;
public String value_underrootnode="";
public StringBuffer stringb = new StringBuffer();
public StringBuffer sbb = new StringBuffer();
public String str1="",str2="",str3="";
public int u;
int count_child=0;
int FIRST = 1,START_OF_TAG=2,FIRST_LINE=3,OPEN_TAG=4,COLLECT_CHILD=5,WORKING=6;
int flag=-1;
int mode=FIRST;
int elements=-1;
int f;
String parent_node="";
String root_node="";
String ssss="";
String string_part="";

          public Abcd()
          {
        	
          }
        
	public Abcd GetParsedData(String name1)  
	{  
		
		//u=child_elements.size();
		//System.out.println(u); 
		for(int h=0; h<child_elements.size(); h++)
		{
			if(child_elements.get(h).equals(name1))
			{
			i=h;
			//System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxx"+i);
			}
		}
		return this;
		
	}  
	public Abcd itemm(int x)
	{
	p=x;
	return this;
	}
	public String getdata()
	{
	//System.out.println("itemm working"+i); 
	return "";
	}
	public void AddData()
	{
	// Add elements to the array list.
	/*li[0].add("apple");
	li[0].add("mango");
	li[0].add("orange");
	li[0].add("banana");
	li[1].add("red");
	li[1].add("green");
	li[1].add("blue");
	li[1].add("pink");
	li[2].add("aaaaa");
	li[2].add("bbbbb");
	li[2].add("ccccc");
	li[2].add("ddddd");*/
	//mycode();
	}
	public List<String> mycode(String FileName)
	{
	
 //////////////////////////////////////to find number of lines//////////////////////
 
try (LineNumberReader rdr = new LineNumberReader(new FileReader(FileName))) {
        
        for (String line = null; (line = rdr.readLine()) != null;) {

            stringb.append(line);
        }
    } 
catch(IOException ioe)
{
    System.err.println("IOException: " + ioe.getMessage());
}


//System.out.println(string_part);
string_part=stringb.toString();
f=stringb.toString().length();


for(int i=0; i<f;i++){  
        char cc = string_part.charAt(i);
if(mode==FIRST)                 //ignoring ascii code 10 for carriage return
{
	if(cc=='<')
	{
	mode=START_OF_TAG;
	sbb.setLength(0);
	//System.out.println("bbbbbbbbbbbbbbb");
	}
} 					//PRE FIRST
else if(mode==START_OF_TAG)
{
	if(cc=='<')
	{
	mode=START_OF_TAG;
	sbb.setLength(0);
	//System.out.println("bbbbbbbbbbbbbbb");
	}
	else if(cc==' ')
	{
		//System.out.println("bbbbbbbbbbbbbbb");
		//System.out.println(sbb.toString());
		if(sbb.toString().equals("!DOCTYPE"))
		{
		//System.out.println("aaaaaaaaaaaaaaaaaaaaaa");
		mode=WORKING;
		sbb.setLength(0);
		}
		else if(sbb.toString().equals("!ELEMENT"))
		{
		//System.out.println("aaaaaaaaaaaaaaaaaaaaaa");
		mode=WORKING;
		sbb.setLength(0);
		}
	}
	else
	{
	sbb.append((char)cc);
	//System.out.println(sbb.toString());
	mode=START_OF_TAG;
	}
}					
else if(mode==WORKING)		
{
	if(cc==' ')
	{
		child_elements.add(sbb.toString());
	parent_node=sbb.toString();
	//System.out.println(parent_node);
	sbb.setLength(0);
	mode=WORKING;
	}
	else if(cc=='[')
	{
		child_elements.add(sbb.toString());
	root_node=sbb.toString();
	//System.out.println(root_node);
	sbb.setLength(0);
	mode=START_OF_TAG;
	}
	else if(cc=='(')
	{
	mode=COLLECT_CHILD;
	sbb.setLength(0);
	}
	else
	{
	sbb.append((char)cc);
	mode=WORKING;
	}
}
else if(mode==COLLECT_CHILD)	
{
	if (cc==',')
	{
	child_elements.add(sbb.toString());
	sbb.setLength(0);
	mode=COLLECT_CHILD;
	}
	else if(cc==')')
	{
	child_elements.add(sbb.toString());
	//Array_of_Arraylist(child_elements.size());
	break;
	}
	else
	{
	sbb.append((char)cc);
	mode=COLLECT_CHILD;
	}
}
	
else
System.out.println("invalid");
//return child_elements;
}// while end
//System.out.println(child_elements.get(0));
//System.out.println(child_elements.get(1));
//System.out.println(child_elements.get(2));
//System.out.println(child_elements.get(3));
/*li[child_elements.size()] = new ArrayList<String>();
        	for (g=0; g<child_elements.size(); g++) 
            li[g] = new ArrayList<String>();
            return this;*/
            return child_elements;
	} ///   ending mycode()
}  

