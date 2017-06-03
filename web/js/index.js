    $(document).ready(function(){
    $("#principal").load("http://localhost:8084/sgath/acceso.html");
    darHora();
    });
    function darHora(){
        var f=new Date();
        hora=f.getHours()+":"+f.getMinutes()+":"+f.getSeconds();
        fecha=f.getDate()+"/"+f.getMonth()+"/"+f.getFullYear();
        $('#hora').html(fecha+"      "+hora);
    }
