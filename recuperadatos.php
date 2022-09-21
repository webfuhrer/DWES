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
        $nombre=$_GET["nombre"];
        $apellido=$_GET["apellido"];
        $fecha=$_GET["fecha"];
        echo "Te llamas nombre $apellido";
        echo "<br>";
        echo "Naciste en $fecha";
        echo "<br> Eres de sexo ".$_GET["sexo"];
        $aficiones=$_GET["aficion"];
        //echo "AFICIONES: $aficiones";
        echo "<ol>";
        foreach ($aficiones as $aficiones)
        {
            echo "<li>$aficion<li>";
        }
        echo "</ol>";

        //echo "<br>OTRA FORMA</br>";
        //echo "Te llamas ".$nombre."  ".$apellido;
        
    ?>
</body>
</html>