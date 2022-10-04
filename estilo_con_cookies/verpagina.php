<!DOCTYPE html>
<html lang="en">
<?php
    /*setcookie("color_fondo", $color, time()+30,"/");
setcookie("tamanio_letra", $tamanyo,time()+10, "/" );*/
$color_fondo=$_COOKIE["color_fondo"];
$tamanyo_letra=$_COOKIE["tamanio_letra"];
    ?>
<head>
    <style>
        body{
            background-color: <?php echo $color_fondo;?>;
            size: <?php echo $tamanyo_letra;?>
        }
    </style>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
   HOLA MUNDO
</body>
</html>