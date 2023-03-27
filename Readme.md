Create a MySQL database with the following table:
CREATE TABLE users (
  id INT(11) AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  age INT(3) NOT NULL
);
![image](https://user-images.githubusercontent.com/42664032/227965464-376871e5-4604-434b-85c0-42b3bad34712.png)



In this diagram, the user interacts with the application through their web browser, which sends an HTTP request to the Java Servlet. The Servlet receives the request, extracts the user's data, validates it, and then stores it in the MySQL database. The Servlet then forwards the request to the JSP page, passing the user's data as attributes of the request object. The JSP page generates a web page that includes the user's data and sends it back to the user's browser as an HTTP response.


![image](https://user-images.githubusercontent.com/42664032/227965090-dbddd1a0-918e-46bd-8390-e4d34514ba9b.png)



