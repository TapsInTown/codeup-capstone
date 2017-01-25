/**
 * Created by joshua on 1/18/17.
 */
"use strict";

/*Navbar js*/

// function openNav() {
    // document.getElementById("navigation").style.width = "25%";
    // document.getElementById("specific-events").style.marginLeft = "110%";
    // document.getElementById("specific-events").style.opacity = "0";
    // document.getElementsByClassName("move")[0].style.marginLeft = "0";
    // document.getElementsByClassName("bodies")[0].style.marginLeft = "30%";
// / }

$(document).ready(function(){
    $(".ham-img").click(function() {
        $(".container-fluid").toggleClass("open-nav");
        $("#navigation").toggleClass("main-shift");
    });



//
// function closeNav() {
//     document.getElementById("navigation").style.width = "0";
//     document.getElementById("navigation").style.paddingTop="0";
//     document.getElementById("specific-events").style.marginLeft = "75%";
//     document.getElementById("specific-events").style.opacity = "1";
//     document.getElementsByClassName("move")[0].style.marginLeft = "0";
//     document.getElementsByClassName("bodies")[0].style.marginLeft = "10%";
// }

function openContact() {
    document.getElementById("contact-info").style.height = "100%";
    document.getElementById("navigation").style.paddingTop="10rem";
}
function closeContact() {
    document.getElementById("navigation").style.paddingTop="0";
    document.getElementById("contact-info").style.height = "0";

}


/*sticky title*/

function sticky_relocate() {
    var window_top = $(window).scrollTop();
    var div_top = $('#sticky-anchor').offset().top;
    if (window_top > div_top) {
        $('#tapsTitle').addClass('stick');
        $('#tapsTitle').addClass('hvr-sink');
        $('#sticky-anchor').height($('#tapsTitle').outerHeight());
    } else {
        $('#tapsTitle').removeClass('stick');
        $('#tapsTitle').removeClass('hvr-sink');
        $('#sticky-anchor').height(0);
    }
}

$(function() {
    $(window).scroll(sticky_relocate);
    sticky_relocate();
});

/*Sliding Card Js*/

$(document).ready(function(){
    $(".mapBar").click(function(){
        $(".mapBar").toggleClass("openMapBar");
        $(".mapCanvas").toggle("mapCanvas");
        $("#card-hide").toggle("card-hide");
        /*$(".mapBar").toggle(doIt());*/
        doIt()
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
            lat: 29.426791,
            lng: -98.489602
        }
    };console.log(mapOptions);
    var map = new google.maps.Map(document.getElementsByClassName('mapCanvas')[0], mapOptions);
    var geocoder = new google.maps.Geocoder();
    geocoder.geocode({"address": address}, function (results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            console.log(results);
            map.setCenter(results[0].geometry.location);
        } else {
            alert("Geocoding was not successful - STATUS: " + status);
        }
    });
}});
