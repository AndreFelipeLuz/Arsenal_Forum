let btn = document.querySelector('.fa-eye')

btn.addEventListener('click', ()=>{
  let inputSenha = document.querySelector('#senha')
  
  if(inputSenha.getAttribute('type') == 'password'){
    inputSenha.setAttribute('type', 'text')
  } else {
    inputSenha.setAttribute('type', 'password')
  }
})

function entrar() {
  let usuario = document.querySelector('#usuario').value;
  let senha = document.querySelector('#senha').value;
  let msgError = document.querySelector('#msgError');
  
  fetch('http://localhost:8080/Usuarios/tokenAtivacao?usuario=${encodeURIComponent(usuario)}&senha=${encodeURIComponent(senha)}')
    .then(response => response.json())
    .then(data => {
      console.log("sahljdasjkdha");
      let userValid = data.find(item => item.userCad === usuario && item.senhaCad === senha)  !== null;

      if (userValid) {
        window.location.href = '../../index.html';
        
        let mathRandom = Math.random().toString(16).substr(2);
        let token = mathRandom + mathRandom;
        
        localStorage.setItem('token', token);
        localStorage.setItem('userLogado', JSON.stringify(userValid));
      } else {
        let userLabel = document.querySelector('#userLabel');
        let senhaLabel = document.querySelector('#senhaLabel');
        
        userLabel.setAttribute('style', 'color: red');
        document.querySelector('#usuario').setAttribute('style', 'border-color: red');
        senhaLabel.setAttribute('style', 'color: red');
        document.querySelector('#senha').setAttribute('style', 'border-color: red');
        msgError.setAttribute('style', 'display: block');
        msgError.innerHTML = 'Usuário ou senha incorretos';
        document.querySelector('#usuario').focus();
      }
    })
    .catch(error => {
      console.error(error);
      msgError.innerHTML = 'Erro ao fazer a requisição';
    });
}


