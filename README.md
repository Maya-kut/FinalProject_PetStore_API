# Проект по автоматизации тестирования API для сайта [Swagger Petstore](https://petstore.swagger.io/#/)

<p align="center"><a href="https://petstore.swagger.io/#/"><img src="images/logoPetStore.jpeg" align="center"  height="150"  alt="reqres"/></a></p>

> Petstore OpenAPI - это пример реализации спецификации OpenAPI (ранее Swagger), используемый для демонстрации и
> тестирования инструментов, связанных с OpenAPI. Он представляет собой описание REST API для "магазина домашних
> животных", в котором можно создавать, просматривать, обновлять и удалять информацию о животных, клиентах и заказах.

## Содержание:

- [Технологии и инструменты](#tools)
- [Выполняемые проверки](#cases)
- [Запуск тестов в Jenkins](#remoterun)
- [Allure отчёт](#report)
- [Уведомления в Telegram](#telegram)

<a id="tools"></a>

## Технологии и инструменты:

<div align="center">
<a href="https://www.jetbrains.com/idea/"><img alt="InteliJ IDEA" height="50" src="images/icons/IntelliJ_IDEA.png" width="50"/></a>
<a href="https://github.com/"><img alt="GitHub" height="50" src="images/icons/GitHub.png" width="50"/></a>  
<a href="https://www.java.com/"><img alt="Java" height="50" src="images/icons/Java_logo.png" width="50"/></a>
<a href="https://gradle.org/"><img alt="Gradle" height="50" src="images/icons/Gradle.png" width="50"/></a>  
<a href="https://junit.org/junit5/"><img alt="JUnit 5" height="50" src="images/icons/JUnit5.png" width="50"/></a>
<a href="https://rest-assured.io/"><img alt="RestAssured" height="50" src="images/icons/RestAssured.png" width="50"/></a>
<a href="https://www.jenkins.io/"><img alt="Jenkins" height="50" src="images/icons/Jenkins.png" width="50"/></a>
<a href="https://github.com/allure-framework/"><img alt="Allure Report" height="50" src="images/icons/AllureReports.png" width="50"/></a>
<a href="https://qameta.io/"><img alt="Allure TestOps" height="50" src="images/icons/AllureTestOps.svg" width="50"/></a>
<a href="https://www.atlassian.com/software/jira"><img alt="Jira" height="50" src="images/icons/Jira.png" width="50"/></a>  
<a href="https://telegram.org/"><img alt="Telegram" height="50" src="images/icons/Telegram.png" width="50"/></a>
</div>

<p></p>

Автотесты для данного проекта написаны на <code>Java</code> с использованием библиотеки <code>REST-assured</code> для
взаимодействия с REST api.

В качестве фреймворка для запуска тестов используется <code>Junit5</code>, а в качестве сборщика проекта - <code>
Gradle</code>. Произведена настройка CI в <code>Jenkins</code>.

По результатам каждого тестового прогона создаётся <code>Allure</code> отчёт для визуализации результатов прогона.

Для тест-менеджмента настроена интеграция с <code>Allure TestOps</code>, которая, в свою очередь, интегрирована с
таск-трекером <code>Jira</code>

После прогона тестов <code>Telegram</code> бот присылает сообщение с информацией о прошедшем прогоне

<a id="cases"></a>

## Выполняемые проверки:

### Взаимодействие со списком пользователей:

✅ Получение данных о пользователе

✅ Получение данных о несуществующем пользователе

✅ Обновление данных пользователя

✅ Создание пользователя

### Взаимодействие со списком питомцев:

✅ Поиск питомца по статусу "Продан"

✅ Поиск питомца по статусу "Доступен"

✅ Поиск питомца по несуществующему статусу

✅ Поиск питомца по идентификатору

✅ Поиск несуществующего питомца

✅ Поиск несуществующего питомца

✅ Обновление данных о питомце


<a id="remoterun"></a>

## Запуск тестов в [Jenkins](https://jenkins.autotests.cloud/job/FinalProject_PetStore_API/)

Для запуска тестов в Jenkins нужно нажать на кнопку Build With Parameters в соответствующей сборке

<p align="center">
<img src="images/run.png">
</p>

<a id="report"></a>

## [Allure отчёт](https://jenkins.autotests.cloud/job/FinalProject_PetStore_API/1/allure/)

### Графики

<p align="center">
<img src="images/report.png">
</p>

### Тесты

<p align="center">
<img src="images/tests.png">
</p>

<p align="center">
<img src="images/error%20screen.png">
</p>

<a id="telegram"></a>

## Уведомление в Telegram

По результатам каждого прогона тестов в Jenkins отправляется сообщение в Telegram. Сообщение содержит информацию о
прогоне, а также диаграмму со статистикой прохождения тестов.

<p align="center">
<img src="images/telegram%20report.jpg" width="400">
</p>
