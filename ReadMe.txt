RXPF Execution
---------------------
Step 1--> Add jar files to CLASSPATH
Step 2--> Execute RXPF.sh
Step 3--> For your customized XML file change XML_FILE_NAME, FILE_SIZE and NUMBER_OF_CORES in RXPF.sh file 

RXPF Working Mechanism
-----------------
The RXPF Framework performs profiling, regression and based on regression, generates an efficient parsing code in RXPFParser.java. This code is also being compiled and executed for efficient parsing of XML file. For further details see the contents of the paper "Performance Enhancement of XML Parsing using Regression and Parallelism"
