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
function updateTicket() {
    let ticketId = prompt("Введите ID билета для обновления");
    let placeId = document.getElementById("placeId").value;
    let provisionId = document.getElementById("provisionId").value;

    if (!ticketId || !placeId || !provisionId) {
        alert("Введите ID билета, Place ID и Provision ID!");
        return;
    }

    let updateRequest = {
        id: parseInt(ticketId),
        placeId: parseInt(placeId),
        provisionId: parseInt(provisionId)
    };

    stompClient.send("/app/updateTicket", {}, JSON.stringify(updateRequest));
}

function deleteTicket() {
    let ticketId = prompt("Введите ID билета для удаления");

    if (!ticketId) {
        alert("Введите ID билета для удаления!");
        return;
    }

    stompClient.send("/app/deleteTicket", {}, JSON.stringify({ id: parseInt(ticketId) }));
}
// stompClient.connect({}, function (frame) {
//     console.log("Connected: " + frame);
//     stompClient.subscribe("/topic/ticket", function (message) {
//         let response = JSON.parse(message.body)["response"];
//         document.getElementById("response").innerText = "Талон обновлен: " + response.number;
//
//         // Если это обновление билета, заполним новые данные в форму
//         document.getElementById("placeId").value = response.place.id;
//         document.getElementById("provisionId").value = response.provision.id;
//     });
// });
//
// function sendUpdateTicket() {
//     let placeId = document.getElementById("placeId").value;
//     let provisionId = document.getElementById("provisionId").value;
//     let ticketId = document.getElementById("ticketId").value; // если у тебя есть поле для ID билета
//
//     if (!placeId || !provisionId || !ticketId) {
//         alert("Введите все данные!");
//         return;
//     }
//
//     let ticketRequest = {
//         id: ticketId,
//         placeId: parseInt(placeId),
//         provisionId: parseInt(provisionId)
//     };
//
//     stompClient.send("/app/updateTicket", {}, JSON.stringify(ticketRequest));
// }