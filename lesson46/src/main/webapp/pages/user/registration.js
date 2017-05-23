function validateEmail(event) {

    event.preventDefault();

    var email = document.getElementById("email");

    console.log(email.value);

    var emailText = email.value;

    console.log(emailText.indexOf("@") === -1);

    if(emailText.indexOf("@") === -1){
        email.style = "border-color: red";
    }


}

document.getElementById("registerBtn").addEventListener("click", validateEmail);

document.getElementById("email").addEventListener("focus", resetEmailField);

function resetEmailField(){
    document.getElementById("email").style = "";
}


