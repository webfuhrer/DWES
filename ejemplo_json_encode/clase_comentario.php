<?php
class comentario{
    public $usuario;
    public $comentario;
    public $hora;
function __construct($usuario, $comentario, $hora)
    {
        $this->usuario=$usuario;
        $this->comentario=$comentario;
        $this->hora=$hora;
    }


}


?>