// Easing equation, borrowed from jQuery easing plugin
// http://gsgd.co.uk/sandbox/jquery/easing/
jQuery.easing.easeOutQuart = function (x, t, b, c, d) {
	return -c * ((t=t/d-1)*t*t*t - 1) + b;
};

jQuery(function( $ ){
		$('#slideshow').serialScroll({
			items:'li',
			prev:'#screen2 a.prev',
			next:'#screen2 a.next',
			//offset:-230, //when scrolling to photo, stop 230 before reaching it (from the left)
			start:0, //as we are centering it, start at the 2nd
			//duration:1200,
			force:true,
			stop:true,
			lock:false,
			cycle:false, //don't pull back once you reach the end
			easing:'easeOutQuart', //use this easing equation for a funny effect
			//jump: true //click on the images to scroll to them
	});
});

jQuery(function( $ ){
		$('#slideshowhelp').serialScroll({
			items:'li',
			prev:'#screen2help a.prev',
			next:'#screen2help a.next',
			//offset:-230, //when scrolling to photo, stop 230 before reaching it (from the left)
			start:0, //as we are centering it, start at the 2nd
			//duration:1200,
			force:true,
			stop:true,
			lock:false,
			cycle:false, //don't pull back once you reach the end
			easing:'easeOutQuart', //use this easing equation for a funny effect
			//jump: true //click on the images to scroll to them
	});
});
//mo