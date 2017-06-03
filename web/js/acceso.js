$(document).ready(function(){
   $('#enviarAcceso').click(function(){
       var user=$('#user').val();
       $.ajax({
           type:'POST',
           data:{action:user},
           url:"AjaxAcceso",
           success: function(result){
               $('#mensajeAcceso').html(result);
           }
       });
   });
});