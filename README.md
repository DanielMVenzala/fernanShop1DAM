<img src='https://i.postimg.cc/nzx18hRs/Captura-de-pantalla-2025-01-16-105520.jpg' border='0' alt='Captura-de-pantalla-2025-01-16-105520'/>

# FernanShop

**FernanShop** es una aplicación desarrollada en Java para la asignatura de Programación de 1º de Desarrollo de Aplicaciones Multiplataforma (DAM). En dicha aplicación se gestionará un e-commerce que permitirá el acceso a clientes, trabajadores y administradores, teniendo cada uno de estos perfiles un menú propio con diversas funcionalidades. Estas son: alta de nuevos clientes o trabajores, creación y asignación de nuevos pedidos o consulta y modificación de datos personales. Dispondremos de un menú específico para cada uno de los perfiles al cual se accederá mediante un login.


# Cambios implementados en la práctica 4


1. Implementar un método en la clase Pedido para generar un idPedido aleatorio entre 0 y 100000


![App Screenshot](https://i.postimg.cc/kgdbBFjx/image.png)  



  
2. Antes de crear un nuevo pedido comprobar que el idPedido que se genera automáticamente al llamar al constructor no exista con anterioridad. Lo haremos con varios condicionales dentro de un bucle do-while hasta que empecemos a trabajar con arrays.


![App Screenshot](https://i.postimg.cc/9F141RC9/image.png)  


3. Cuando un nuevo usuario se registre comprobaremos que el mail introducido no exista previamente. Ahora lo haremos con un if hasta que utilicemos estructuras de datos más avanzadas.

![App Screenshot](https://i.postimg.cc/vHm8YPw1/image.png)  


4. Para la creación de un nuevo cliente así como para la modificación de su correo electrónico implementamos un método que enviará un token al mail del cliente y que tendrá que introducir para poder completar el registro. Dentro del método llamaremos a enviarCorreoGmail, donde se establecen las propiedades de la conexión (remitente, clave, puerto, host...)






