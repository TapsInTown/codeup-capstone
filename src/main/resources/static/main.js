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
    /*document.getElementsByClassName("cards")[0].style.marginLeft = "30%";*/
    /*document.body.style.backgroundColor = "white";*/ /*rgba(0,0,0,0.4)*/
}

function closeNav() {
    document.getElementById("navigation").style.width = "0";
    document.getElementById("navigation").style.paddingTop="0";
    document.getElementById("specific-events").style.marginLeft = "75%";
    document.getElementById("specific-events").style.opacity = "1";
    document.getElementsByClassName("move")[0].style.marginLeft = "0";
    document.getElementsByClassName("bodies")[0].style.marginLeft = "10%";
   /* document.getElementsByClassName("cards")[0].style.marginLeft = "20%";*/
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
    $(".mapBar").click(function(){
        $(".mapBar").toggleClass("openMapBar");
        $(".mapCanvas").toggle("mapCanvas");
        $(".cards").style.paddingBottom = "0";
    });
    $(".mapBar").hover(function(){
        $(".mapBar").toggleClass("hoverMapBar");
    })
});


/*Map Canvas*/

function doIt() {
    "use strict";

    var address = document.getElementById("address").innerText;
    var mapOptions = {
        // Set the zoom level
        zoom: 18,

        center: {
            lat: 29.42375869999999,
            lng: -98.4887784
        }
    };
    var map = new google.maps.Map(document.getElementsByClassName('mapCanvas')[0], mapOptions);
    var geocoder = new google.maps.Geocoder();
    geocoder.geocode({"address": address}, function (results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            map.setCenter(results[0].geometry.location);
        } else {
            alert("Geocoding was not successful - STATUS: " + status);
        }
    });
}



