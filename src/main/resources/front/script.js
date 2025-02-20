var socket = new SockJS("http://localhost:5321/ws");
var stompClient = Stomp.over(socket);

stompClient.connect({}, function (frame) {
    console.log("Connected: " + frame);
    stompClient.subscribe("/topic/ticket", function (message) {
        let response = JSON.parse(message.body)["response"];
        document.getElementById("response").innerText = "Талон создан: " + response;
    });
    stompClient.subscribe("/topic/updateTicket", function (message) {
        console.log("Received Ticket Update:", message.body);

        let ticket;
        try {
            ticket = JSON.parse(message.body); // Directly parse, no ["ticket"]
        } catch (error) {
            console.error("Error parsing ticket update:", error);
            return;
        }

        if (ticket && ticket.id) {
            document.getElementById("placeId").value = ticket.placeId;
            document.getElementById("provisionId").value = ticket.provisionId;
            document.getElementById("saveBtn").style.display = "inline-block";
        } else {
            alert("Талон не найден");
        }
    });
});

function sendTicket() {
    if (!stompClient || !stompClient.connected) {
        alert("WebSocket connection is not ready. Please wait...");
        return;
    }
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

    if (!ticketId) {
        alert("Введите ID билета для обновления!");
        return;
    }

    // Запрашиваем данные билета по его ID
    stompClient.send("/app/updateTicket", {}, JSON.stringify({ id: parseInt(ticketId) }));
}

// Обработчик получения данных билета


// Функция для сохранения изменений
function saveUpdatedTicket() {
    let ticketId = prompt("Введите ID билета для сохранения изменений");

    if (!ticketId) {
        alert("Введите ID билета!");
        return;
    }

    let placeId = document.getElementById("placeId").value;
    let provisionId = document.getElementById("provisionId").value;

    if (!placeId || !provisionId) {
        alert("Введите Place ID и Provision ID!");
        return;
    }

    let updatedTicketResponse = {
        id: parseInt(ticketId),
        placeId: parseInt(placeId),
        provisionId: parseInt(provisionId)
    };

    stompClient.send("/app/updateTicket", {}, JSON.stringify(updatedTicketResponse));

    // Скрываем кнопку "Сохранить"
    document.getElementById("saveBtn").style.display = "none";
}

function deleteTicket() {
    let ticketId = prompt("Введите ID билета для удаления");

    if (!ticketId) {
        alert("Введите ID билета для удаления!");
        return;
    }

    stompClient.send("/app/deleteTicket", {}, JSON.stringify({ id: parseInt(ticketId) }));
}