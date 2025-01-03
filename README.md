# Pràctica 2: UI Testing - Test i Qualitat (Curs 2024-2025)

## Integrants de l'equip

- **Eric Chaves Sánchez**
- **Pau Leyva Garcia**

## Descripció

Aquesta pràctica consisteix en l'automatització de tests UI per a una pàgina web utilitzant **Selenium WebDriver** i el framework **Cucumber** en **Java**. L'objectiu és provar les funcionalitats principals de la pàgina web seleccionada a través de diversos escenaris de prova definits amb el llenguatge **Gherkin**.

## Funcionalitats Proves

Els tests desenvolupats cobreixen funcionalitats clau de la pàgina web, incloent formularis d'usuari (registre, login, edició de dades), processos de compra (afegir al carret, visualització de productes), i altres aspectes de la navegació de la pàgina.

## Fitxers de Característiques

Les **features** es poden trobar al directori `src/test/resources/features/`. Cada fitxer Gherkin defineix un conjunt d'escenaris que simulen les accions més importants dins de la pàgina web.

## Instal·lació i Execució

1. Clona el repositori: git clone https://github.com/1633944/UI-Testing_TQS_2024.git

2. Instal·la les dependències amb Maven: mvn install
   
3. Executa els tests: mvn test

Els tests es realitzaran utilitzant el WebDriver i es generaran informes de l'execució.




