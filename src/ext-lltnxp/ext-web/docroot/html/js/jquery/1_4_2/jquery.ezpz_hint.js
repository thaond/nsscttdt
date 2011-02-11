// EZPZ Hint v1.1.1; Copyright (c) 2009 Mike Enriquez, http://theezpzway.com; Released under the MIT License
(function($){
	$.fn.hint = function(options){
		var defaults = {
			hintClass: 'ezpz-hint',
			hintName: 'ezpz_hint_dummy_input'
		};
		var settings = $.extend(defaults, options);
		
		return this.each(function(){
			var hint;
			var dummy_input;
			
			// grab the input's title attribute
			text = $(this).attr('title');
			
			// create a dummy input and place it before the input
			$(this).clone()
						.attr('name','temp')
						.attr('id', null)
						.val('')
						.insertBefore($(this));
			
			// set the dummy input's attributes
			hint = $(this).prev($(this).get(0).tagName + ':first');
			hint.attr('class', $(this).attr('class'));
			hint.attr('size', $(this).attr('size'));
			hint.attr('name', settings.hintName);
			hint.attr('autocomplete', 'off');
			hint.attr('tabIndex', $(this).attr('tabIndex'));
			hint.addClass(settings.hintClass);
			if ($.nodeName(hint.get(0), 'input')) {
				hint.val(text);
			} else {
				hint.text(text);
			}
			
			// hide the input
			$(this).hide();
			
			// don't allow autocomplete (sorry, no remember password)
			$(this).attr('autocomplete', 'off');
			
			// bind focus event on the dummy input to swap with the real input
			hint.focus(function(){
				dummy_input = $(this);
				$(this).next($(this).get(0).tagName + ':first').show();
				$(this).next($(this).get(0).tagName + ':first').focus();
				$(this).next($(this).get(0).tagName + ':first').unbind('blur').blur(function(){
					if ($(this).val() == '') {
						$(this).hide();
						dummy_input.show();
					}
				});
				$(this).hide();
			});
			
			// swap if there is a default value
			if ($(this).val() != ''){
				hint.focus();
			};
			
			// remove the dummy inputs so that they don't get submitted
			$('form').submit(function(){
				$('.' + settings.hintName).remove();
			});
		});
		
	};
})(jQuery);