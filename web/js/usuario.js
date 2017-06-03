var usuario="dfpenah";
var nombre="davis";
var apellido="peña";
function limpiarUsuario(){
  this.usuario=null;
  this.nombre=null;
  this.apellido=null;
};
function ingresarUsuario(user,name,last){
    this.usuario=user;
    this.nombre=name;
    this.apellido=last;
};
function imprimir(){
    console.log(this.usuario);
    console.log(this.nombre);
};