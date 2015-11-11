
# TripComposerTest
test task for Trip Composer

Application for saving list of "Countries". Every country has list of "Cities".
Method "doPOST" sends http request to remote server. Received response is parsed and saved to db.
Used techlogies: Spring core, Hibernate, PostgreSQL, Log4j, Apache HTTP Client, Jackson, Junit.

>Before using application, be kind to put property-file with DB-connection properties to your "resources/properties" package.

    Properties template:
    db.name=
    db.username=
    db.password=
    db.host=localhost
    db.port=5432
    db.driver=org.postgresql.Driver
    db.url=jdbc:postgresql://${db.host}:${db.port}/${db.name}

App contains *init.sql* file for initiating tables in your PostgreSQL db.


> Written with [StackEdit](https://stackedit.io/).