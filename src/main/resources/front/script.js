var socket = new SockJS("http://localhost:5321/ws");
var stompClient = Stomp.over(socket);

stompClient.connect({}, function (frame) {
    console.log("Connected: " + frame);

    stompClient.subscribe("/topic/ticket", function (message) {
        let response = JSON.parse(message.body)["response"];
        console.log("Получен ответ на создание билета: ", response);
        document.getElementById("response").innerText = "Талон создан: " + response;
    });

    stompClient.subscribe("/topic/updateTicket", function (message) {
        let ticket = JSON.parse(message.body)["ticket"];
        console.log("Получены данные для обновления билета: ", ticket);

        if (ticket) {
            document.getElementById("placeId").value = ticket.placeId;
            document.getElementById("provisionId").value = ticket.provisionId;
            document.getElementById("saveBtn").style.display = "inline-block";
        }
    });
});

function sendTicket() {
    let placeId = document.getElementById("placeId").value;
    let provisionId = document.getElementById("provisionId").value;

    console.log("Отправка запроса на создание билета: ", { placeId, provisionId });

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

    console.log("Запрос на обновление билета с ID: ", ticketId);

    if (!ticketId) {
        alert("Введите ID билета для обновления!");
        return;
    }

    stompClient.send("/app/updateTicket", {}, JSON.stringify({ id: parseInt(ticketId) }));

    document.getElementById("ticketDetails").style.display = "block";

    window.currentTicketId = parseInt(ticketId);

    document.getElementById("ticketDetails").scrollIntoView({ behavior: "smooth" });
}
function saveUpdatedTicket() {
    const placeId = document.getElementById("updatePlaceId").value;
    const provisionId = document.getElementById("updateProvisionId").value;
    const ticketStatusId = document.getElementById("ticketStatusId").value;

    const updatedTicket = {
        id: window.currentTicketId,
        place: placeId ? { id: parseInt(placeId) } : null,
        provision: provisionId ? { id: parseInt(provisionId) } : null,
        ticketStatus: ticketStatusId ? { id: parseInt(ticketStatusId) } : null
    };

    console.log("Отправка обновленных данных:", updatedTicket);

    stompClient.send("/app/updateTicket", {}, JSON.stringify(updatedTicket));

    document.getElementById("ticketDetails").style.display = "none";

    document.getElementById("updateForm").reset();
}

function deleteTicket() {
    let ticketId = prompt("Введите ID билета для удаления");

    console.log("Запрос на удаление билета с ID: ", ticketId);

    if (!ticketId) {
        alert("Введите ID билета для удаления!");
        return;
    }

    stompClient.send("/app/deleteTicket", {}, JSON.stringify({ id: parseInt(ticketId) }));
}
