# To Do webapp

This project was a good learning experience for me in regards to creating my first full stack web application. The idea behind a to do app is fairly simple, you could use just the front end tech stack to create it in full, however what if we wanted to complicate it just for the sake of making it harder? This particular application created with REST architecture in mind allows the user to perform basic CRUD operations on a to do list that connects to a SQL database with the help of jetty and servlets. 

### How to run app
1. Simply download the repository and run the hello-1.0-SNAPSHOT-jar-with-dependencies.jar file.
2. After the file has finished downloading all the required dependencies just run the Main class within the app
3. Open Browser and open localhost on port 8081

### User Features
- Choose from a range of languages (stored in a SQL database), in which you will be greeted by the webapp.
- Add a to do point to the list.
- Check/Uncheck your to do's.
- The app stores the list with their respected to do checkboxes in its database for future use.

### Tech stack used for the project
- Back-end: Java.
- Data storage: SQL.
- Front-end: HTML, CSS
- Unit testing: Junit 5.
- Project build and management automation: Maven.
- Database migrations: FlyWay.
- Web server & servlet container: Jetty.
- ORM: Hibernate.

### Future features
- Remove To do's

## User interface
### Main page of to do app with language selection and username prompt
![](Screenshots/main.png)
### Users todo list page
![](Screenshots/user.png)
### Users todo list page after adding new to do item to list
![](Screenshots/new%20todo.png)
