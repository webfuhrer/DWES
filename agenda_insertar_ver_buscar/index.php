<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <a href="insertardatos.php">Crear contacto</a>
    <br>
    <form action="index.php" method="POST">
        <label for="id_buscar">NOMBRE BUSCADO:</label>
        <input type="text" id="id_buscar" name="nombre_buscado" placeholder="Introduzca el nombre buscado">
        <input type="submit">
     </form>
     <?php
    /*A veces llega gente por primera vez y otras lleghan porque han hecho POST 
    en el campo de búsqueda*/
     if(isset($_POST["nombre_buscado"]))
     {
        //El usuario viene de un POST de meter un nombre
        //1-Abrir el archivo
        //2-Leer las líneas y para cada una sacar el nombre y el teléfono (explode)
        //3-Comparar si el nombre buscado cincide con el de esa línea
        //3.1-Si coincide, lo pinto en la fila de la tabla
        listarContactos($_POST["nombre_buscado"]);
       
     }
     else
     {
        //El usuario viene por primera vez
        //1-Abrir el archivo
        //2-Leer las líneas y para cada una sacar el nombre y el tlf
        //3-Pintar la fila de la tabla
        listarContactos("");

     }
     function listarContactos($nombre_buscado)
     {
        $archivo=fopen("agenda.csv", "r");
        echo "<table>";
        while(!feof($archivo))
        {
            $linea=fgets($archivo);
            $arr_datos=explode(",", $linea);
            //Si arr_datos tiene 2 elementos, tira. Si no, no hagas nada
            if (count($arr_datos)==2)
            {

                $nombre=$arr_datos[0];
                $telefono=$arr_datos[1];
                //Hay que ver si en $nombre_buscado viene algo o no
                if($nombre_buscado=="")
                {
                    //No hay que buscar
                    echo "<tr><td>$nombre</td><td>$telefono</td></tr>";
                }
                else
                {
                    //Hay que buscar
                    if(strcasecmp($nombre, $nombre_buscado)==0)
                        {
                            echo "<tr><td>$nombre</td><td>$telefono</td></tr>";
                        }
    
                }
            }
            
        }
        echo "</table>";
     }
     
     ?>
</body>
</html>