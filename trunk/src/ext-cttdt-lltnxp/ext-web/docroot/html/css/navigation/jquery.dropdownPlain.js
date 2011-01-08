$(function(){

    jQuery1("ul.dropdown li").hover(function(){
    
        jQuery1(this).addClass("hover");
        jQuery1('ul:first',this).css('visibility', 'visible');
    
    }, function(){
    
        jQuery1(this).removeClass("hover");
        jQuery1('ul:first',this).css('visibility', 'hidden');
    
    });
    
    jQuery1("ul.dropdown li ul li:has(ul)").find("a:first").append(" &raquo; ");

});