$('.reg-auto').click(function(){
	$('main').css('filter', 'blur(5px)');
	$('.js-overlay-campaing').fadeIn();
});


$(document).mouseup(function(e){
	var popup = $('.js-popup-campaing');
	if(e.target != popup[0] && popup.has(e.target).length === 0){
		$('.js-overlay-campaing').fadeOut();
		$('main').css('filter','none');
	}
})	

$('.txt2').click(function() {
  if($('.card').attr('class') === 'card'){
       $('.card').attr('class','card is-flipped');
    }else{
     	$('.card').attr('class','card');
     }
});


 $('.input').each(function(){
        $(this).on('blur', function(){
            if($(this).val() != null  && $(this).val().trim() != "") {
                $(this).addClass('has-val');
            }
            else {
                $(this).removeClass('has-val');
            }
        })    
    })

  	var showPass = 0;
    $('.btn-show-pass').on('click', function(){
        if(showPass == 0) {
            $(this).next('input').attr('type','text');
            $(this).find('i').removeClass('zmdi-eye');
            $(this).find('i').addClass('zmdi-eye-off');
            showPass = 1;
        }
        else {
            $(this).next('input').attr('type','password');
            $(this).find('i').addClass('zmdi-eye');
            $(this).find('i').removeClass('zmdi-eye-off');
            showPass = 0;
        }
        
    });

$( document ).ready(function() {
       $.ajax({
            url: "country",
            type: 'POST',
            success:function(data){
                $('.js-country').append(data);
            }
        })
});





