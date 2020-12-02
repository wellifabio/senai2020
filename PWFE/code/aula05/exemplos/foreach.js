//Vetor tipo Objeto JavaScript
const nome = [
    {nom:'Alberto'},
    {nom:'Nunes'},
    {nom:'Silva'}
]

//forEach - percorrendo com uma função
console.log("Função Normal");
nome.forEach(function(val,indice,meuArray){
    console.log(val.nom+","+indice+","+meuArray[0].nom);
})

//forEach - percorrendo com função flecha
console.log("Arrow Function");
nome.forEach((val,indice,meuArray)=>{
    console.log(val.nom+","+indice+","+meuArray[0].nom);
})