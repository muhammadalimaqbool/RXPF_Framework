javac DomParserDemo.java
incr=0
fname=("emp.txt" "emp1MB.txt")
for X in $fname
do
incr=$((incr+5))
taskset -c 0 java DomParserDemo $X $incr 1
for i in {1,3,5,7,9,11,13,15}
	do
 	j=$((i+1))
 	taskset -c 0-$i java DomParserDemo $X $incr $j
	done
done
javac SAXParserDemo.java
incr=0
for X in $fname
do
incr=$((incr+5))
taskset -c 0 java SAXParserDemo $X $incr 1
for i in {1,3,5,7,9,11,13,15}
	do
 	j=$((i+1))
 	taskset -c 0-$i java SAXParserDemo $X $incr $j
	done
done
javac StAXParserDemo.java
incr=0
for X in $fname
do
incr=$((incr+5))
taskset -c 0 java StAXParserDemo $X $incr 1
for i in {1,3,5,7,9,11,13,15}
	do
 	j=$((i+1))
 	taskset -c 0-$i java StAXParserDemo $X $incr $j
	done
done
javac JDomParserDemo.java
incr=0
for X in $fname
do
incr=$((incr+5))
taskset -c 0 java JDomParserDemo $X $incr 1
for i in {1,3,5,7,9,11,13,15}
	do
 	j=$((i+1))
 	taskset -c 0-$i java JDomParserDemo $X $incr $j
	done
done
javac PXPQParsing.java
incr=0
for X in $fname
do
incr=$((incr+5))
taskset -c 0 java PXPQParsing $X $incr 1 1
for i in {1,3,5,7,9,11,13,15}
	do
 	j=$((i+1))
 	taskset -c 0-$i java PXPQParsing $X $incr $j 1
	done
done
javac PXPQParsing.java
incr=0
for X in $fname
do
incr=$((incr+5))
taskset -c 0 java PXPQParsing $X $incr 1 4
for i in {1,3,5,7,9,11,13,15}
	do
 	j=$((i+1))
 	taskset -c 0-$i java PXPQParsing $X $incr $j 4
	done
done
javac PXPQParsing.java
incr=0
for X in $fname
do
incr=$((incr+5))
taskset -c 0 java PXPQParsing $X $incr 1 8
for i in {1,3,5,7,9,11,13,15}
	do
 	j=$((i+1))
 	taskset -c 0-$i java PXPQParsing $X $incr $j 8
	done
done
javac PXPQParsing.java
incr=0
for X in $fname
do
incr=$((incr+5))
taskset -c 0 java PXPQParsing $X $incr 1 12
for i in {1,3,5,7,9,11,13,15}
	do
 	j=$((i+1))
 	taskset -c 0-$i java PXPQParsing $X $incr $j 12
	done
done
javac PXPQParsing.java
incr=0
for X in $fname
do
incr=$((incr+5))
taskset -c 0 java PXPQParsing $X $incr 1 16
for i in {1,3,5,7,9,11,13,15}
	do
 	j=$((i+1))
 	taskset -c 0-$i java PXPQParsing $X $incr $j 16
	done
done
javac RXPF.java
java RXPF emp1MB.txt 1 1
javac RXPFParser.java
java RXPFParser 
