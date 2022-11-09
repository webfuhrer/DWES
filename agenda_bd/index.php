<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AGENDA</title>
</head>
<body>
    
    <form action="index.php" method="post">
       <label for="id_nombre">NOMBRE:</label>
        <input type="text" id="id_nombre" name="nombre"
        placeholder="Introduzca su nombre"><br>
        <label for="id_telefono">TELÉFONO:</label>
        <input type="tel" id="id_telefono" name="telefono"
        placeholder="Introduzca su teléfono"><br>
        <input type="submit" >
    </form>
    <?php
    include "funciones.php";
    inicializarBD();
    if (isset($_POST["nombre"]))
        {
            //Regsitro los datos en la BD
            $nombre=$_POST["nombre"];
            $telefono=$_POST["telefono"];
            //v2: creo objeto contacto
            $contacto=new contacto($nombre,$telefono);
            //En v2, creo un objeto y lo paso a la funcion
            //insertarDatos($nombre, $telefono);
            insertar_datos($contacto);
        }
    pintarTablaContactos();
    ?>
</body>
</html>
