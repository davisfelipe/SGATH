    $(document).ready(function(){
        ponerHora();
        $('#hora').html(darHora());
        $("#principal").load("http://localhost:8084/sgath/acceso.html");
    });
