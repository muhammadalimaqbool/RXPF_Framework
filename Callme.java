package encode;
import Tre.MyNode;
import Pqr.Abcd;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;
import java.util.Scanner;
import java.util.regex.*;
import java.util.StringTokenizer;  
import java.util.Hashtable;
import java.util.Enumeration;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileReader;
import java.nio.file.Files;

import java.nio.file.Paths;
public class Callme{
public Hashtable hh =new Hashtable();
Hashtable hh2 =new Hashtable();
Enumeration ee;
Enumeration ee2;
public Stack<String> mystack1 = new Stack<>();
public int count_rec=0;
int count_rec2=0;
int keyy=1;
int keyy2=1;
String val;   
String val2; 
int cc = 0;
public int ppp=11;
int tag_in_tag=0;     //if a tag inside starting tag
String str1="",str2="",str3="";

StringBuffer sbb = new StringBuffer();
StringBuffer total_buffer = new StringBuffer();

private final int FIRST = 1,START_OF_TAG=2,FIRST_LINE=3,OPEN_TAG=4,END_TAG=5,BETWEEN_TAG=6;
int flag=-1,keyflag=-1;

public MyNode CurrentNode;
public MyNode PreviousNode;
public MyNode PreviousPreviousNode;
public MyNode ValueNode; 
public MyNode treeRootNode;
public MyNode temptreeRootNode;
public MyNode TopParentNode;
public MyNode NodeUnderRoot;
public MyNode childTreeRootNode;
public MyNode tempchildTreeRootNode;
public MyNode nnode;
public MyNode tempParentNode;

public int t=-1;
public int ss=0; 
public int j,k,l,m,p;
public char chh=' ';
public int datanode=-1;
public int start_tag_flag=0;
public String storedatanode="";
int normal_tag=-1;
int size;
Stack<String> stackpart = new Stack<>();
public Stack<String> stackremaining = new Stack<>();
public	List<String> dtd_data = new ArrayList<>();
public	List<String> value = new ArrayList<>();
Stack<String> stackremaining1 = new Stack<>();
Stack<String> stackinorder = new Stack<>();

String value_underrootnode="";
String rootvalue="";
String startvalueofpart;

public Stack<String> PreTag = new Stack<>();
String pre="";
String curr="";
String pre_tag="";
String curr_tag=""; 
String root="",tempstring="",stringtemp="";
String temp_pretag="";
public String rootnode="",childofrootnode="";
int dummy=0;
int i,ii=1;
public int counter=0;
public int datacounter=0;
//public int employee_counter=0;
public int emp_count=0;
boolean Initialize;
StringBuffer strb_RootNode;
StringBuffer strb_ChildofRootNode;
String Root_Node;
String Child_of_Root_Node;
int flag_grandchild=0;
int flag_endatstart=0;
//public String temp_DD="";
  
