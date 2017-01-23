/**
 * Created by joshua on 1/18/17.
 */
"use strict";

/*Navbar js*/
function openNav() {
    document.getElementById("navigation").style.width = "25%";
    document.getElementById("specific-events").style.marginLeft = "110%";
    document.getElementById("specific-events").style.opacity = "0";
    document.getElementsByClassName("move")[0].style.marginLeft = "0";
    document.getElementsByClassName("bodies")[0].style.marginLeft = "30%";
    document.getElementsByClassName("cards")[0].style.marginLeft = "60%";
    /*document.body.style.backgroundColor = "white";*/ /*rgba(0,0,0,0.4)*/
}

function closeNav() {
    document.getElementById("navigation").style.width = "0";
    document.getElementById("navigation").style.paddingTop="0";
    document.getElementById("specific-events").style.marginLeft = "75%";
    document.getElementById("specific-events").style.opacity = "1";
    document.getElementsByClassName("move")[0].style.marginLeft = "0";
    document.getElementsByClassName("bodies")[0].style.marginLeft = "10%";
    document.getElementsByClassName("cards")[0].style.marginLeft = "20%";
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

/*Sliding Card Js*/

$(document).ready(function(){
        console.log("success");
    $(".mapBar").click(function(){
        $(".mapBar").toggleClass("openMapBar");
    });
    $(".mapBar").hover(function(){
        $(".mapBar").toggleClass("hoverMapBar");
    })
});



