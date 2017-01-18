/**
 * Created by joshua on 1/18/17.
 */
"use strict";
function openNav() {
    document.getElementById("navigation").style.width = "25%";
    document.getElementById("move").style.marginLeft = "25%";
    document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
}


function closeNav() {
    document.getElementById("navigation").style.width = "0";
    document.getElementById("move").style.marginLeft = "0";
    document.getElementById("contact-info").style.height="0";
    document.getElementById("navigation").style.paddingTop="0";
    document.body.style.backgroundColor = "white";
}

function openContact() {
    document.getElementById("contact-info").style.height = "40%";
    document.getElementById("navigation").style.paddingTop="20%";
}
function closeContact() {
    document.getElementById("navigation").style.paddingTop="0";
    document.getElementById("contact-info").style.height = "0";

}

function hoverOver() {
    document.getElementsByClassName("nav-link").style.backgroundColor ="color:#ffc744";

}
