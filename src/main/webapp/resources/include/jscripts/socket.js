window.onload = function () {

    var socket = new WebSocket("ws://localhost:8080/server");


    //открытие соединения
    socket.onopen = function (event) {
        tn1.innerHTML = "соединение установлено"
    }

    //закрытие соединения
    socket.onclose = function (event) {
        if(event.wasClean){
            tn1.innerHTML = "соединение закрыто";
        }else{
            tn1.innerHTML = "соединение как-то закрыто";
        }
        tn1.innerHTML += " код:" + event.code + "\nпричина:" + event.reason;
    }

    //возникновение ошибки
    socket.onerror = function (event) {
        tn1.innerHTML = "ошибка:" + event.message;


    }
    //получение сообщения
    socket.onmessage = function (event) {
        var letter  = JSON.parse(event.data);
        tn1.innerHTML = "пришли данные от " + letter.name + "\nсообщение : " + letter.message;
    }

    //отправка сообщения
    document.forms["form"].onsubmit = function () {
        var letter  = {
            name: this.name.value,
            message: this.message.value
        }

        socket.send(JSON.stringify(letter));
        return false;
    }
}