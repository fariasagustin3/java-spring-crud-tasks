# Instrucciones para correr el proyecto localmente

1.- Clonar el repositorio del proyecto  
2.- Abrir una terminal de Git Bash en el directorio donde se encuentra el archivo docker-compose.yml  
3.- Ejecutar el ```docker-compose up -d;```  
4.- Una vez finalizado, desde un administrador de bases de datos, deberá crear manualmente la tabla ```tasks```, que sería el siguiente bloque de código:  
```
CREATE TABLE tasks (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    startDate DATE,
    completed BOOLEAN NOT NULL DEFAULT FALSE
);
```  
5.- Una vez ejecutado este query, ya puede correr el proyecto normalmente y hacer uso de sus endponts
