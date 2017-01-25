/**
 * Created by joshua on 1/25/17.
 */
"use strict";

$(document).ready(function(){
    $(".ham-img").click(function(){
        $("#navigation").toggleClass("open-nav");
        $(".user-profile-content").toggleClass("open-nav");

    })});