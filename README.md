Zum Starten der Anwendung:

1. Zum Konfigurieren der Datenbankverbindung muss "/InsuranceCalc/src/main/resources/application.properties" angepasst werden. 
   Dazu müssen folgende Properties angepasst werden:
     1. url = URL zur Datenbank
     2. username = Benutzername für die Datenbank
     3. password = Passwort für den Datenbankbenutzer

2. Jetzt kann die SpringBoot-Anwendung gestartet werden. Am einfachsten über die IDE. Ansonsten muss:
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