$('.reg').submit(function(){
    var error = 0;
    var regExLog = new RegExp("^[a-zA-Z0-9]{1,}((\\.|\\_|-{0,1})[a-zA-Z0-9]{1,})*@[a-zA-Z0-9]{1,}((\\.|\\_|-{0,1})[a-zA-Z0-9]{1,})*\\.[a-zA-Z]{2,}");
    var regExPass = new RegExp("(?=.*[0-9]{2,})(?=.*[a-z]{2,})(?=.*[A-Z]{2,})[0-9a-zA-Z!@#$%^&*]{8,}");
    var regName = new RegExp("^[a-zA-Z]+$");



    if(regExLog.test($("input[name='loginReg']").val())){
            
            $.ajax({
            url: "checkLogin",
            type: 'POST',
            async: false,
            data: {loginReg: ($("input[name='loginReg']").val())},
            success:function(data){
                if(data === 'true'){
                    $('#errorLoginReg').text('');
                }else{
                    $('#errorLoginReg').text('Such login exists');
                    error++;
                }
            }
        })
        }else{
            $('#errorLoginReg').text('Please enter a valid email address');
            error++;
        }

    if(regExPass.test($("input[name='passwordReg']").val())){
            $('#errorPasswordReg').text('');
        }else{
            $('#errorPasswordReg').text('Include 2 a-z, 2 A-Z, 2 0-9');
            error++;
        }


    if( $("input[name='re_passwordReg']").val()!='' && $("input[name='re_passwordReg']").val() === $("input[name='passwordReg']").val()){
            $('#errorRe_passwordReg').text('');
        }else{
            $('#errorRe_passwordReg').text('Passwords do not match');
            error++;
        }

    if(regName.test($("input[name='firstNameReg']").val()) && $("input[name='firstNameReg']").val()!=''){
            $('#errorFirstNameReg').text('');
        }else{
            $('#errorFirstNameReg').text('Enter in English');
            error++;
        }

    if( regName.test($("input[name='lastNameReg']").val()) && $("input[name='lastNameReg']").val()!=''){
            $('#errorLastNameReg').text('');
        }else{
            $('#errorLastNameReg').text('Enter in English');
            error++;
        }
    
    if( $("input[name='ageReg']").val() >= 12){
            $('#errorAgeReg').text('');
        }else{
            $('#errorAgeReg').text('Age must be between 12');
            error++;
        }

    if($("select[name='genderReg'] option:selected").text() != ''){
            $('#errorGenderReg').text('');
        }else{
            $('#errorGenderReg').text('Enter your gender');
            error++;
        }

    if($("select[name='countryReg'] option:selected").text() != ''){
            $('#errorCountryReg').text('');
        }else{
            $('#errorCountryReg').text('Select a country');
            error++;
        }
    
    if($("input[name='checkboxReg']").is(':checked')){
            $('#errorCheckReg').text('');
        }else{
            $('#errorCheckReg').text('You must agree to the terms');
            error++;
        }



    if(error === 0){
        $.ajax({
            url: "registration",
            type: 'POST',
            data: {
                list: [$("input[name='loginReg']").val(),
                $("input[name='passwordReg']").val(),
                $("input[name='re_passwordReg']").val(),
                $("input[name='firstNameReg']").val(),
                $("input[name='lastNameReg']").val(),
                $("input[name='ageReg']").val(),
                $("select[name='genderReg'] option:selected").text(),
                $("select[name='countryReg'] option:selected").text(),
                $("textarea[name='commentsReg']").val(),
                $("input[name='checkboxReg']").val()]
            },
            success:function(data){
                if(data === "true"){
                    $('.login-form-res').text("You are registered!");
                    $('.card').attr('class','card');
                    $('.reg')[0].reset();

                    $("input[name='loginReg']").removeClass('has-val');
                    $("input[name='passwordReg']").removeClass('has-val');
                    $("input[name='re_passwordReg']").removeClass('has-val');
                    $("input[name='firstNameReg']").removeClass('has-val');
                    $("input[name='lastNameReg']").removeClass('has-val');
                    $("input[name='ageReg']").removeClass('has-val');
                    $("select[name='genderReg']").removeClass('has-val');
                    $("select[name='countryReg']").removeClass('has-val');
                    $("textarea[name='commentsReg']").removeClass('has-val');
                    $("input[name='checkboxReg']").removeClass('has-val');
                }else{
                    $('#errorCheckReg').text('Something went wrong');
                }
            }
        })
    }
    return false;
});


        $('.auth').submit(function(){
                $.ajax({
                    url: "authorization",
                    type: 'POST',
                    data: {
                        login: $("input[name='emailLog']").val(),
                        password: $("input[name='passwordLog']").val()
                    },
                    success:function(data){
                        if(data === "true"){
                           location.reload();
                        }else{
                            $('#errorEmail').text('incorrect login or password');
                            $('#errorPassword').text('incorrect login or password');
                            }
                        }
                })
                return false;
        })

    $(".js_logout_account").on("click", function(){
           $.ajax({
                    url: "logout",
                    type: 'POST',
                    success:function(data){
                            location.reload();
                    }
                })
    });
        
    var a = "hello";
        
    $('.filter').submit(function(){
            var level = 6;
            if(($("input[type = checkbox]").serializeArray().length != 0)){
                jQuery.each($("input[type = checkbox]").serializeArray(), function(i, field){
                   if(field.value < level){
                        level = field.value;
                   }
                });
            }else{
                level = 0;
            }    
            $.ajax({
                url: "filter",
                type: 'POST',
                data:{
                    id: level
                },
                success:function(data){
                    $('.cell').remove();
                    $('.catalog-grid__cell').append(data); 
                    $('.fa-shopping-bag').on('click', function(){
                          $.ajax({
                                    url: "cart",
                                    type: "GET",
                                    data: {
                                        id: $(this).attr("id")
                                    },
                                    success:function(data){
                                        if(data != ""){
                                            $(".goods-cart-cells").append(data);
                                        }
                                    }
                            })
                    });
                }
            })
            return false;
    })

    
$('.fa-shopping-bag').on("click", function(){
          $.ajax({
                    url: "cart",
                    type: "GET",
                    data: {
                        id: $(this).attr("id")
                    },
                    success:function(data){
                        if(data != ""){
                            $(".goods-cart-cells").append(data);
                            $(".fa-times").on("click", function(){
                                         var id = $(this).attr("id");
                                            $.ajax({
                                                    url: "delete",
                                                    type: "POST",
                                                    data: {
                                                        id: id
                                                    },
                                                    success:function(data){
                                                        if(data === "true"){
                                                            $("#" + id).remove();

                                                        }
                                                    }
                                        })
                                });                                                       
                        }
                    }
            })
    });

$(".fa-times").on("click", function(){
            var id = $(this).attr("id");
            $.ajax({
                    url: "delete",
                    type: "POST",
                    data: {
                        id: id
                    },
                    success:function(data){
                        if(data === "true"){
                            $("#" + id).remove();

                        }
                    }
            })
    });


$(".carts").submit(function(){
            var id = [];
            var amount = [];

                $('.order').each(function() {
                    amount.push(this.value);
                    id.push(this.id);
                });
            if(id.length != 0 && amount.length != 0 && id.length === amount.length){
                $.ajax({
                    url: "./createOrder",
                    type: "POST",
                    data: {
                           list1:id,
                           list2:amount,
                        },
                        success:function(data){
                        }


                })
            }
});