# runnerz

- Spring Boot is a tool using the Spring framework thaat removes need for external java files and config. It lets devs focus on developing not configuration. It also provides a production ready apps and gives us depencies
- On the subject of dependencies, Maven is a dependency manager. What this does is generates a POM file in which depencies needed are listed. From here, our application downloads dependencies for it.

- Using Spring Boot Maven, we can introduce certain classes and objects into our "context" to be called elsewhere within our project. Spring is really nice in the fact that if you tag a class, it will handle its lifecycle and make it accessible to other files without the need of initializing a new object with it using the new keyword, you can just pass it in as a prop and use it if its tagged.

- Docker is a tool used to run containers, a container can be anything from a program to a database. In this case, its really nice to run a docker command and have a postgres db instead of having to configure it on your local machine
