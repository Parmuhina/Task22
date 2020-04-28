FROM mysql:latest

ENV MYSQL_ROOT_PASSWORD=system
ENV MYSQL_DATABASE=shoppingList
#ENV MYSQL_USER=system
ENV MYSQL_PASSWORD=system

COPY initial-script.sql /docker-entrypoint-initdb.d/