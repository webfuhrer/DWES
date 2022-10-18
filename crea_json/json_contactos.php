<?php
$archivo_contactos=fopen("agenda.csv", "r");
$texto_json= "{ \"amigos\":[";
while(!feof($archivo_contactos))
{
    $linea=fgets($archivo_contactos);
    $arr_datos=explode(",", $linea);
    if (count($arr_datos)==2)//Para evitar que falle en la línea en blanco
        {
            $nombre=$arr_datos[0];
            $telefono=$arr_datos[1];
            $texto_json= $texto_json."{";
            $texto_json=$texto_json."\"nombre\":";
            $texto_json=$texto_json."\"$nombre\",";
            $texto_json=$texto_json."\"telefono\":";
            $telefono_trimado=trim($telefono);
            $texto_json=$texto_json."\"$telefono_trimado\"},";
        }

}
//Quito la última coma
//Quiero coger la cadena desde el principio hasta su longitud menos uno
//PEPE ->4
//PEP
$texto_json=substr($texto_json, 0, strlen($texto_json)-1);

$texto_json=$texto_json."]}";
echo $texto_json;