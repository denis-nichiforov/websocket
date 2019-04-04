$(document).ready(function(){
    $("#button").click(function(){
        var data = {};
        data = {"user":$("#user").val(), "password":$("#password").val()};
        //
        $.ajax
        ({
            type: "POST",//Метод передачи
            data: data,//Передаваемые данные в JSON - формате
            url: 'login',//Название сервлета
            success:function(data)//Если запрос удачен
            {
                var parserData = JSON.parse(data);

                // console.log((parserData.name));
                console.log((parserData.password));

                if (parserData.name === undefined) {
                    $('#labelUser').html("");

                }


                $('#labelUser').html(parserData.name);
                $('#labelpassword').html(parserData.password);


                // var id = parserData.id;

                if (parserData.name === undefined && parserData.password === "" ){
                    document.location.href = "http://localhost:8080/main"
                }



            },
            error: function(e)//Если запрос не удачен
            {
                // console.log((parserData.name));
                // console.log((parserData.password));

            }
        });
    });
});