<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="formulariograbador.php" method="GET">
    <label for="idurl">URL</label>
    <input type="url" id="idurl" name="url">
    <label for="idtexto">TEXTO</label>
    <input type="text" id="idtexto" name="texto">
    <label for="idcolor">COLOR</label>
    <input type="color" id="idcolor" name="color">
    <input type="submit">
    </form>
    <?php
    //isset($x)
    if (isset($_GET["url"]) && 
    isset($_GET["texto"])
    && isset($_GET["color"]) 
    )
    {
        $url=$_GET["url"];
        $texto=$_GET["texto"];
        $color=$_GET["color"];
        $archivo_favoritos=fopen("favoritos.csv", "a");
        $linea="$url,$texto,$color\n";
        fwrite($archivo_favoritos, $linea);
        fclose($archivo_favoritos);
    //header ("Location: verfavoritos.php");
    }
    ?>
</body>
</html>