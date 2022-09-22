<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
    table,td{
        border: 2px red dotted;
    }
    .bicicleta
    {
        background-color: red;
    }
    .bicicleta_asistida
    {
        background-color: green;
    }
    </style>
</head>
<body>
    <?php
    $archivo=fopen("accidentes.csv","r");
    fgets($archivo);//No me interesa la primera línea
    echo "<table>";
    while(!feof($archivo))
    {
        
        $linea=fgets($archivo);
        $arr_datos=explode(";",$linea);
        $fecha=$arr_datos[1];
        $lesividad=$arr_datos[14];
        $tipo=$arr_datos[9];
        echo "<tr>";
        echo "<td>$fecha</td>";
        $clase="";
        if ($tipo=="Bicicleta EPAC (pedaleo asistido)")
        {$clase="bicicleta_asistida";}
        else if ($tipo=="Bicicleta")
        {$clase="bicicleta";}
        echo "<td class=$clase>$tipo</td>";
        echo "<td>$lesividad</td>";
        echo "</tr>";
        
    }
    echo "</table>";
    fclose($archivo);
    ?>
</body>
</html>