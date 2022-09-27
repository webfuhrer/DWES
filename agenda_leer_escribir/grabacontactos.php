<?php

$nombre=$_POST["nombre"];
$telefono=$_POST["telefono"];
$fichero_agenda=fopen("agenda.csv", "a");
$linea="$nombre,$telefono\n";
fwrite($fichero_agenda, $linea);

fclose($fichero_agenda);
header ("Location: vercontactos.php");