<?php
$usuario="root";
$password="";
$nombre_bd="miagenda";
$host="localhost";
class contacto{
    public $nombre;
    public $telefono;
    public function  __construct($nombre, $telefono)
    {
        $this->nombre=$nombre;
        $this->telefono=$telefono;
    }
    public function get_nombre()
    {
        return $this->nombre;
    }
    public function get_telefono()
    {
        return $this->telefono;
    }
}
function inicializarBD()
{
    global $usuario, $password, $nombre_bd, $host;
    try{
        $conexion=new mysqli($host, $usuario
        ,  $password, $nombre_bd);
        $conexion->close();
    }
    catch(Exception $e)
    {
        //No existe la BD (suponemos)
        //Nos conectamos sin BD
        $conexion=new mysqli($host, $usuario
        ,  $password);
        $sql="CREATE DATABASE $nombre_bd";
        $conexion->query($sql);
        //Ya está creada la BD
        //Ahora me conecto a esa BD y creo la tabla
        $conexion->close();
        $conexion=new mysqli($host, $usuario
        ,  $password, $nombre_bd);
        $sql="CREATE TABLE contactos(
            nombre varchar(20), telefono varchar (20))";
        $conexion->query($sql);
        $conexion->close();
    }  
}  
function insertarDatos($rrwfewr, $wewdfdft)
{
    global $usuario, $password, $nombre_bd, $host;
    $conexion=new mysqli($host, $usuario
        ,  $password, $nombre_bd);
    $sql="INSERT INTO contactos (nombre, telefono) VALUES(\"$rrwfewr\", \"$wewdfdft\")";
    $conexion->query($sql);
    $conexion->close();
        
}
function pintarTablaContactos()
{
    global $usuario, $password, $nombre_bd, $host;
    $conexion=new mysqli($host, $usuario
    ,  $password, $nombre_bd);
    $query="SELECT * FROM contactos";
    //Objeto de tipo mysqli_result 
    $objeto_resultado=$conexion->query($query);
    $array_datos=$objeto_resultado->fetch_all();
    
    echo "<table border=1>";
    for($i=0; $i<count($array_datos); $i=$i+1)
        {
           $arr_asociativo=$array_datos[$i];
            $nombre=$arr_asociativo[0];
            $telefono=$arr_asociativo[1];
            echo "<tr><td>$nombre</td><td>$telefono</td></tr>";
           // echo "NOMBRE: $nombre. TELEFONO: $telefono";
        }
    echo "</table>";

$conexion->close();
}

function insertar_datos($contacto)
{
    global $usuario, $password, $nombre_bd, $host;
    $conexion=new mysqli($host, $usuario
        ,  $password, $nombre_bd);
    $nombre=$contacto->get_nombre();
    $telefono=$contacto->get_telefono();
    $sql="INSERT INTO contactos (nombre, telefono) VALUES(\"$nombre\", \"$telefono\")";
    $conexion->query($sql);
    $conexion->close();
}




?>