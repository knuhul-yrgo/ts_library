1. Motivera dina val av tester för Username. Är det ett rimligt och bra val av tester? Är det något du i
   efterhand tycker borde läggas till eller tas bort?

    Jag har utgått ifrån dokumentationen i Username-klassen när jag skrivit mina tester. Genom parametriserade
    tester så testar jag alla de testfall som dokumentationen specificerar och skickar in de som olika inparametrar
    för att enkelt kunna felsöka vilket testfall (t.ex vilken specialkaraktär) som ger upphov till problem.

    ------------------------------------------
2. Vad anser du själv om skillnaderna mellan asserts från JUnit och de som erbjuds av AssertJ? Är det värt
   att plocka in ett extra bibliotek för detta eller är det bara onödigt?

   AssertJ erbjuder bättre läsbarhet än JUnit. Assert-deklarationerna blir längre men mer lika korrekta meningar.
   Jag kan förstå om man skulle känna att AssertJ känns överflödigt - den syntaktiska skillnaden är på inget sätt
   enorm och JUnits assertions är redan rätt begripliga. Jag uppskattar estetiken i tydlighet och det känns ännu 
   viktigare när man skriver tester. Tester bör täcka all relevant funktionalitet och då är det viktigt att man
   snabbt förstår vad de existerna testerna gör. Iomed det är jag positivt inställd till AssertJ. 

    ------------------------------------------
3. Motivera dina val av tester för UserService och UserDao. Är det ett rimligt och bra val av tester? Är
   det något du i efterhand tycker borde läggas till eller tas bort?

    

    ------------------------------------------
4. Vad anser du själv om skillnaderna mellan att testa UserDao med hjälp av mockar gentemot att testa
   med hjälp av minnesdatabas? Vilken metod tycker du verkar vettigast och varför då?

    ------------------------------------------
5. Vad ser du för problem med att skriva integrationstester mot ett riktigt databassystem (i det här fallet
   MySQL)? Dvs. att ha en testmiljö som använder MySQL istället för t.ex. mockar eller H2. Vad finns det
   för svårigheter med det?

    ------------------------------------------
6. Kunde du upptäcka vad som var säkerhetsproblemet med den ursprungliga versionen av
   UserDao.validate()?
