<?php
include "clase_comentario.php";
$comentario1=new comentario("Jose", "Me encanta DWES, sobre todo cuando termina", "12.00");
$comentario2=new comentario("Ana", "A mí, ni eso", "12.01");
$comentario3=new comentario("Rober", "A mí me gusta hasta ..", "12.03");
$lista_comentarios=[$comentario1, $comentario2, $comentario3];
var_dump($lista_comentarios);
echo "<br>VOY A CONVERTIRLO EN JSON:<br>";
$respuesta=json_encode($lista_comentarios);
echo $respuesta;



?>