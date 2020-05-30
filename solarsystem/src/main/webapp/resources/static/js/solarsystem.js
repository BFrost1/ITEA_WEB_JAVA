	$('#descriptions > li > h2').mouseover(function() {
	  $('.'+ $(this).attr('id')).addClass('lineColoor');
	});
	
	$('#descriptions > li > h2').mouseout(function() {
	  $('.'+ $(this).attr('id')).removeClass('lineColoor');
	});