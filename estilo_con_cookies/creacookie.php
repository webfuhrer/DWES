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
//tamanyo color
$color=$_POST["color"];
$tamanyo=$_POST["tamanyo"];
setcookie("color_fondo", $color, time()+30,"/");
setcookie("tamanio_letra", $tamanyo,time()+10, "/" );
    ?>
    <a href="verpagina.php">Ir a ver la página</a>
</body>
</html>