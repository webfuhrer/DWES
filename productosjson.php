<?php
class producto
{
   public $nombre, $imagen, $precio;
}
$servername = "localhost";
$username = "root";
$password = "";

try {
  $conn = new PDO("mysql:host=$servername;dbname=tienda", $username, $password);
  // set the PDO error mode to exception
  $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
 // echo "Connected successfully";
  $sql = "SELECT * FROM productos";

  $stmt = $conn->prepare(  $sql );
    $productos=[];
    $i=0;
  foreach ($conn->query($sql) as $row) {
    $productos[$i]=new producto();
    $productos[$i]->nombre=$row['nombre'] ;
    $productos[$i]->precio=$row['precio'] ;
    $productos[$i]->imagen=$row['imagen'] ;
    $i++;
    /*echo $row['nombre'] . "<br>";
    echo $row['precio'] . "<br>";
    echo $row['imagen'] . "<br>";*/
}
$json=json_encode($productos);
echo $json;

} catch(PDOException $e) {
  echo "Connection failed: " . $e->getMessage();
}