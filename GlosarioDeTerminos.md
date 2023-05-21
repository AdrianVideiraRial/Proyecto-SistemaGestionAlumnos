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

### Métodos con firma "throw Exception":
La palabra clave throws Exception se utiliza para declarar que un método puede lanzar una excepción de un determinado tipo.
Al incluir throws Exception en la firma de un método, estás indicando que este método puede generar una excepción
de cualquier tipo que herede de la clase Exception.
La palabra clave throws se utiliza para declarar que un método puede lanzar una excepción de un determinado tipo, 
y su inclusión en la firma de un método es importante para que otros métodos que lo invoquen puedan manejar adecuadamente
las excepciones que pueda generar.

### DefaultTableModel:
Es una implementación de la interfaz TableModel en Java que proporciona un modelo de tabla predeterminado.
Permite almacenar y administrar los datos que se mostrarán en una JTable. Este modelo de tabla permite:
-Almacenamiento de datos.
-Control de datos.
-Gestión de columnas.
-Actualización de la interfáz gráfica.
