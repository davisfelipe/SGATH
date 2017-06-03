$(document).ready(function(){
    imprimir();
   $('#enviarAcceso').click(function(){
       var user=$('#user').val();
       var pass=$('#pass').val();
       $.ajax({
           type:'POST',
           data:{user:user,pass:pass},
           url:"AjaxAcceso",
           success: function(result){
               console.log(result);
               if(result=="true"){
                   window.location.replace("http://localhost:8084/sgath/moduloAnalista.html")
               }else{
                   $('#mensajeAcceso').html("<h3><center>Acceso Denegado</center><h3>");
               }            
           }
       });
   });
});