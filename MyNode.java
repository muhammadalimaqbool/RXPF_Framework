package Tre;
import encode.*;
import java.util.ArrayList;
import java.util.List;
 
public class MyNode {
 private String id;
 private Callme cm;
 //private final List<MyNode> children = new ArrayList<>();
public List<MyNode> children = new ArrayList<>();
 public MyNode parent;
 public MyNode(MyNode parent, Callme cm) {
  this.parent = parent;
  this.cm = cm;
//System.out.println(parent);
 }
 
 public String getId() {
  return id;
 }
 public Callme getCallme() {
   return cm;
 }
 
 public void setId(String id) {
  this.id = id;
 }
 
 public List<MyNode> getChildren() {
  return children;
 }
 
 public MyNode getParent() {
  return parent;
 }
 public MyNode itemm(int x)
	{
	//p=x;
	//nMyNode= new MyNode(null,this);
	//nMyNode=treeRootMyNode.children.get(x);
	
	return this.children.get(x);
	}
 
}
