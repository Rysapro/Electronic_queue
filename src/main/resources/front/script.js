var socket = new SockJS("http://localhost:5321/ws");
var stompClient = Stomp.over(socket);

stompClient.connect({}, function (frame) {
    console.log("Connected: " + frame);
    stompClient.subscribe("/topic/ticket", function (message) {
        let response = JSON.parse(message.body)["response"];
        document.getElementById("response").innerText = "Талон создан: " + response;
    });
});

function sendTicket() {
    let placeId = document.getElementById("placeId").value;
    let provisionId = document.getElementById("provisionId").value;

    if (!placeId || !provisionId) {
        alert("Введите Place ID и Provision ID!");
        return;
    }

    let ticketRequest = {
        placeId: parseInt(placeId),
        provisionId: parseInt(provisionId)
    };

    stompClient.send("/app/ticket", {}, JSON.stringify(ticketRequest));
}
