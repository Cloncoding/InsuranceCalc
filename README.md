Zum Starten der Anwendung:

1. Wenn die Datenbank PostgresSQL verwendet wird:
   Zum Konfigurieren der Datenbankverbindung muss "/InsuranceCalc/src/main/resources/application.properties" angepasst werden. 
   Dazu müssen folgende Properties angepasst werden:
     1. url = URL zur Datenbank
     2. username = Benutzername für die Datenbank
     3. password = Passwort für den Datenbankbenutzer
  
   Standardmäßig wird als Datenbank H2 verwendet. Diese Datenbank ist vollständig integriert und muss nicht konfiguriert werden.
   Um die Webconsole der Datenbank aufzurufen, muss die App gestartet sein. Außerdem muss in einem Webbrowser folgendes eingegeben werden:
   "http://localhost:8080/h2-console"
   Die "JDBC URL", "User Name" und "Password" sind identisch mit denen in der "application.properties".
   Über die Webconsole können SQL-Statements auf der Datenbank ausgeführt werden.
   Z.B. "SELECT * FROM PREMIUMS" damit werden alle vorher eingegebenen Prämienberechnungen angezeigt.

2. Am einfachsten wird die SpringBoot-Anwendung über die IDE gestartet. Ansonsten muss:
     1. Maven installiert werden
     2. Kommandozeile öffnen und in das Projektverzeichnis navigieren
     3. App mit "mvn spring-boot:run" starten
   
3. Für die Berechnung der Prämie wird die postcodes.csv benötigt. Diese muss importiert werden.
   Um den Import zu starten muss folgender POST ausgeführt werden (z.B. über den Boomerang-Client):
   "POST http://localhost:8080/api/db/import/all"
   Über die API wird die postcodes.csv eingelesen und in die Datenbank-Tabelle "regions" geschrieben.
   Im Anschluss wird automatisch der Import für die Faktoren gestartet. Diese werden in die Tabelle "factors" geschrieben.
   Dieser Import muss nach dem regions-Import laufen, da die Faktoren auf den Bundesländern der "regions" basieren.

4. Nach dem Import kann "http://localhost:8080/" aufgerufen werden (Web Gui für die Berechnung der Prämie)

5. Um die persistenten Berechnungen anzuzeigen, muss folgender GET ausgeführt werden:
   "GET http://localhost:8080/api/premium/show"
   Wenn die H2-Datenbank genutzt wird, kann alternativ die H2-Webconsole verwendet werden (2. Abschnitt von Punkt 1.)
