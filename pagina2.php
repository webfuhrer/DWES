<!DOCTYPE html>
<html>
<head>
    <title>PAGINA 1</title>
</head>
<body>

            <?php
          
$url = "http://api.open-notify.org/iss-now.json";
$curl = curl_init($url);
curl_setopt($curl, CURLOPT_RETURNTRANSFER, TRUE);
$json = curl_exec($curl);
curl_close($curl);

$objeto_json=json_decode($json);
echo $objeto_json->iss_position->latitude;
//var_dump($objeto_json);
            ?>
       
</body>
</html>
