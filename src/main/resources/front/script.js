// var socket = new SockJS("http://localhost:5321/ws");
// var stompClient = Stomp.over(socket);
//
// stompClient.connect({}, function (frame) {
//     console.log("Connected: " + frame);
//     stompClient.subscribe("/topic/ticket", function (message) {
//         let response = JSON.parse(message.body)["response"];
//         document.getElementById("response").innerText = "Талон создан: " + response;
//     });
// });
//
// function sendTicket() {
//     let placeId = document.getElementById("placeId").value;
//     let provisionId = document.getElementById("provisionId").value;
//
//     if (!placeId || !provisionId) {
//         alert("Введите Place ID и Provision ID!");
//         return;
//     }
//
//     let ticketRequest = {
//         placeId: parseInt(placeId),
//         provisionId: parseInt(provisionId)
//     };
//
//     stompClient.send("/app/ticket", {}, JSON.stringify(ticketRequest));
// }
// function updateTicket() {
//     let ticketId = prompt("Введите ID билета для обновления");
//
//     if (!ticketId) {
//         alert("Введите ID билета для обновления!");
//         return;
//     }
//
//     // Запрашиваем данные билета по его ID
//     stompClient.send("/app/updateTicket", {}, JSON.stringify({ id: parseInt(ticketId) }));
// }
//
// // Обработчик получения данных билета
// stompClient.subscribe("/topic/updateTicket", function (message) {
//     let ticket = JSON.parse(message.body)["ticket"];
//
//     if (ticket) {
//         // Заполняем поля формы текущими значениями билета
//         document.getElementById("placeId").value = ticket.placeId;
//         document.getElementById("provisionId").value = ticket.provisionId;
//
//         // Показываем кнопку "Сохранить"
//         document.getElementById("saveBtn").style.display = "inline-block";
//     } else {
//         alert("Талон не найден");
//     }
// });
//
// // Функция для сохранения изменений
// function saveUpdatedTicket() {
//     let ticketId = prompt("Введите ID билета для сохранения изменений");
//
//     if (!ticketId) {
//         alert("Введите ID билета!");
//         return;
//     }
//
//     let placeId = document.getElementById("placeId").value;
//     let provisionId = document.getElementById("provisionId").value;
//
//     if (!placeId || !provisionId) {
//         alert("Введите Place ID и Provision ID!");
//         return;
//     }
//
//     let updatedTicketResponse = {
//         id: parseInt(ticketId),
//         placeId: parseInt(placeId),
//         provisionId: parseInt(provisionId)
//     };
//
//     stompClient.send("/app/updateTicket", {}, JSON.stringify(updatedTicketResponse));
//
//     // Скрываем кнопку "Сохранить"
//     document.getElementById("saveBtn").style.display = "none";
// }
//
// function deleteTicket() {
//     let ticketId = prompt("Введите ID билета для удаления");
//
//     if (!ticketId) {
//         alert("Введите ID билета для удаления!");
//         return;
//     }
//
//     stompClient.send("/app/deleteTicket", {}, JSON.stringify({ id: parseInt(ticketId) }));
// }

// var socket = new SockJS("http://localhost:5321/ws");
// var stompClient = Stomp.over(socket);
//
// stompClient.connect({}, function (frame) {
//     console.log("Connected: " + frame);
//
//     // Подписка на получение ответа по созданию билета
//     stompClient.subscribe("/topic/ticket", function (message) {
//         let response = JSON.parse(message.body)["response"];
//         document.getElementById("response").innerText = "Талон создан: " + response;
//     });
//
//     // Подписка на получение данных для обновления билета
//     stompClient.subscribe("/topic/updateTicket", function (message) {
//         let ticket = JSON.parse(message.body)["ticket"];
//
//         if (ticket) {
//             // Заполняем поля формы текущими значениями билета
//             document.getElementById("placeId").value = ticket.placeId;
//             document.getElementById("provisionId").value = ticket.provisionId;
//
//             // Показываем кнопку "Сохранить"
//             document.getElementById("saveBtn").style.display = "inline-block";
//         } else {
//             alert("Талон не найден");
//         }
//     });
// });
//
// // Функция для отправки запроса на создание билета
// function sendTicket() {
//     let placeId = document.getElementById("placeId").value;
//     let provisionId = document.getElementById("provisionId").value;
//
//     if (!placeId || !provisionId) {
//         alert("Введите Place ID и Provision ID!");
//         return;
//     }
//
//     let ticketRequest = {
//         placeId: parseInt(placeId),
//         provisionId: parseInt(provisionId)
//     };
//
//     stompClient.send("/app/ticket", {}, JSON.stringify(ticketRequest));
// }
//
// // Функция для запроса на обновление билета
// function updateTicket() {
//     let ticketId = prompt("Введите ID билета для обновления");
//
//     if (!ticketId) {
//         alert("Введите ID билета для обновления!");
//         return;
//     }
//
//     // Запрашиваем данные билета по его ID
//     stompClient.send("/app/updateTicket", {}, JSON.stringify({ id: parseInt(ticketId) }));
// }
//
// // Функция для сохранения изменений билета
// function saveUpdatedTicket() {
//     let ticketId = prompt("Введите ID билета для сохранения изменений");
//
//     if (!ticketId) {
//         alert("Введите ID билета!");
//         return;
//     }
//
//     let placeId = document.getElementById("placeId").value;
//     let provisionId = document.getElementById("provisionId").value;
//
//     if (!placeId || !provisionId) {
//         alert("Введите Place ID и Provision ID!");
//         return;
//     }
//
//     let updatedTicketResponse = {
//         id: parseInt(ticketId),
//         placeId: parseInt(placeId),
//         provisionId: parseInt(provisionId)
//     };
//
//     stompClient.send("/app/updateTicket", {}, JSON.stringify(updatedTicketResponse));
//
//     // Скрываем кнопку "Сохранить" после сохранения изменений
//     document.getElementById("saveBtn").style.display = "none";
// }
//
// // Функция для удаления билета
// function deleteTicket() {
//     let ticketId = prompt("Введите ID билета для удаления");
//
//     if (!ticketId) {
//         alert("Введите ID билета для удаления!");
//         return;
//     }
//
//     stompClient.send("/app/deleteTicket", {}, JSON.stringify({ id: parseInt(ticketId) }));
// }
//
//
// ------------------------------------------


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
        } else {
            alert("Талон не найден");
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
}

function saveUpdatedTicket() {
    let ticketId = prompt("Введите ID билета для сохранения изменений");

    console.log("Сохранение изменений билета с ID: ", ticketId);

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

    console.log("Отправка обновленного билета: ", updatedTicketResponse);

    stompClient.send("/app/updateTicket", {}, JSON.stringify(updatedTicketResponse));
    document.getElementById("saveBtn").style.display = "none";
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
