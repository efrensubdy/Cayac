function myFunction() {
    var x = document.getElementById("demo");
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
    } else {
        x.className = x.className.replace(" w3-show", "");
    }

}

function myFunction1() {
    var x = document.getElementById("demi");
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
    } else {
        x.className = x.className.replace(" w3-show", "");
    }

}

function myFunction2() {
    var x = document.getElementById("demu");
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
        myFunction3();
    } else {
        x.className = x.className.replace(" w3-show", "");
    }
}
function myFunction3() {
   var x = document.getElementById("demoAcc");
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
        x.previousElementSibling.className += " w3-green";
    } else {
        x.className = x.className.replace(" w3-show", "");
        x.previousElementSibling.className =
        x.previousElementSibling.className.replace(" w3-green", "");
    }

}
function myFunction4() {
   var x = document.getElementById("demoAcc2");
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
        x.previousElementSibling.className += " w3-green";
    } else {
        x.className = x.className.replace(" w3-show", "");
        x.previousElementSibling.className =
        x.previousElementSibling.className.replace(" w3-green", "");
    }

}

function myFunction5() {
   var x = document.getElementById("demoAcc1");
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
        x.previousElementSibling.className += " w3-green";
    } else {
        x.className = x.className.replace(" w3-show", "");
        x.previousElementSibling.className =
        x.previousElementSibling.className.replace(" w3-green", "");
    }
}
function myFunction10() {
   var x = document.getElementById("demoAcc4");
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
        x.previousElementSibling.className += " w3-green";
    } else {
        x.className = x.className.replace(" w3-show", "");
        x.previousElementSibling.className =
        x.previousElementSibling.className.replace(" w3-green", "");
    }

}

function myFunction9() {
   var x = document.getElementById("demoAcc3");
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
        x.previousElementSibling.className += " w3-green";
    } else {
        x.className = x.className.replace(" w3-show", "");
        x.previousElementSibling.className =
        x.previousElementSibling.className.replace(" w3-green", "");
    }

}


function myFunction6() {
    var x = document.getElementById("dem");
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";

    } else {
        x.className = x.className.replace(" w3-show", "");
    }
}

