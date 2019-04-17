# dating

This is an app collect data from dating apps, it is not exactly like a dating app per se 

I coded this in Eclipse, therefore, there are couple things you will have to set up 

#set up
## environment 
This program only works with Apache 9.0.12
You will have to make sure that you added your server before you run the programm 

There are couple jar files that's essential in order to have the program run correctly: 
* JSTL files 
	* jstl-1.2.jar
	* taglibs-standard-impl-1.2.5.jar
* mysql-connector-java-8.0.12.jar 

All the above files have to be imported into your project before you start running anything. All of those files are in folder "set_up_env"

Before you import the whole project into your Eclipse, please make sure that you removed the set_up_env folder. 

Running on java run time 1.8 

## database connector 
This is currently working with mysql database 

make sure that you changed connector to connect with your own database you have on your local machine 

Steps: 
1. Go to Java Resources --> src/main/java --> org.decision.config --> WebMvcConfig.java
2. Under DriverManagerDataSource, please change the following: 
* setUrl--> please set it to be the same as your database name  
* setUsername --> your database username 
* setPassword --> your database password 

THE MOST IMPORTANTLY: PLEASE MAKE SURE YOUR DATABASE IS RUNNING 

It is always a good idea to run the following before you actually start running the project  
Maven clean
Update project 

# run project 
Right click on the project, then do Run As --> Run on Server 
