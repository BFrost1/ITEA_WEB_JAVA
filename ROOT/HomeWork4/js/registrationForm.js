document.querySelector('.buttonReg').addEventListener('click', function() {
  if(document.querySelector('.card').getAttribute('class') === 'card'){
       document.querySelector('.card').classList.toggle('is-flipped');
     }
});

document.querySelector('.buttonLog').addEventListener('click', function() {
  if(document.querySelector('.card').getAttribute('class') === 'card is-flipped'){
       document.querySelector('.card').classList.toggle('is-flipped');
     }
});

document.querySelector('.txt2').addEventListener('click', function() {
  if(document.querySelector('.card').getAttribute('class') === 'card'){
       document.querySelector('.card').classList.toggle('is-flipped');
     }
});

document.querySelectorAll('.btn-show-pass').forEach(function(el){
    el.addEventListener('click', function() {
        var note;
        for (var i = 0; i < el.childNodes.length; i++) {
           if (el.childNodes[i].nodeName === "I") {
            note = el.childNodes[i];
            break;
            }        
        }
        var input = el.nextElementSibling;
        if(input.getAttribute('type') === 'password'){
            input.setAttribute('type','text');
            note.classList.remove('zmdi-eye');
            note.classList.add('zmdi-eye-off');
        }else{
            input.setAttribute('type','password');
            note.classList.remove('zmdi-eye-off');
            note.classList.add('zmdi-eye');
        }
})}) ;


document.querySelectorAll('.input').forEach(function(el){
    el.onblur = function() {
    if(el.value != "" ) {
        el.classList.add('has-val');
      }else {
        el.classList.remove('has-val');
      }
    }

    if(el.value != "" || el.value > 0) {
        el.classList.add('has-val');
    }else {
        el.classList.remove('has-val');
    }
});