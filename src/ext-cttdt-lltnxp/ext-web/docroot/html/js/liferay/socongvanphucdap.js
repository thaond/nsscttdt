var danhsachsocongvan = findPmlEdmDocumentSendWithDocumentreference();

function findPmlEdmDocumentSendWithDocumentreference(){	
	pcccdocumentreceiptClient.findPmlEdmDocumentSendWithDocumentreference(function (data){
		if (data.length > 0) {
			danhsachsocongvan = [data.length];
			for ( var i = 0; i < data.length; i++) {
				danhsachsocongvan[i] = data[i].documentReference + "";			
			}
			
			return danhsachsocongvan;
		}
		
	});
}