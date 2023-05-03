## Проект по предмету "Распределенные системы обработки информации".
### Описание.
Приложение, построенное на микросервисной архитектуре, реализующее работу валютного конвертера. 
Оно состоит из двух микросервисов, где **ClientService** отвечает за работу с пользователем, а **CurrencyConversionService** за валютное конвертирование.  
При работе с приложением пользователю необходимо ввести сумму, которую нужно конвертировать, а также выбрать валюту данной суммы и ту, 
в которую требуется произвести конвертацю. Для получения поддерживаемых приложением валют ClientService взаимодействует с базой данных и выводит список в представление. 
По запросу пользователя клиентский сервис отправляет начальные данные конвертации сервису конвертации валют, который, взаимодействуя с API Coingate, 
предоставляющим актуальные валютные ставки, конвертирует сумму из начальной валюты в конечную. 
Далее сервис конвертации валют возращает результат конвертации клиентскому сервису, который выводит результат в предствление.
____
### Технологии.
**Назначение** | **Название**
:----|:------:
Backend | Java / Spring Framework
Frontend | HTML / CSS / JavaScript / JQuery / Thymeleaf
Database | PostgreSQL
Message-broker | RabbitMQ
Containerizer | Docker
OS | Windows 11
____
### Запуск.
Клонировать репозиторий и, находясь в терминале, перейти в папку, где находится файл **docker-compose.yml** для запуска приложения в Docker. После чего выполнить команду:
```
docker compose up -d
```
>>>> **Важно!** При запуске приложения в одной папке с docker-compose.yml всегда должен находиться **currencies_dump.sql**.  Это скрипт, отвечающий за инициализацию 
базы данных и заполнение её информацией о поддерживаемых валютах. Папки ClientService и CurrencyConversionService должны находиться в одной директории с docker-compose.yml в том случае, если их образы отсутствуют на Docker Hub. 
____
### Результат.
После успешного запуска всех контейнеров нужно перейти на [http://localhost:3000/](http://localhost:3000/) (по умолчанию, если запускается на локальном сервере) для работы с программой.
####
![result](https://github.com/EmelKrist/currency-converter/blob/master/Example.png)
