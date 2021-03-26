Authenticated web page for Two Dog Brewery using the Spring Boot framework.
MVC-architecture using Mybatis mappers and a MySQL database.
View is static with use of html-templates with thymeleaf.
The beer table is populated using a web-scraping script that scrapes all-grain brew packages from bryggselv.no available as an endpoint.

Dependencies:
  pip install bs4
  pip install flask
  sdk install maven

 
To run:
  navigate to directory: [path_to_directory]/twoDog/ 
  python3 scrape_bryggselv.py
  mvn spring-boot:run
  
