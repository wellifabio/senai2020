function criarCookie(nome, valor) {
  let dtExpira = "expires = Tue, 01 Jan 2115 12:00:00 UTC";
  document.cookie = nome + "=" + valor + ";" + dtExpira;
}

function lerCookie(nome) {
  let vnome = nome + "=";
  let ca = document.cookie.split(";"); //Retorna um vetor com todos os cookies
  for (let i = 0; i < ca.length; i++) {
    var c = ca[i];
    while (c.charAt(0) == " ") {
      c = c.substring(1);
    } //Eliminar caracteres em branco
    if (c.indexOf(vnome) == 0) {
      return c.substring(vnome.length, c.length);
    }
  }
  return "";
}

function verificarCookie() {
  //Verifica se o cookie existe, se não existir ele é criado
  let username = lerCookie("username");
  if (username != "") {
    alert("Bem vindo novamente " + username);
  } else {
    username = prompt("Digite o seu nome:", "");
    if (username != "" && username != null) {
      criarCookie("username", username);
    }
  }
}
