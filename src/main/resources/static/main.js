/**
 * Created by joshua on 1/18/17.
 */
"use strict";

/* logout link on the nav bar */
var logoutSubmit = function() {
    var logoutBtn = document.getElementById('logout-btn');

    var logoutForm = document.getElementById('logout');
    if (logoutBtn != null) {
        logoutBtn.addEventListener('click', function (e) {
            logoutForm.submit();
        });
    }
};
logoutSubmit();

function openContact() {
    document.getElementById("contact-info").style.height = "100%";
    document.getElementById("navigation").style.paddingTop="10rem";
}
openContact();

function closeContact() {
    document.getElementById("navigation").style.paddingTop="0";
    document.getElementById("contact-info").style.height = "0";

}closeContact();

/*Navbar js*/
$(document).ready(function(){
    var toggle = 0;
    document.getElementsByClassName("ham-img")[0].addEventListener('click', function() {
        if(toggle % 2 == 0) {
            document.getElementsByClassName("container-fluid")[0].style.transition = "1s";
            document.getElementById("navigation").style.width = "20%";
            document.getElementsByClassName("move")[0].style.marginLeft = "20%";
            document.getElementsByClassName("container-fluid")[0].style.marginLeft = "20%";
        }else {
            document.getElementsByClassName("container-fluid")[0].style.transition = "1s";
            document.getElementById("navigation").style.width = "0";
            document.getElementsByClassName("move")[0].style.marginLeft = "0";
            document.getElementsByClassName("container-fluid")[0].style.marginLeft = "10%";
        }
        toggle++;
        console.log(toggle);
        console.log("success!")
    });

    });
$(document).ready(function(){

    var toggle = 0;
    document.getElementsByClassName("ham-img")[0].addEventListener('click', function() {
        if(toggle % 2 == 0) {
            document.getElementById("specific-events").style.left = "100%";
            document.getElementById("specific-events").style.opacity = "0";
            document.getElementsByClassName("bodies")[0].style.left = "20%";
        }
        else {
            document.getElementById("specific-events").style.left = "0";
            document.getElementById("specific-events").style.opacity = "1";
            document.getElementsByClassName("bodies")[0].style.left = "0";
        }
        toggle++;
        console.log(toggle);
        console.log("success!")
    });

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

/*Map Canvas*/
    function doIt(){

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
            var infowindow = new google.maps.InfoWindow({
                content: address
            });

            var marker = new google.maps.Marker({
                position: results[0].geometry.location,
                map: map,
                draggable: true,
                animation: google.maps.Animation.DROP,
                title: address
            });
            marker.addListener('mouseover', function() {
                infowindow.open(map, marker);
            });

        } else {
            alert("Geocoding was not successful - STATUS: " + status);
        }
    });

    }doIt();

function slideUp() {
    var toggle = 0;
    $("#click").click(function() {
        if(toggle % 2 == 0) {
            $('#topOfDiv').animate({
                scrollTop: $("#scrollTo").offset().top
            }, 'slow');
            console.log('run');
        } else {
            $('#topOfDiv').animate({
                scrollTop: $("#scrollTo").offset().top - 720
            }, 'slow');
        }
        toggle++;
    });

}
slideUp()
});
