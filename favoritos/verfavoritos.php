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
    $archivo=fopen("favoritos.csv", "r");
    echo "<ol>";
    while(!feof($archivo))
        {
            $linea=fgets($archivo);//URL,TEXTO,COLOR
            $arr_datos=explode(",",$linea);
            if (count($arr_datos)==3)
            {
                $url=$arr_datos[0];
                $texto=$arr_datos[1];
                $color=$arr_datos[2];
                
                echo "<li ><a style='color: $color' href=$url>$texto</a></li>";
            }
            
            

        }
        echo "</ol>";
        fclose($archivo);
    ?>
    
</body>
</html>