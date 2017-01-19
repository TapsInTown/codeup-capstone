/**
 * Created by joshua on 1/18/17.
 */
"use strict";

//navbar js
function openNav() {
    document.getElementById("navigation").style.width = "25%";
    document.getElementById("move").style.marginLeft = "0";
    document.getElementById("bodies").style.marginLeft = "30%";
    document.getElementById("specific-events").style.marginLeft = "110%";
    document.getElementById("specific-events").style.opacity = "0";
    /*document.body.style.backgroundColor = "white";*/ /*rgba(0,0,0,0.4)*/

}

function closeNav() {
    document.getElementById("navigation").style.width = "0";
    document.getElementById("move").style.marginLeft = "0";
    document.getElementById("contact-info").style.height="0";
    document.getElementById("navigation").style.paddingTop="0";
    document.getElementById("bodies").style.marginLeft = "10%";
    document.getElementById("specific-events").style.marginLeft = "75%";
    document.getElementById("specific-events").style.opacity = "1";
    /*document.body.style.backgroundColor = "white";*/
}

function openContact() {
    document.getElementById("contact-info").style.height = "100%";
    document.getElementById("navigation").style.paddingTop="10rem";
}
function closeContact() {
    document.getElementById("navigation").style.paddingTop="0";
    document.getElementById("contact-info").style.height = "0";

}

/*
$(document).ready(function(){
        console.log("success");
    $("#move").click(function(){
        $("#specific-events").fadeOut("110%")
    })});

$(document).ready(function(){
    $("#bodies").click(function(){
        $("#specific-events").fadeIn("75%")
    })});*/
