<?php
function verificarCredenciales($usuario, $password)
{
    //Esta funcion devolverá true o false
    $ruta_usuarios_autorizados="autorizados.csv";
    //Creo una variable que se llama encontrado y la pongo a false
    $encontrado=false;
    //Si en algún momento hay una coincidencia, pongo encontrado a true y
    // salgo del bucle
    $color_usuario="";
    $archivo=fopen($ruta_usuarios_autorizados, "r");
    while(!feof($archivo) && !$encontrado)
        {
            //sigue leyendo
            $linea=fgets($archivo);
            $arr_datos=explode(",", $linea);
            $usuario_csv=trim($arr_datos[0]);
            $password_csv=trim($arr_datos[1]);
            $color=trim($arr_datos[2]);
            //strcasecmp NO se usa
            if($usuario_csv==$usuario && $password_csv==$password)
                {
                   $color_usuario=$color;
                }
        }
        return $color_usuario;

}
function controlar_acceso()
{
    if(!isset($_COOKIE["usuario"]))
    {
        header("location: login.php");
    }
}
function escribirComentario($usuario, $mensaje, $color, $fecha)
{
    $archivo=fopen("comentarios.csv", "a");
    $linea=$usuario.";".$mensaje.";".$fecha.";".$color."\n";
    fwrite($archivo, $linea);
    fclose($archivo);

}
function listarComentarios()
{
    //ANA;Hola;13/10/2022 a las 12:36;#334455
    $archivo=fopen("comentarios.csv", "r");
    while(!feof($archivo))
    {
        $linea=fgets($archivo);
        $arr_datos=explode(";", $linea);
        if (count($arr_datos)==4)
            {
                    $nombre=$arr_datos[0];
                    $comentario=$arr_datos[1];
                    $fecha=$arr_datos[2];
                    $color=$arr_datos[3];
                    echo "<p style='color: $color; background-color: gray'>El usuario $nombre dijo el día $fecha :$comentario </p>";
            }
    }
    fclose($archivo);

}
?>