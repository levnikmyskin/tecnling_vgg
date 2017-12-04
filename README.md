# EuporiaModules
## Exam project for Molinari, Pedrotti, Rambelli.

Technologies used:
* Java SDK, version 1.8 (Java 8)
* Java EE 7
* Java Server Faces 2.2
* [ANTLR](http://www.antlr.org/) 
* Deployed on GlassFish under Apache under Nginx as a proxy

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

### GlassFish configuration for running and debugging project locally:
* Download GlassFish zip from javaee.github.io website http://download.oracle.com/glassfish/5.0/release/glassfish-5.0-web.zip 
* Extract the archive somewhere appropriate;
* In the upper menu of the IDE, click on run -> edit configurations;
* Click on the + (plus) sign to add a new method and select GlassFish server -> local (if it's not available verify that it is enabled in the plugins settings, or look for it in the Defaults section);
* On the application server section, click on Configure, then select the extracted GlassFish folder as the GlassFish home;
* In the Open browser section use http://localhost:8080/retoricaweb/index.jsf as a default;
* In deployment tab, make sure there is the retoricaweb:war under "Deploy at the server startup" (if you cannot find it, try adding it or simply click on apply -> Ok and then reopen the configuration window; Intellij should give you an error with a "Fix" button, click it;
* In deployment tab, check "use custom context root" and type "/retoricaweb" -> apply -> ok;
* Try running the project


