<!DOCTYPE html>
<?php
verificarAcceso();
function verificarAcceso()
    {
        if (!isset ($_COOKIE["cookie_nombre"]))
               {
                header("location: login.php");
                       }
    }
?>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
    $archivo=fopen("agenda.csv", "r");
    echo "<table border=1>";
    while(!feof($archivo))
    {
        $linea=fgets($archivo);
        $arr_datos=explode(",", $linea);
        
        if (count($arr_datos)==2)
            {
                $nombre=$arr_datos[0];
                $telefono=$arr_datos[1];
            echo "<tr>";
            echo "<td>$nombre</td><td>$telefono</td>";
            echo "</tr>";
            }
      }
    echo "<table>";
    ?>
    <a href="grabacontactos.php">Ir a grabar</a>
</body>
</html>