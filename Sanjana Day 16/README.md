Contact Manager (Sprint 2) - Ready to submit

How to run:
1. Build: mvn package
2. Deploy the generated WAR (target/contact-manager.war) to a Servlet container (Tomcat 9+).
3. Configure a JDBC DataSource named java:comp/env/jdbc/ContactDB in Tomcat, or run with system properties:
   -Djdbc.url=jdbc:mysql://localhost:3306/contactdb -Djdbc.user=dbuser -Djdbc.pass=dbpass
4. Create the 'contacts' table (SQL provided below) and start the webapp.

SQL:
CREATE TABLE contacts (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(150),
  phone VARCHAR(30),
  address VARCHAR(255),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