	public StringBuffer stringb1 = new StringBuffer();
        public StringBuffer stringb2 = new StringBuffer();
	public StringBuffer stringb3 = new StringBuffer();
	public StringBuffer stringb4 = new StringBuffer();
	
//public void abcencode(int Id,int l1,String Filename,boolean init)
public void abcencode(int Id,String DD,boolean init,List<String> dtd_d) //throws Exception 
{

Initialize=init;
dtd_data=dtd_d;

//for(int k=0; k<dtd_data.size(); k++)
	   //   System.out.println(dtd_data.get(k));

treeRootNode = new MyNode(null, this);
TopParentNode= new MyNode(null, this);
int f=0;
String string_part="";
String temp_DD="";
int mode=FIRST;
StringBuffer strb_RootNode = new StringBuffer(dtd_data.get(0));
		strb_RootNode.insert(0, "<");
		strb_RootNode.insert(dtd_data.get(0).length()+1, ">");
		Root_Node=strb_RootNode.toString();
StringBuffer strb_ChildofRootNode = new StringBuffer(dtd_data.get(1));
		strb_ChildofRootNode.insert(0, "<");
		strb_ChildofRootNode.insert(dtd_data.get(1).length()+1, ">");
		Child_of_Root_Node=strb_ChildofRootNode.toString();
		//System.out.println("tttttttttttttt"+Child_of_Root_Node);
if(Id==0)
{
//temp_DD=DD;
string_part=DD;
f=DD.length();

}
if(Id!=0)
{
string_part=DD;
f=DD.length();
treeRootNode.setId(Root_Node);
childTreeRootNode= addChild(treeRootNode, Child_of_Root_Node);
counter++;
emp_count++;

}
/*if(Id==2)
{
string_part=DD;
f=DD.length();
treeRootNode.setId(Root_Node);
childTreeRootNode= addChild(treeRootNode, Child_of_Root_Node);
counter++;
emp_count++;

}
if(Id==3)
{
string_part=DD;
f=DD.length();

treeRootNode.setId(Root_Node);
childTreeRootNode= addChild(treeRootNode, Child_of_Root_Node);
counter++;
emp_count++;

}*/

for(int i=0; i<f;i++){  
        char cc = string_part.charAt(i);
      //  char temp_ch=temp_DD.charAt(i);
        //if(temp_ch==10)
	//System.out.println(cc);
	if (cc==10 || cc==13)
	  continue;
if(mode==FIRST)                 //ignoring ascii code 10 for carriage return
{
	if(cc=='<')
	{
	tag_in_tag=1;
	sbb.append((char)cc);
	mode=START_OF_TAG;
	}
	
} 					//PRE FIRST
else if(mode==START_OF_TAG)
{
	if(cc=='?')
	{
	sbb.append((char)cc);
	mode=FIRST_LINE;
	}
	else if(cc=='/')
	{
	//tag_in_tag=0;
	sbb.append((char)cc);
	//flag_endatstart++;
	mode=END_TAG;
	}
	else
	{
	sbb.append((char)cc);
	mode=OPEN_TAG;
	}
}					//START_OF_TAG END
else if(mode==FIRST_LINE)
{
sbb.append((char)cc);
	if(cc=='>')
	{
	sbb.setLength(0);
	mode=FIRST;
	}
}					//FIRST_LINE END
else if(mode==OPEN_TAG)
{
	if(cc=='>')
	{
	flag_grandchild++;
	sbb.append((char)cc);
	str1="";
	str1=sbb.toString();
	//counter_one++;
	if((str1.equals(Child_of_Root_Node))&&(flag_grandchild==1))
	{
	sbb.setLength(0);
	continue;
	}
	
//	example(str1);	
	StartTag(str1,Id);		
	sbb.setLength(0);
	mode=BETWEEN_TAG;
	}
	else
	sbb.append((char)cc);
}					//OPEN_TAG END
else if(mode==BETWEEN_TAG)
{
	if(cc=='<')
	{
	str2=sbb.toString();
	//System.out.println("..........................."+str2+"........................................");				
 			//getting values between tag
	if(str2.length()!=0)     //to controlling nested starting tags
//		example(str2); 
		BetweenTag(str2,Id);
		if(str2.length()!=0) 
//		System.out.println(str1+":"+str2);	
		//if(str2.length()!=0)
		//total_buffer.append(str1+"....."+str2+"\n");        
		sbb.setLength(0);
	sbb.append((char)cc);
	mode=START_OF_TAG;
	}
	else
	sbb.append((char)cc);
}					//BETWEEN_TAG END
else if(mode==END_TAG)
{
	if(cc=='>')
	{
	flag_endatstart++;
	sbb.append((char)cc);
	str3=sbb.toString();
//		example(str3);	
	//System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"+str3.substring(2,str3.length()-1));
	if((str3.substring(2,str3.length()-1).equals(dtd_data.get(1)))&&(flag_endatstart==1))
	{
	sbb.setLength(0);
	//flag_grandchild=0;
	//System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"+flag_grandchild);
	mode=FIRST;
	continue;
	}
		//EndTag(str3,Id);		
//System.out.println(str1+"............"+str2+"..................."+str3);
	str1=str2=str3="";
	sbb.setLength(0);
	mode=FIRST;
	}
	else
	sbb.append((char)cc);
}					//END_TAG			
else
System.out.println("invalid");


}// while end
 
//String comp_string=total_buffer.toString();
//System.out.println(comp_string);

}//function ending

public void StartTag(String temp_token,int ID)
{

String tempstr=temp_token;
//System.out.println("tempstr=" + tempstr);
if(ID==0)
	{
	if(dtd_data.get(0).equals(tempstr.substring(1,tempstr.length()-1)))
	{
	//System.out.println("****************************************************");
	treeRootNode.setId(tempstr);
	//temptreeRootNode=treeRootNode;
	//counter++;
	}
	else if(dtd_data.get(1).equals(tempstr.substring(1,tempstr.length()-1)))
	{
	childTreeRootNode=addChild(treeRootNode, tempstr);
	emp_count++;
	}
	else 
	{
	CurrentNode=addChild(childTreeRootNode, tempstr);
	}
	}
else
	{
	if(dtd_data.get(1).equals(tempstr.substring(1,tempstr.length()-1)))
	{
	childTreeRootNode=addChild(treeRootNode, tempstr);
	emp_count++;
	}
	else 
	{
		String strtemp="";
		if((dtd_data.get(5).equals(tempstr.substring(1,tempstr.length()-1)))&&(counter==1))
		{
		CurrentNode=addChild(childTreeRootNode, "<name>");
		addChild(CurrentNode, "name1");
		CurrentNode=addChild(childTreeRootNode, "<age>");
		addChild(CurrentNode, "age1");
		CurrentNode=addChild(childTreeRootNode, "<role>");
		addChild(CurrentNode, "role1");
		CurrentNode=addChild(childTreeRootNode, tempstr);
		counter++;
		datacounter=3;
		}
		else if((dtd_data.get(4).equals(tempstr.substring(1,tempstr.length()-1)))&&(counter==1))
		{
		CurrentNode=addChild(childTreeRootNode, "<name>");
		addChild(CurrentNode, "name1");
		CurrentNode=addChild(childTreeRootNode, "<age>");
		addChild(CurrentNode, "age1");
		CurrentNode=addChild(childTreeRootNode, tempstr);
		counter++;
		datacounter=2;
		}
		else if((dtd_data.get(3).equals(tempstr.substring(1,tempstr.length()-1)))&&(counter==1))
		{
		CurrentNode=addChild(childTreeRootNode, "<name>");
		addChild(CurrentNode, "name1");
		CurrentNode=addChild(childTreeRootNode, tempstr);
		counter++;
		datacounter=1;
		}
		else
		{
		CurrentNode=addChild(childTreeRootNode, tempstr);
		counter++;
		//datacounter=0;
		//System.out.println("name misssing"+counter);
		}
	}
	}	
}
public void BetweenTag(String temp_token,int ID)
{
if(ID==0)
	{
	addChild(CurrentNode, temp_token);
	datacounter++;
	value.add(temp_token);
	if(datacounter==4)
	{
	value.removeAll(value);
	datacounter=0;
	}
	}
else
	{
	addChild(CurrentNode, temp_token);
	datacounter++;
	value.add(temp_token);
	if(datacounter==4)
	{
	value.removeAll(value);
	datacounter=0;
	}
	}
}
public void EndTag(String temp_token,int ID)
{
String tempstr=temp_token;
if(ID==0)
	{
	if(dtd_data.get(1).equals(tempstr.substring(2,tempstr.length()-1)))
	{
	childTreeRootNode=addChild(treeRootNode, tempstr);
	}
	else 
	{
	CurrentNode=addChild(childTreeRootNode, tempstr);
	}
	}
else
	{
	if(dtd_data.get(0).equals(tempstr.substring(2,tempstr.length()-1)))
	{
	//System.out.println("****************************************************");
	
	}
	else if(dtd_data.get(1).equals(tempstr.substring(2,tempstr.length()-1)))
	{
	childTreeRootNode=addChild(treeRootNode, tempstr);
	}
	else 
	{
	CurrentNode=addChild(childTreeRootNode, tempstr);
	}
	}
}


private MyNode addChild(MyNode parent, String id) {
   MyNode node = new MyNode(parent,this);
   node.setId(id);
//System.out.println("called" + Thread.currentThread() + "with parent=" + parent + " id=" + id + " idl=" + id.length());
 //  try{parent.getChildren().add(node);}catch(Exception e){System.out.println(e); System.out.println("Parent:"+parent);System.exit(0);}
 parent.getChildren().add(node);
   return node;
 }
public void printTree(MyNode node, String appender) {
  System.out.println(appender + node.getId());
 	for(int b=0; b<node.children.size(); b++)
		 printTree(node.children.get(b), appender + appender);
 }
 public void setname()
 {
 
 }
 public MyNode GetParsedData(String name1)  
	{  
		
		//u=child_elements.size();
		//System.out.println(u); 
		for(int h=2; h<dtd_data.size(); h++)
		{
			if(dtd_data.get(h).equals(name1))
			{
			m=h-2;
			//System.out.println("xxxxxxxxxxxjhhjhxxxxxxxxxxxxxx"+m);
			}
		}
		//System.out.println("in GetParsedData................."+nnode.children.get(m).children.get(0).getId());
		return nnode.children.get(m);
		
	}  
	public MyNode itemm(int x)
	{
	p=x;
	nnode= new MyNode(null,this);
	nnode=this.treeRootNode.children.get(x);
	
	return nnode;
	}
 public void printchild(MyNode node)
 {
 //for(int y=0; y<node.children.size(); y++)
//System.out.println("cccccccccccccccccc"+node.children.get(y).getId());
//for(int y=0; y<node.children.get(0).children.size(); y++)
System.out.println("cccccccccccccccccc"+node.children.get(0).children.get(0).children.get(0).getId());
System.out.println("cccccccccccccccccc"+node.children.get(0).children.get(1).children.get(0).getId());
System.out.println("cccccccccccccccccc"+node.children.get(0).children.get(2).children.get(0).getId());
System.out.println("cccccccccccccccccc"+node.children.get(0).children.get(3).children.get(0).getId());
 }
public void example2(String ssstttrrr)
{
System.out.println(".................................22222222222222222222"+ssstttrrr);
}
}//class ending

