jQuery(function($) {
	$('ul.nav li.dropdown').hover(function() {
		  $(this).find('.dropdown-menu').stop(true, true).delay(100).fadeIn(300);
		}, function() {
		  $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeOut(100);
		});
});