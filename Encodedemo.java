package encode;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class Encodedemo implements Runnable{
public Callme target;
boolean initialize;
public Thread t;
int Id;
long lines;
String DD;
List<String> dtd_elements = new ArrayList<>();
public Encodedemo(Callme targ,int ID,String dd,List<String> dtd_ele,boolean ini) {
target = targ;
DD=dd;
initialize=ini;
dtd_elements=dtd_ele;
Id=ID;
t = new Thread(this);
t.start();
}
public void run() {
target.abcencode(Id,DD,initialize,dtd_elements);
}
} //class end

