$(document).ready(function(){
    ponerHora();
    $('#hora').html(darHora());
    $.ajax({
       type:'POST',
       data:{opcion:1},
       url:"AjaxAnalista",
       success:function(result){
           $('#identificacion').html("<h4>Bienvenido "+result+"</h4>");
       }
   });
   $('#cerrarsesion').click(function(){
       $.ajax({
           type:"POST",
           data:{opcion:2},
           url:"AjaxAnalista",
           success:function(result){
               ventanaInicio();
           }
       });
   });
});
function ventanaInicio(){
    window.location.assign("http://localhost:8084/sgath/index.html");
}
