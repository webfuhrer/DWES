<?php
$ruta_autorizados="autorizados.csv";
if (isset($_POST["usuario"]) &&  isset($_POST["password"]))
    {
        verificarAutorizacion($_POST["usuario"], $_POST["password"]);
    }

function verificarAutorizacion($usuario, $password)
{
    global $ruta_autorizados;
    $archivo=fopen($ruta_autorizados, "r");
    $encontrado=false;
    while(!feof($archivo) && !$encontrado)
    {
        $linea=fgets($archivo);
        $arr_datos=explode(",", $linea);
        $usuario_csv=trim($arr_datos[0]);
        $password_csv=trim($arr_datos[1]);
        $comp_usuario=strcmp($usuario_csv, $usuario);
        $comp_password=strcmp($password_csv, $password);
        if ( $comp_usuario==0 && $comp_password==0)
        {
            $encontrado=true;
        }
        
    }
    if ($encontrado)
    {
        //Creo la cookie
        //Redirijo
        setcookie("cookie_nombre",$usuario, time()+60,"/" );
        header("location: vercontactos.php");
    }
    else{
        //Creo cookie de error

        //Redirijo a login.php
        header("location: login.php");
    }
}

