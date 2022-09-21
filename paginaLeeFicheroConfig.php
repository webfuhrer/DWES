<!DOCTYPE html>
<html lang="en">
<?php
//Abro el fichero:
$archivo=fopen("config.csv", "r");
while(!feof($archivo))
    {
        $linea=fgets($archivo);
        //colorfondo,colorletra,tamañoletra,texto
        $arr_datos=explode(",", $linea);
        $colorfondo=$arr_datos[0];
        $colorletra=$arr_datos[1];
        $tamanioletra=$arr_datos[2];
        $texto=$arr_datos[3];
    }
    fclose($archivo);
?>

<head>
<style>
    body
    {
        background-color:<?php echo $colorfondo?>;
        color: <?php echo $colorletra?>;
        font-size: <?php echo $tamanioletra?>
    }
</style>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
echo "<p>$texto</p>";
    ?>
   
</body>
</html>