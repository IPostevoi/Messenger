/**
 * Created by bakla410 on 02.05.17.
 */
var stompClient = null;
var chatName = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/messenger-websocket');
    chatName = $("#chatName").val();
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        var msg = stompClient.subscribe('/topic/chat', function (greeting) {
            showMessage(JSON.parse(greeting.body).content)
        });
    });
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function send() {
    stompClient.send("/app/chat", {}, JSON.stringify({'senderName': $("#UserName").text(), 'content': $("#message").val()}));
}

function showMessage(message) {
    $("#chat").append("<tr><td>" + $("#UserName").text() + ": " + message + "</td></tr>");
}

$(function () {
    $("#connectForm").submit(function (e) {
        return false;
    });
    $("#sendForm").submit(function (e) {
        return false;
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { send(); });
});

$( document ).ready(function() {
    console.log($("#UserName").val());
    });


