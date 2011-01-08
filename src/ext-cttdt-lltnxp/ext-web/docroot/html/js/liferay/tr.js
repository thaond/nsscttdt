/**
*******************************************************
*/

var oldBackGround = "";
function onMouseOverTr(thiss){
	var arrTd = thiss.cells;
	for(i=0; i< arrTd.length; i++) {
		oldBackGround = arrTd[i].style.background;
		arrTd[i].style.background="#bbedfc";
	}
}

/**
****************************************************
*/

function onMouseOutTr(thiss){
	var arrTd = thiss.cells;
	
	for(i=0; i< arrTd.length; i++) {
		arrTd[i].style.background=oldBackGround;
	}
}