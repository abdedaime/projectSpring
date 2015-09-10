//$('#btn-signup').click(function() {
//	//  alert('teeeeeeeeest');
//	// var a= $('#signupform').serialize();
//	// alert('value :'+a);
//	// console.log('tessssssssssst herrre');
//	 $('#signupbox').show();
//	 $('#loginbox').hide();
//});

/*$('#btn-signup').on('click', function(e) {
 e.preventDefault();
 var data = $('#signupform').serialize();
 alert(data);
 console.log('testtttttt'+data);
 $('#signupbox').show();
 $('#loginbox').hide();
 });*/

$(document).ready(function() {

	// alert("helllllo date date time");
	/* cette ligne pour utiliser calendar de bootstraap */
	$('#date').datetimepicker({
		todayBtn : "true",
		format : "yyyy-mm-dd",
		autoclose : "true",
		pickerPosition : "bottom-left",
		startView : "year",
		minView : "month",
		language : "fr"
	});

	/** pour valider le formulaire d'inscription* */

		
	$("#loginform").validate({
	    rules: {
	        email: {
	            email :true,
	            minlength : 3,
	            required: true
	        },
	        password: {
	        	minlength : 5,
	            required: true
	        }
	    },
	    highlight: function(element) {
			$(element).closest('.input-group').removeClass('has-success').addClass('has-error');
			alert("errrrrrrrrrrro");
		},
		unhighlight: function(element) {
			$(element).closest('.input-group').removeClass('has-error').addClass('has-success');
		},
	    messages: {
	        email: {
	            required: "Adresse email obligatoire"
	        },
	        password: {
	            required: "Password obligatoire"
	        }
	    }
	});

	
	
	$("#signupform").validate(
			{
				rules: {
					email: {
						required : true,
						minlength : 3,
						email:true,
						remote : {
							url: 'available.htm' ,
							type: "get",
							data: {
								email: function() {
									return $("#email").val();
								}
							}
						}
					},
					
					password: {
						required : true,
						minlength : 5
					},
					date: {
						required : true
						
					},
					
					confirmepass: {
						required : true,
						minlength : 5,
						equalTo: "#password"
					},
					nom : {
						required : true,
						minlength : 4
					},
					prenom : {
						minlength : 4,
						required : true
					}

					
				},
				highlight: function(element) {
					$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
				},
				unhighlight: function(element) {
					$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
				},
				messages: {
					email: {
						remote: "Adresse mail existe déja!"
					}
				}
			}
		);
	});

	
	

