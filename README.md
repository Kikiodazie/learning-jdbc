# Learning JDBC
A project I built while learning Java Database Connectivity. Implements CRUD, Data
 Access Object pattern on a postgreSQL database built ontop a docker container.
## Getting Started
Clone this repo to your local machine [How To Guide](https://www.howtogeek.com/451360/how-to-clone-a-github-repository/)
## Order of operations
These commands are for linux/Mac, changes will need to made if you are running this in Microsoft Windows.

### Prerequisites
- Basic Knowledge of JAVA. Great tutorial on [Javatpoint](https://www.javatpoint.com/java-tutorial).
- Java JDK 8 at least  installed on Local machine. Oracle Doc for [Mac](https://docs.oracle.com/javase/10/install/installation-jdk-and-jre-macos.htm#JSJIG-GUID-2FE451B0-9572-4E38-A1A5-568B77B146DE) & [Windows](https://docs.oracle.com/javase/10/install/installation-jdk-and-jre-microsoft-windows-platforms.htm#JSJIG-GUID-A7E27B90-A28D-4237-9383-A58B416071CA).
- An IDE installed in local machine. Used [intelliJ IDEA](https://www.jetbrains.com/idea/promo/ultimate/?gclid=Cj0KCQjwy6T1BRDXARIsAIqCTXo9VjPwC01ZEn1DUj7FZBFT7JoyWZwxJj8L8HojEme3WZtOjYsj-JgaAudVEALw_wcB).
- Docker is installed [Download](https://hub.docker.com/_/postgres).
- psql client is installed [Postgres/psql](postgresqltutorial.com/install-postgresql/).


### Running PostgreSQL
1. Pull Docker Image
`docker pull postgres`

2. Build data directory
`mkdir -p ~/srv/postgres`

3. Run docker image
`docker run --rm --name lil-postgres -e POSTGRES_PASSWORD=password -d -v $HOME/srv/postgres:/var/lib/postgresql/data -p 5432:5432 postgres`

### Stopping PostgreSQL
`docker stop lil-postgres`

### Logging into Database
* `psql -h localhost -U postgres -d hplussport`

### Creating starter data
1. `psql -h localhost -U postgres -f database.sql`
2. `psql -h localhost -U postgres -d hplussport -f customer.sql`
3. `psql -h localhost -U postgres -d hplussport -f product.sql`
4. `psql -h localhost -U postgres -d hplussport -f salesperson.sql`
5. `psql -h localhost -U postgres -d hplussport -f orders.sql`


## Running the tests
After setting up development environment, docker container

- Build & Run
- Can also run SQL commands on terminal after logging in.

You should comprehensive outputs in the terminal....Hurray you have a functional database. 

## Built With
- [Java](https://www.java.com/en/download/)
- [JDBC]()
- [PostgreSQL](postgresqltutorial.com/install-postgresql/)
- [Docker](https://hub.docker.com/_/postgres)


## Authors
- Divine Odazie

