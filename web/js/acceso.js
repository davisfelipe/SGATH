    $(document).ready(function(){
   $('#enviarAcceso').click(function(){
       var user=$('#user').val();
       var pass=$('#pass').val();
       $.ajax({
           type:'POST',
           data:{opcion:1,user:user,pass:pass},
           url:"AjaxAcceso",
           success: function(result){
               if(result=="true"){
                   $.ajax({
                       type:'POST',
                       data:{opcion:2,user:user},
                       url:"AjaxAcceso",
                       success:function(result){
                           ventanaAnalista();
                       }
                   });
               }else{
                   $('#mensajeAcceso').html("<h3><center>Acceso Denegado</center><h3>");
               }            
           }
       });
   });
});
function ventanaAnalista(){
    window.location.assign("http://localhost:8084/sgath/moduloAnalista.html");
}
function ventanaAspirante(){
    
}