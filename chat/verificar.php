<?php
include 'funciones.php';
if (isset ($_POST["usuario"]) && isset ($_POST["password"]))
{//Sigo
}
else
{
    //Le mando a login.php
    header("location: login.php");
    
}
//A partir de aquí tengo claro que me están POSTeando usuario y pasword
$usuario=$_POST["usuario"];
$password=$_POST["password"];
$color=verificarCredenciales($usuario, $password);
//$color vale un color si el usuario está OK y vacío si no
if($color!="")
    {
        //Le creo la cookie usuario y la cookie color
        setcookie("usuario", $usuario, time()+3000, "/");
        //¿Y la cookie color...?
       
        setcookie("color",$color, time()+3000,"/" );
        header("location: chat.php");
    }
    else
    {
        //Le envío a login.php
        header("location: login.php");
    }