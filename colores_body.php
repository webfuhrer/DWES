<html>
<head>
	<style>
	<?php
	$rojo=rand(1, 255);
	$verde=rand(1, 255);
	$azul=rand(1,255);

	?>
	body
	{
	background-color: rgb(<?php echo $rojo?>, <?php echo $verde?>,<?php echo $azul?>);
	}
	</style>
</head>

<body>
<?php
echo rand(1, 255);
?>
</body>
</html>