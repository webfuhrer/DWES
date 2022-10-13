<?php
include "funciones.php";
controlar_acceso();

?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    
    <?php
    if (isset($_POST["comentario"]) && $_POST["comentario"]!="")
        {
            $usuario=$_COOKIE["usuario"];
            $mensaje=$_POST["comentario"];
            $color=$_COOKIE["color"];
            $arr_fecha=getdate();
            $arr_fecha["seconds"];
            $fecha=$arr_fecha["mday"]."/".$arr_fecha["mon"]."/".$arr_fecha["year"].
            " a las ".$arr_fecha["hours"].":".$arr_fecha["minutes"];
            //8/1/2022 a las 13:26

            escribirComentario($usuario, $mensaje, $color, $fecha);
           
        }
    
            listarComentarios();
        
    ?>
    <form action="chat.php" method="POST">
        <textarea cols=20 rows=5 name="comentario"></textarea>
        <input type="submit">
    </form>
</body>
</html>