<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="index.php" method="POST">
    <?php
    include "funciones.php";
if (isset($_POST["num_mesa"]) && isset($_POST["primero"]) && isset($_POST["segundo"]))
{
    recuperarGrabarDatos();
}
    crearComboMesas();
    crearComboPrimeros();
    crearComboSegundos();
    ?>
    <input type="submit">
    </form>
</body>
</html>