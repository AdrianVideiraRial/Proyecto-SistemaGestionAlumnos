## Glosario de Terminos usados en el proyecto.
### Statement:
Interfaz que se utiliza para ejecutar sentencias SQL simples (SELECT, INSERT, UPDATE y DELETE).
El objeto Statement permite usar y enviar las consultas a la base de datos y recuperar los resultados si los hubiera;
es poco seguro antes los ataques sobre SQL.

### PreparedStatement:
Es una subInterfaz de Statement. Es igual que esta, pero es más segura y permiite la reutilización de 
"clausulas precompiladas".

### Cláusulas precompiladas:
Son una técnica de optimización de consultas en bases de datos que permite que una consulta sea preparada y compilada
antes de su ejecución.
En Java, las cláusulas precompiladas se implementan a través de la interfaz PreparedStatement.

### ResultSet:
Es un objeto que contiene los resultados de una consulta SQL ejecutada meidante Statement
o PreparedStatement.ResultSet se utilizan para almacenar los resultados que obtenemos de una 
consulta a la base de datos. En otras palabra, una vez que se ejecutala consulta, la base de datos devuelve
un conjunto de datos que pueden ser leídos y monipulados en Java a  través del objeto "ResultSet".
