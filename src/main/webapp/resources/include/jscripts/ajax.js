$(document).ready(function(){
    $("#button").click(function(){
        var data = {};
        data = {"user":$("#user").val(), "password":$("#password").val(),"passwordRepeat":$("#passwordRepeat").val()};
        //
        $.ajax
        ({
            type: "POST",//Метод передачи
            data: data,//Передаваемые данные в JSON - формате
            url: 'registration',//Название сервлета
            success:function(data)//Если запрос удачен
            {



                var parserData = JSON.parse(data);
                parserDate = null;

                // console.log((parserData.name));
                // console.log((parserData.password));
                // console.log((parserData.passwordRepeat));

                $('#labelUser').html(parserData.name);
                $('#labelpassword').html(parserData.password);
                $('#labelpasswordRepeat').html(parserData.passwordRepeat);

                if (parserData.name === "" && parserData.password === "" && parserData.passwordRepeat === undefined){
                    document.location.href = "http://localhost:8080/login"
                }



            },
            error: function(e)//Если запрос не удачен
            {

            }
        });
    });
});