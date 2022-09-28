<?php

$url=$_GET["url"];
$texto=$_GET["texto"];
$color=$_GET["color"];
$archivo_favoritos=fopen("favoritos.csv", "a");
$linea="$url,$texto,$color\n";
fwrite($archivo_favoritos, $linea);
fclose($archivo_favoritos);
header ("Location: verfavoritos.php");