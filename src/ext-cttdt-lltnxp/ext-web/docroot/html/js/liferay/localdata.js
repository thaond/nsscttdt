
var noiNhan = getIssuingPlaceName();
function getIssuingPlaceName(){
	documentSendUtilClient.getIssuingPlaceName( function (data){
		if (data.length > 0) {
			noiNhan = [data.length];
			for ( var i = 0; i < data.length; i++) {
				noiNhan[i] = data[i] + "";			
			}
			
			return noiNhan;
		}
		
	});
}

var nguoiKy = getSignerName();
function getSignerName(){
	documentSendUtilClient.getSignerName( function (data){
		if (data.length > 0) {
			nguoiKy = [data.length];
			for ( var i = 0; i < data.length; i++) {
				nguoiKy[i] = data[i] + "";			
			}
			
			return nguoiKy;
		}
		
	});
}

