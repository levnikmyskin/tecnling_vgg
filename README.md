# EuporiaModules
## Exam project for Molinari, Pedrotti, Rambelli.

Technologies used:
* Java SDK, version 1.8 (Java 8)
* Java Server Faces with [ICEFaces](http://www.icesoft.org/java/home.jsf)
* [ANTLR](http://www.antlr.org/) 
* Deployed on Tomcat under Apache under Nginx as a proxy

IDE:
Intellij Idea Ultimate Edition


### To open the retoricaweb project with Intellij Idea:
* Start Intellij Idea;
* Click on "Open project" (or similar);
* Locate the file "pom.xml" into the retoricaweb folder;
* Select it and open it as a project;
* Once Intellij is done loading, right click on the root folder of the project (retoricaweb) and click on "Open module settings";
* Go to Artifacts, verify that no error is shown and check the "Include in project build" checkbox (if it is not checked already);
* Build the project, you should get a retoricaweb.war file in the target directory;
* If you cannot build succesfully, try installing Maven on your operating system.

### Tomcat configuration for running and debugging project locally:
* Download Tomcat tar.gz (Linux/Mac) archive under binary distributions from apache website https://tomcat.apache.org/download-80.cgi;
* Extract the archive somewhere appropriate;
* In the upper menu of the IDE, click on run -> edit configurations;
* Click on the + (plus) sign to add a new method and select Tomcat server -> local (if it's not available verify that it is enabled in the plugins settings);
* On the application server section, click on Configure, then select the extracted tomcat folder as the Tomcat home;
* In the Open browser section use http://localhost:8080/retoricaweb/index.jsf as a default;
* On deployment tab, make sure there is the retoricaweb:war under "Deploy at the server startup" (if you cannot find it, try adding it or simply click on apply -> Ok and then reopen the configuration window; Intellij should give you an error with a "Fix" button, click it;
* Try running the project


