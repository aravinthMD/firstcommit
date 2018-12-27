
## create maven project

```
mvn archetype:generate -DgroupId=com.kg.webapp1 -DartifactId=webapp1 -DarchetypeArtifactId=maven-archetype-webapp1 -DinteractiveMode=false
```
## Add tomcat and shade plugin
## Add tomcat and shade plugin
## Add tomcat and shade plugin
```
<plugins>
      <plugin>
        <groupId>org.apache.tomcat.maven</groupId>
        <artifactId>tomcat7-maven-plugin</artifactId>
        <version>2.2</version>
        <configuration>
          <port>9090</port>
          <path>/</path>
        </configuration>
      </plugin>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-shade-plugin</artifactId>
        <version>3.1.0</version>
        <configuration>
          <!-- put your configurations here -->
        </configuration>
        <executions>
          <execution>
            <hpase>package</phase>
            <goals>
              <goal>shade</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
    </plugins>
```
## Run your application
```
mvn clean install
mvn tomcat7:run
```

```
http://localhost:9090/
```
## Add Servlet dependencies
```
<dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>javax.servlet-api</artifactId>
        <version>3.1.0</version>
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>javax.servlet.jsp</groupId>
        <artifactId>javax.servlet.jsp-api</artifactId>
        <version>2.3.1</version>
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>jstl</groupId>
        <artifactId>jstl</artifactId>
        <version>1.2</version>
    </dependency>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
```
## Create packages
```
\src\main\java\com\kg\webapp1
```
## Create servlet file
```
HelloServlet.java

```

```
extends HttpServlet
```
## Write doGet method
```
@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String msg="Hi Swathi !!!";
        System.out.println(msg);

        req.setAttribute("message", msg);        
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }
```
## Mapping servlet in web.xml
```
<servlet>
    <servlet-name>s1</servlet-name>
    <servlet-class>com.kg.webapp1.HelloServlet</servlet-class>
  </servlet>

  <servlet-mapping>
    <servlet-name>s1</servlet-name>
    <url-pattern>/hello</url-pattern>
  </servlet-mapping>
```
## Link HelloServlet in index.jsp
```
<a href="/hello">Helloservlet</a>

${message}
```
## Update webapp servlet specification
```
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns="http://xmlns.jcp.org/xml/ns/javaee"
    xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
        http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
    id="WebApp_ID" version="3.1">

```
## Run your Application
```
mvn clean install
mvn tomcat7:run
```

```
http://localhost:9090/
```
## Post form values to HelloServlet doPost method
```
<form action="/hello" method="post">
<input type="text" name="name" id="name">
<input type="submit" value="save">
</form>
Welcome ${name}
```
## Get form controls value in HelloServlet
```
@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String name = req.getParameter("name");
        System.out.println(name);

        req.setAttribute("name", name);        
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }
```
## Run Your Application
```
```
mvn clean install
mvn tomcat7:run
```

```
http://localhost:9090/
```
```
## References
```
https://www.mkyong.com/maven/how-to-create-a-java-project-with-maven/
https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html
https://en.wikipedia.org/wiki/Java_servlet
https://www.splessons.com/lesson/http-servlets/
https://www.codejavanet/coding/jsp-servlet-jdbc-mysql-create-read-update-delete-crud-example
```