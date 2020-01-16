# Java EE 7 demonstrator

This project provides examples for Java EE components interactions 
between 2 EAR  (tested with JBoss EAP 7.1)

This project uses some EJB located in "calculator-parent" project.


### hello-ear
The EAR packaging containing 
- 1 EJB
- 1 WAR 


### hello-jar-ejb
Contains a local **Hello Singleton EJB**  with local interface


### hello-war-add
Very simple Web Application using remotely the **Calculator EJB** located in an external EAR
-  "count" servlet : use Calculator / getCallCounter() with annotation "@EJB(lookup=xx)"
-  "add" servlet : use Calculator / getCallCounter() with "JNDI lookup"
