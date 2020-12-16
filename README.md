# Welcome to the GitHub Repository of my graduation assignment!

- [English](#english)
- [Abstract](#abstract-of-the-thesis)
- [Dutch (Nederlands)](#nederlands)
- [Nederlandse samenvatting](#samenvatting-van-de-scriptie)
- [References](#references)

# English
Welcome to my GitHub Repository.
Because of the Dutch below
On this GitHub page you can find all products that were delivered as a result of my graduation assignment at Hogeschool Utrecht. Below you can read a summary of my graduation project.

## contents of this Repo

In this Repo you will find the python code to use in the source code to build the XML testfile creator tool. this can be found [here](/tree/main/TestFileCreater). Also the latest files that I used in the RinSim simulator are found [here](/tree/main/RinSimulatie)

#### How to use
The XML testfile creator tool I have written using Python 3.8 and Tkinter. Tkinter is a standard library in Python, so no further installation is required.

To use the RinSim simulator you will have to download RinSim, see the instructions [here](https://github.com/rinde/RinSim/)

## Abstract of the thesis
The thesis was written as a graduation assignment for my study *‘Technische Informatica’* at University of Applied Science, Hogeschool Utrecht.

To produce products on a small scale, the current way of production will have to change through an Agile approach. The research group ['Microsysteemtechnologie'](https://www.hu.nl/onderzoek/microsysteemtechnologie) states that this can best with the use of Equiplets: small reconfigurable production platforms. These are connected in a grid.

The goal of the graduation assignment was to simulate the movement of the transport platforms within an agent-controlled production grid. Within this assignment the main question is: What solutions can be found to improve the efficiency of an Agile manufacturing production grid by use of simulations in order to validate the theory? Sub-questions have been drawn up to answer this main question: 1. What preconditions must the simulation tool meet? 2. Which simulation tool meets the preconditions found in sub-question 1 and is suitable for this assignment? 3. What are the limitations of the grid layout used in the paper (van Moergestel et al., 2018)? 4. How can these limitations be overcome? 5. How does the use of a central path planning agent affect these restrictions? To find answers to the questions asked, a literature search was carried out and a simulation was made.

First, it was determined which preconditions the simulation tool must meet. The programming language, the platform, the algorithms used, and the type of simulation tool were considered. This showed that RinSim seemed like the simulation tool that met the preconditions and seemed suitable for this assignment. Main limitations of the grid layout were the influence of “waiting” transport platforms due to the lack of parking spaces and the way the grid is used. During the simulations it appeared that following the lines of a grid tightly is not the most efficient and can cause complex problems. When asked whether central path planning is better than decentralized path planning, the conclusion is that decentralized path planning is better than central path planning if there are situations with medium to high dynamics, high urgency and medium to high scale. In all other cases, decentralized path planning is therefore more efficient.

In conclusion, it can be said that central path planning is indeed more efficient, as long as the following three criteria are not met: 1. means to high dynamics in the production grid; 2. high urgency within the production grid; 3. medium to high scale within the production grid. The way in which the current grid is designed is also inefficient because obstacles have too much influence or transport movements.

The recommendation is to see the transport grid as an open field within which the transport platforms can move freely. An open field production environment may also have the advantage that around Equiplets that are known to be visited more frequently, space can be kept free for other Equiplets.

During this graduation period I learned a lot and had a lot of fun with the path planning algorithms and agent-controlled production grids. During this graduation project I noticed that several things went well and that I had a few stumbling points. For example, I had difficulty working remotely, the effort it took to get in touch with my supervisors, I had problems with my planning and I drew conclusions too quickly. As a result, I have set the following learning objectives. I am able to work remotely with my future employer. I can make a weighted decision based on scientific sources. After three months I can communicate clearly with my future employer to my direct colleagues. At the end of my graduation period I can make a realistic planning of my work so that I achieve the set goals.

### References

van Moergestel, L., Puik, E., & Meyer, J.-J. (2018, 24 - 28, 2018). *A Software Architecture for Transport in a Production Grid*. Paper presented at the INTELLI 2018, Venice, Italy



# Nederlands
Welkom op in mijn GitHub Repository.

Op deze GitHub pagina kunt u alle producten vinden die opgeleverd zijn naar aanleiding van mijn afstudeeropdracht aan de Hogeschool Utrecht. Hieronder kunt u een samenvatting lezen van de mijn afstudeerproject.

## Inhoud van deze Repo

In deze repository vind u de Python source code voor de XML testfile creator tool. Deze kunt u [hier](/tree/main/TestFileCreater) vinden. [Hier](/tree/main/RinSimulatie) kunt u de laatste bestanden vinden die zijn gebruikt tijdens het bouwen van de simulatie in RinSin.

#### Gebruik
De XML testfile creator tool Heb ik geschreven met behulp van Python 3.8 en Tkinter. Tkinter is een standaard library in Python, er is dus geen verdere installatie vereist.

Voor het gebruik van de RinSim simulator moet u wel RinSim  downloaden, de instructies hiervoor kunt u [hier](https://github.com/rinde/RinSim/) vinden.


## Samenvatting van de scriptie
Deze scriptie is geschreven als afstudeeropdracht van de opleiding Technische Informatica aan de Hogeschool Utrecht.
Om producten op kleine schaal te produceren, zal de huidige manier van produceren moeten veranderen door middel van een Agile aanpak. Het [lectoraat Microsysteemtechnologie](https://www.hu.nl/onderzoek/microsysteemtechnologie) stelt dat dit het best gedaan kan worden met Equiplets: kleine herconfigureerbare productieplatforms. Deze zijn door middel van een grid met elkaar verbonden.
Doel van de afstudeeropdracht was om een simulatie te maken voor de beweging van de transportplatforms binnen een agent controlled productiegrid. Binnen deze opdracht is de hoofdvraag: Welke oplossingen zijn er om door middel van simulaties de efficiëntie van een Agile manufacturing productiegrid de productie te verbeteren ter validatie van de theorie? Om deze hoofdvraag te beantwoorden zijn deelvragen opgesteld: 1. Aan welke randvoorwaarden moet de simulatietool voldoen? 2. Welke simulatietool voldoet aan de randvoorwaarden gevonden in deelvraag 1 en is geschikt voor deze opdracht? 3. Wat zijn de beperkingen van de grid lay-out die zijn gebruikt in de paper (van Moergestel et al., 2018)? 4. Hoe kunnen deze beperkingen overkomen worden? 5. Welke invloed heeft het gebruik van een centrale padplanning agent op deze beperkingen? Om antwoorden te vinden op de gestelde vragen is literatuuronderzoek uitgevoerd en is een simulatie gemaakt.
Allereerst is er bepaald aan welke randvoorwaarden de simulatietool moet voldoen. Hierbij is gekeken naar de programmeertaal, het platform, de gebruikte algoritmen en het type simulatietool. Hieruit bleek dat RinSim de simulatietool leek die aan de randvoorwaarden voldeed en geschikt leek voor deze opdracht. Belangrijkste beperkingen van de grid lay-out waren de invloed van “wachtende” transportplatformen door het ontbreken van parkeerplekken en de manier waarop het grid wordt gebruikt. Tijdens de simulaties is gebleken dat het strak volgen van de lijnen van een grid niet het meest efficiënt is en voor complexe problemen kan zorgen. Op de vraag of centrale padplanning beter is dan decentrale is de conclusie dat decentrale padplanning beter is dan centrale padplanning als er sprake is van situaties met zowel middel tot hoge dynamiek, hoge urgentie en middel tot hoge schaal. In alle andere gevallen is decentrale padplanning dus wel efficiënter.
Concluderend kan worden gesteld dat centrale padplanning inderdaad efficiënter is, zolang er niet wordt voldaan aan de volgende drie criteria: 1.middel tot hoge dynamiek in het productiegrid; 2. hoge urgentie binnen het productiegrid; 3. middel tot hoge schaal binnen het productiegrid. Ook is de manier waarop het huidige grid is vormgegeven niet efficiënt omdat obstakels te veel invloed hebben of transportbewegingen.
De aanbeveling is om het transportgrid te gaan zien als open veld waarbinnen de transportplatformen zich vrij kunnen bewegen. Een open veld productie omgeving heeft mogelijk ook als voordeel dat rondom Equiplets waarvan bekend is dat deze drukker bezocht worden er ruimte vrijgehouden kan worden tot andere Equiplets.
Tijdens deze afstudeerperiode heb ik veel geleerd en veel plezier gehad met de padplanning algoritmen en agent controlled productie grids. Bij dit afstudeeronderzoek heb ik gemerkt dat ik een aantal zaken goed gingen, en ik een aantal struikelpunten had. Zo had ik moeite met het werken op afstand, de moeite die het kostte om contact te krijgen met mijn begeleiders, had ik problemen met mijn planning en trok ik te snel conclusies. Hierdoor heb ik de volgende leerdoelen op gesteld. Ik ben bij mijn toekomstige werkgever in staat op afstand te werken. Ik ben in staat op basis van wetenschappelijke bronnen een gewogen beslissing te nemen. Ik kan na drie maanden bij mijn toekomstige werkgever duidelijk communiceren naar mijn directe collega’s. Ik kan aan het einde van mijn afstudeerperiode een reële planning maken van mijn werk waardoor ik de gestelde doelen haal.

### Bronvermelding

van Moergestel, L., Puik, E., & Meyer, J.-J. (2018, 24 - 28, 2018). *A Software Architecture for Transport in a Production Grid*. Paper presented at the INTELLI 2018, Venice, Italy

## License
[MIT](https://choosealicense.com/licenses/mit/)
