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

$(document).ready(
		function() {

			// alert("helllllo date date time");
			/* cette ligne pour utiliser calendar de bootstraap */
			$('.madate').datetimepicker({
				todayBtn : "true",
				format : "yyyy-mm-dd",
				autoclose : "true",
				pickerPosition : "bottom-left",
				startView : "year",
				minView : "month",
				language : "fr"
			});

			$('#datedebut').datetimepicker({
				todayBtn : "true",
				format : "yyyy-mm-dd",
				autoclose : "true",
				pickerPosition : "bottom-left",
				startView : "year",
				minView : "month",
				language : "fr"
			});

			/** pour valider le formulaire d'inscription* */

			$("#loginform").validate(
					{
						rules : {
							email : {
								email : true,
								minlength : 3,
								required : true
							},
							password : {
								minlength : 5,
								required : true
							}
						},
						highlight : function(element) {
							$(element).closest('.input-group').removeClass(
									'has-success').addClass('has-error');

						},
						unhighlight : function(element) {
							$(element).closest('.input-group').removeClass(
									'has-error').addClass('has-success');
						},
						messages : {
							email : {
								required : "Adresse email obligatoire"
							},
							password : {
								required : "Password obligatoire"
							}
						}
					});

			$("#signupform").validate(
					{
						rules : {
							email : {
								required : true,
								minlength : 3,
								email : true,
								remote : {
									url : 'available.htm',
									type : "get",
									data : {
										email : function() {
											return $("#email").val();
										}
									}
								}
							},

							password : {
								required : true,
								minlength : 5
							},
							date : {
								required : true

							},

							confirmepass : {
								required : true,
								minlength : 5,
								equalTo : "#password"
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
						highlight : function(element) {
							$(element).closest('.form-group').removeClass(
									'has-success').addClass('has-error');
						},
						unhighlight : function(element) {
							$(element).closest('.form-group').removeClass(
									'has-error').addClass('has-success');
						},
						messages : {
							email : {
								remote : "Adresse mail existe déja!"
							}
						}
					});
			// pour valider la form cv
			$("#addcvForm").validate(
					{
						rules : {
							titre : {

								minlength : 5,
								required : true
							},
							description : {
								minlength : 10,
								required : true
							}
						},
						highlight : function(element) {
							$(element).closest('.form-group').removeClass(
									'has-success').addClass('has-error');

						},
						unhighlight : function(element) {
							$(element).closest('.form-group').removeClass(
									'has-error').addClass('has-success');
						},
					// messages: {
					// email: {
					// required: "Adresse email obligatoire"
					// },
					// password: {
					// required: "Password obligatoire"
					// }
					// }
					});

		});

$(function() {
	$('.list-group.checked-list-box .list-group-item')
			.each(
					function() {

						// Settings
						var $widget = $(this), $checkbox = $('<input type="checkbox" class="hidden" />'), color = ($widget
								.data('color') ? $widget.data('color')
								: "primary"), style = ($widget.data('style') == "button" ? "btn-"
								: "list-group-item-"), settings = {
							on : {
								icon : 'glyphicon glyphicon-check'
							},
							off : {
								icon : 'glyphicon glyphicon-unchecked'
							}
						};

						$widget.css('cursor', 'pointer')
						$widget.append($checkbox);

						// Event Handlers
						$widget.on('click',
								function() {
									$checkbox.prop('checked', !$checkbox
											.is(':checked'));
									$checkbox.triggerHandler('change');
									updateDisplay();
								});
						$checkbox.on('change', function() {
							updateDisplay();
						});

						// Actions
						function updateDisplay() {
							var isChecked = $checkbox.is(':checked');

							// Set the button's state
							$widget.data('state', (isChecked) ? "on" : "off");

							// Set the button's icon
							$widget
									.find('.state-icon')
									.removeClass()
									.addClass(
											'state-icon '
													+ settings[$widget
															.data('state')].icon);

							// Update the button's color
							if (isChecked) {
								$widget.addClass(style + color + ' active');
							} else {
								$widget.removeClass(style + color + ' active');
							}
						}

						// Initialization
						function init() {

							if ($widget.data('checked') == true) {
								$checkbox.prop('checked', !$checkbox
										.is(':checked'));
							}

							updateDisplay();

							// Inject the icon if applicable
							if ($widget.find('.state-icon').length == 0) {
								$widget.prepend('<span class="state-icon '
										+ settings[$widget.data('state')].icon
										+ '"></span>');
							}
						}
						init();
					});

	$('#get-checked-data').on('click', function(event) {
		event.preventDefault();
		var checkedItems = {}, counter = 0;
		$("#check-list-box li.active").each(function(idx, li) {
			checkedItems[counter] = $(li).text();
			counter++;
		});
		$('#display-json').html(JSON.stringify(checkedItems, null, '\t'));
	});
});

$(document).ready(
		function() {
			$('.next').on(
					'click',
					function() {
						var current = $(this).data('currentBlock'), next = $(
								this).data('nextBlock');

						// only validate going forward. If current group is
						// invalid, do not go further
						// .parsley().validate() returns validation result AND
						// show errors
						if (next > current)
							if (false === $('#demo-form').parsley().validate(
									'block' + current))
								return;

						// validation was ok. We can go on next step.
						$('.block' + current).removeClass('show').addClass(
								'hidden');

						$('.block' + next).removeClass('hidden').addClass(
								'show');

					});
		});

// jQuery time
var current_fs, next_fs, previous_fs; // fieldsets
var left, opacity, scale; // fieldset properties which we will animate
var animating; // flag to prevent quick multi-click glitches

$(".next").click(function() {
	if (animating)
		return false;
	animating = true;

	current_fs = $(this).parent();
	next_fs = $(this).parent().next();

	// activate next step on progressbar using the index of next_fs
	$("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");

	// show the next fieldset
	next_fs.show();
	// hide the current fieldset with style
	current_fs.animate({
		opacity : 0
	}, {
		step : function(now, mx) {
			// as the opacity of current_fs reduces to 0 - stored in "now"
			// 1. scale current_fs down to 80%
			scale = 1 - (1 - now) * 0.2;
			// 2. bring next_fs from the right(50%)
			left = (now * 50) + "%";
			// 3. increase opacity of next_fs to 1 as it moves in
			opacity = 1 - now;
			current_fs.css({
				'transform' : 'scale(' + scale + ')'
			});
			next_fs.css({
				'left' : left,
				'opacity' : opacity
			});
		},
		duration : 800,
		complete : function() {
			current_fs.hide();
			animating = false;
		},
		// this comes from the custom easing plugin
		easing : 'easeInOutBack'
	});
});

$(".previous").click(
		function() {
			if (animating)
				return false;
			animating = true;

			current_fs = $(this).parent();
			previous_fs = $(this).parent().prev();

			// de-activate current step on progressbar
			$("#progressbar li").eq($("fieldset").index(current_fs))
					.removeClass("active");

			// show the previous fieldset
			previous_fs.show();
			// hide the current fieldset with style
			current_fs.animate({
				opacity : 0
			}, {
				step : function(now, mx) {
					// as the opacity of current_fs reduces to 0 - stored in
					// "now"
					// 1. scale previous_fs from 80% to 100%
					scale = 0.8 + (1 - now) * 0.2;
					// 2. take current_fs to the right(50%) - from 0%
					left = ((1 - now) * 50) + "%";
					// 3. increase opacity of previous_fs to 1 as it moves in
					opacity = 1 - now;
					current_fs.css({
						'left' : left
					});
					previous_fs.css({
						'transform' : 'scale(' + scale + ')',
						'opacity' : opacity
					});
				},
				duration : 800,
				complete : function() {
					current_fs.hide();
					animating = false;
				},
				// this comes from the custom easing plugin
				easing : 'easeInOutBack'
			});
		});

$(".submit").click(function() {
	return false;
})
