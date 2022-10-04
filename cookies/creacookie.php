<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
    $valor_cookie=$_POST["nombre_usuario"];
    echo "TIEMPO: ".time();
    setcookie("cookie_nombre_usuario", $valor_cookie,time()+1000 ,"/");
    ?>
    <a href="vercookie.php">Ver cookie</a>
</body>
</html>
