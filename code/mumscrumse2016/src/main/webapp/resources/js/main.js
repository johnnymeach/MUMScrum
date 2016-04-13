$(document).ready(function(){
	//Show the active menu in the header bar
	$(".btnMenuHeader").on('click',function(){
		$('.btnMenuHeader').removeClass('btnMenuHeaderActive');
		$(this).addClass('btnMenuHeaderActive');
	});
});