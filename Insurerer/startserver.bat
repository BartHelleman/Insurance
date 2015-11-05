::
:: Batchbestand voor het starten van de IVH5 LibraryServer.
:: Je start de server het handigst vanuit de directory waar de webserver
:: de classes kan vinden. Pas deze zo nodig hieronder aan.
::
cd C:\xampp\htdocs\classes

:: Start java met het juiste classpath
::start java -cp ./server-1.0-SNAPSHOT-jar-with-dependencies.jar;./shared-1.0-SNAPSHOT.jar edu.avans.ivh5.server.main.Main -properties resources/standard.properties
start java -cp ./server-1.0-SNAPSHOT-jar-with-dependencies.jar edu.avans.ivh5.server.main.Main -properties standard.properties
::mvn exec:java -Dexec.mainClass="edu.avans.ivh5.server.main.Main" -Dexec.args="-properties resources/standard.properties"

:: Wanneer je securityproblemen wilt oplossen, voeg dan onderstaande optie aan het command toe.
:: Hiermee krijg je inzicht in alle security instellingen.
::
:: 		-Djava.security.debug=access,failure

@pause
pause