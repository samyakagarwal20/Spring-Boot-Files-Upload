# Spring-Boot-Files-Upload
It is a sample spring boot application to demonstrate working and implementation of dealing with files upload and download


### Prequisites for running the application:

---
Please make sure to have an active instance of MySQL DB running on your system before starting the application.

In case, if you don't have MySQL installed on your system then you could also simply run a container from the mysql image (taken from DockerHub) using the following command:

```docker run --name mysqldb -p 3306:3306 -e MYSQL_ROOT_PASSWORD=password -d mysql```

Once the container is in running state (which you could verify either using docker desktop app or using the command ```docker ps```), you can make use of MySQL Workbench to validate the connection with your running container on port **3306**.

The password specified for mysql DB **root** acoount is **password** :)

---
Once we are done with validating the connection, we need to create the target database as pracDB (the name of the database which I am using in my application).

We can do it either by using MySQL Workbench or by executing the following command in console

```docker exec -it mysqldb mysql -u root -p```

This command prompts for the root password which we specified at the time of running the container. After entering the correct credentials, we get the access to the mysql client where we can execute the SQL query as ```create database pracDB```

We could also create the database with some other name but make sure to change the **spring.datasource.url** property accordingly in application.yaml file.

---
In this method, we have explicitly defined a datasource and a corresponding JdbcTemplate object to perform the setup by referring to the properties defined in the application.yaml file.

The configuration are done within the file **JDBCConfig.java**

---
## Using Multipart File Upload in Spring Boot

A multi-part file, also known as multi-part form data, is a type of HTTP request which allows us to upload the files along with the form fields in a single HTTP request.

```MultipartFile``` is an interface in Spring Framework that represents an uploaded file received in a multipart request. It is used to handle file uploads in web applications, typically in scenarios where users can submit files through HTML forms. This interface provides methods to access the properties and content of the uploaded file.

The following are some of the key methods provided by the MultipartFile interface:

* ```String getOriginalFilename()```: Returns the original filename of the uploaded file.
* ```String getName()```: Returns the name of the form field associated with this file upload.
* ```String getContentType()```: Returns the content type of the uploaded file.
* ```boolean isEmpty()```: Checks if the uploaded file is empty.
* ```long getSize()```: Returns the size of the uploaded file in bytes.
* ```byte[] getBytes()```: Returns the content of the uploaded file as a byte array.
* ```InputStream getInputStream()```: Returns an InputStream to read the content of the uploaded file.
* ```void transferTo(File dest) throws IOException```: Transfers the uploaded file to the specified destination file on the server's filesystem.

---
## Overview of this application

When dealing with files, for example, images, we have 2 approaches that we can go for:

1. Storing the image into the DB
    - we will compress the file to store it into the DB
    - we will decompress the file while retrieving it from DB
    - this approach deals with more security for the file
    - since the file will be stored into the DB over a network, thus, it will certainly have a delay

2. Storing the image into a file system
    - we will store the file to the file system
    - Along with that,we will store the path of the image/file into the database
    - this approach is generally preferred in case, we want frequent access to the file

In this application, we are going with the 1st approach.
