
<?php
verificarAcceso();
function verificarAcceso()
    {
        if (!isset ($_COOKIE["cookie_nombre"]))
               {
                header("location: login.php");
                       }
    }
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="grabacontactos.php" method="POST">
    NOMBRE CONTACTO: <input type="text" name="nombre">
    <br>
    TELÉFONO CONTACTO: <input type="tel" name="telefono">
    <br>
    <input type="submit">
    </form>
</body>
</html>



<?php
if(isset($_POST["nombre"]) && isset($_POST["telefono"]))
{
    $nombre=$_POST["nombre"];
    $telefono=$_POST["telefono"];
    $fichero_agenda=fopen("agenda.csv", "a");
    $linea="$nombre,$telefono\n";
    fwrite($fichero_agenda, $linea);
    
    fclose($fichero_agenda);
    header ("Location: vercontactos.php");
}
