<?php
function recuperarGrabarDatos()
{
    $num_mesa=$_POST["num_mesa"];
    $primero=$_POST["primero"];
    $segundo=$_POST["segundo"];
    $linea="$num_mesa,$primero,$segundo\n";
    $archivo=fopen("comandas.csv", "w");
    fwrite($archivo, $linea);
    fclose($archivo);
}
function crearComboMesas()
{
$maximo_mesas=5;
/*echo "<select name='num_mesa'>";
for (...)
    {
        echo "<option value=...";
    }
echo "</select>";*/
$combo="<select name='num_mesa'>";
for ($n=1; $n<=$maximo_mesas; $n++)
    {
        $combo.="<option value=$n>$n</option>";
    }
    $combo.="</select>";
echo $combo;
}

 function   crearComboPrimeros()
 {
    $ruta_primeros="primeros.csv";
    $archivo=fopen($ruta_primeros, "r");
    $combo="<select name='primero'>";
   while(!feof($archivo))
   {
    $linea=fgets($archivo);
    $arr_datos=explode(",", $linea);
    //Comprobamos que realmente vienene dos datos:
    //Chuletón,CH
    if (count($arr_datos)==2)
        {
            $valor_comida=trim($arr_datos[1]);
            $combo.="<option value='$valor_comida'>";
            $combo.=$arr_datos[0];
            $combo.="</option>";
        }
   }
    $combo.="</select>";
    echo $combo;
 }
  function  crearComboSegundos()
  {
    $ruta_segundos="segundos.csv";
    $archivo=fopen($ruta_segundos, "r");
    $combo="<select name='segundo'>";
   while(!feof($archivo))
   {
    $linea=fgets($archivo);
    $arr_datos=explode(",", $linea);
    //Comprobamos que realmente vienene dos datos:
    //Chuletón,CH
    if (count($arr_datos)==2)
        {
            $valor_comida=trim($arr_datos[1]);
            $combo.="<option value='$valor_comida'>";
            $combo.=$arr_datos[0];
            $combo.="</option>";
        }
   }
    $combo.="</select>";
    echo $combo;
  }

?>