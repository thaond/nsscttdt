//de thuc hien dung ajax cho chuc nang nay can ba file chinh[ViewAction.java, careerAjax.js, display.jsp]
//ten cua ba file nay co the thay doi theo mong muon
//dung cac phuong thuc trong ViewAction:
// - List<Career> getListCareer(String type, String keyword, String start1, String end1)
// - public void create(
//		String id, String careerCode, String careerName, String description,
//		String active) 
// - public void update(
//		String condition, String careerId, String careerCode,
//		String careerName, String description, String active) 
// - public void deleteCareer(String careerId)
// - public int totalRecord(String type, String keyword)

var careerCache = {};
var viewed = -1;
var begin = 0;
var end = 5;
var total = 0;
var valueFilter = "";
var valueKeyWord = "";

//phuong thuc nay de khoi tao khi vao trang display
function initCareer() {
	fillTable(0, 5);
	getDisplayRow();
	totalRow();
	displayPage();

}

// ham view danh sach
//lay danh sach tu vi tri bat dau(begin) toi vi tri ket thu(end)
//danh sach nay duoc filter theo truong(valueFilter) va tu khoa(keyword)
var list;
function fillTable(start, end) {
	begin = start;
	// var valueFilter = $id('selectFilter').getValue();
	valueFilter = DWRUtil.getValue('selectFilter');

	valueKeyWord = DWRUtil.getValue('keyWord');
	
	//lay du lieu tu ViewAction do vao table co id careerbody trong trang display.jsp
	ViewActionCareerClient.getListCareer(valueFilter, valueKeyWord, begin, end,
			function(listCareer) {
				// Delete all the rows except for the "pattern" row
			dwr.util.removeAllRows("careerbody", {
				filter : function(tr) {
					return (tr.id != "pattern");
				}
			});
			
			list = listCareer; //luu danh sach lay tu server vao bien list
			// Create a new set cloned from the pattern row
			var career, id;
			
			//do du lieu vao table trong trang display.jsp
			for (i = 0; i < listCareer.length; i++) {

				career = listCareer[i];
				id = career.careerId;
				
				//them dong moi trong table
				dwr.util.cloneNode("pattern", {
					idSuffix :id
				});
				//xet gia tri vao table muon hien thi 
				dwr.util.setValue("tableNo." + id, i + 1);
				dwr.util.setValue("tableCode" + id, career.careerCode);var image = "";
				if (career.active == "1"){
					image = "<img src='" + "/html/images/checked.gif' />";
				}
				else {
					image = "<img src='" + "/html/images/unchecked.gif' />";
				}
				document.getElementById("tableActive" + id).innerHTML = image;
				dwr.util.setValue("tableName" + id, career.careerName);
				dwr.util.setValue("tableDescription" + id, career.description);
				var image = "";
				if (career.active == "1"){
					image = "<img src='" + "/html/images/checked.gif' />";
				}
				else {
					image = "<img src='" + "/html/images/unchecked.gif' />";
				}
				document.getElementById("tableActive" + id).innerHTML = image;
				//dwr.util.setValue("tableActive" + id, image);
				
				//doi mau nen
				document.getElementById("pattern" + id).style.display = "";
				if(i % 2 == 0){
					document.getElementById("pattern" + id).style.backgroundColor = "#F0F5F7";
				}
				else{
					document.getElementById("pattern" + id).style.backgroundColor = "#E8E8E8";
				}
				
				//careerCache la mang de chu doi tuong career
				//careerCache la bien toan cuc luu danh sach cua career
				var idTemp = id.substring(4);
				careerCache[idTemp] = career;

			}

		});
}
// phan them
// them 1 career moi vao he thuong
// dung co condition dung de cho biet them hay edit du lieu
// dau tien phai clear du lieu rac trong form nhap
// clear value cua id
// hien thi form de nhap du lieu, form nay co id la editandaddcarrer 
var condition = "";
function addCarrer() {
	condition = "add";

	clearCareer(); //xoa du lieu rac
	dwr.util.byId("id").value = ""; //xoa gia tri cua id
	dwr.util.byId("editandaddcarrer").style.display = "inline"; //hien thi form nhap du lieu
	//displayPage(); 
}


// phan edit
// editClicked dung de edit thong tin 1 career duoc chon co id la eleid
// dung flag condition de biet update du lieu
// hien thi form nhap du lieu
// lay dong de edit
// lay du lieu do vao form de edit
function editClicked(eleid) {
	condition = "update";
	dwr.util.byId("editandaddcarrer").style.display = "inline"; //hien thi form edit
	// we were an id of the form "edit{id}", eg "editDMVT70500000021". We lookup the "70500000021"
	var career = careerCache[eleid.substring(8)]; //lay doi tuong career tuong ung trang mang cachCareer

	dwr.util.setValue("id", career.careerId); //xet gia tri vao form id
	dwr.util.setValue("code", career.careerCode); //xet gia tri vao form code
	dwr.util.setValue("name", career.careerName); //xet gia tri vao form name
	dwr.util.setValue("description", career.description); //xet gia tri vao form description
	var active = dwr.util.byId("active"); //xet gia tri vao checkbox active
	if (career.active == "0") {
		active.checked = false;

	} else {
		active.checked = true;

	}
}

//luu du lieu them moi hoac edit xuong he thong
function writeCareer() {
	
	var careerId = dwr.util.getValue("id"); //luu gia tri trong form id
	var careerCode = dwr.util.getValue("code"); //luu gia tri trong form code
	var careerName = dwr.util.getValue("name"); //luu gia tri trong form name
	var description = dwr.util.getValue("description"); //luu gia tri trong form description
	var active = dwr.util.getValue("active"); //luu gia tri trong form active
	var valueActive = "";

	if (active == false) {
		valueActive = "0";
	} else {
		valueActive = "1";
	}
	
	//validate field Code
	var fieldCode = document.getElementById("code").value;
	if (fieldCode == null || fieldCode == "" || fieldCode.length > 20) {
		//alert('Code do not empty and more than 20 characters');
		dwr.util.byId("error").style.display = "inline";
		return false;
	} 
	else {

		dwr.engine.beginBatch(); //mo transaction
		//goi ham update de luu thong tin xuong he thong
		ViewActionCareerClient.update(condition, careerId, careerCode, careerName,
				description, valueActive);
		fillTable(begin, begin + numberDisplay); //hien thi table du lieu da duoc update
		
		dwr.util.byId("editandaddcarrer").style.display = "none"; //dong table nhap du lieu
		// hien thi tong so record
		totalRow();
		displayPage();
		dwr.engine.endBatch(); //dong transaction

	}
	
}

// clear text
function clearCareer() {
	dwr.util.setValue("id", ""); //clear id
	dwr.util.setValue("code", ""); //clear code
	dwr.util.setValue("name", ""); //clear name
	dwr.util.setValue("description", ""); //clear description
	dwr.util.byId("active").checked = false; //active default is false
}

// phan xoa
// xoa 1 hang co id la eleid
function deleteClicked(eleid) {
	// we were an id of the form "delete{id}", eg "delete42". We lookup the "42"
	var career = careerCache[eleid.substring(10)]; //lay doi tuong career trong mang careerCache

	if (confirm("B\u1ea1n mu\u1ed1n x\u00f3a ngh\u1ec1 nghi\u1ec7p n\u00e0y ra kh\u1ecfi h\u1ec7 th\u1ed1ng kh\u00f4ng?")) {
		dwr.engine.beginBatch(); //mo transaction
		ViewActionCareerClient.deleteCareer(career.careerId); //goi ham deleteCareer de xoa doi tuong career
		fillTable(begin, begin + numberDisplay); //hien thi table da xoa du lieu
		// hien thi tong so record
		totalRow();
		displayPage();
		dwr.engine.endBatch(); //dong transaction

	}
}

// phan sort

var key = 0;
function sort(field) {

	var listHelp = sortHelp(field, key); //goi ham sortHelp de sap xep du lieu theo cot (field), tang/giam(key)

	// Delete all the rows except for the "pattern" row
	dwr.util.removeAllRows("careerbody", {
		filter : function(tr) {
			return (tr.id != "pattern");
		}
	});

	// Create a new set cloned from the pattern row
	var career, id;
	//do du lieu da sap xep vao table
	for (i = 0; i < listHelp.length; i++) {

		career = listHelp[i];
		id = career.careerId;

		dwr.util.cloneNode("pattern", {
			idSuffix :id
		});
		dwr.util.setValue("tableNo." + id, i + 1);
		dwr.util.setValue("tableCode" + id, career.careerCode);
		dwr.util.setValue("tableName" + id, career.careerName);
		dwr.util.setValue("tableDescription" + id, career.description);
		var image = "";
		if (career.active == "1"){
			image = "<img src='" + "/html/images/checked.gif' />";
		}
		else {
			image = "<img src='" + "/html/images/unchecked.gif' />";
		}
		document.getElementById("tableActive" + id).innerHTML = image;
		//dwr.util.setValue("tableActive" + id, career.active);

		document.getElementById("pattern" + id).style.display = "";
		
		//dat mau nen
		if(i % 2 == 0){
			document.getElementById("pattern" + id).style.backgroundColor = "#F0F5F7";
		} else{
			document.getElementById("pattern" + id).style.backgroundColor = "#E8E8E8";
		}
		
		var idTemp = id.substring(4);

		listHelp[idTemp] = career;

		if (key == 0) {
			key = 1;
		} else {
			key = 0;
		}
	}
}

//thuat toan sort
function sortHelp(field, key) {

	var len = list.length;

	for (i = 0; i < len - 1; i++) {

		for (j = i + 1; j < len; j++) {
			var str1 = "";
			var str2 = "";
			if (field == "sortCode") {
				str1 = list[i].careerCode;
				str2 = list[j].careerCode;
			}

			else {
				str1 = list[i].careerName;
				str2 = list[j].careerName;
			}

			if (key == 1) { // sort down

				if (str1 > str2) {
					var temp = list[i];
					list[i] = list[j];
					list[j] = temp;

				}
				else {
					var temp = list[j];
					list[j] = list[i];
					list[i] = temp;
				}

			} else { // sort up

				if (str1 < str2) {
					var temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
				else {
					var temp = list[j];
					list[j] = list[i];
					list[i] = temp;

				}
				
			}
		}
	}
	return list;
}

// tong row
var numberDisplay = 5; //so dong default
function totalRow() {
	ViewActionCareerClient.totalRecord(valueFilter, valueKeyWord, function(
			totalR) {
		total = totalR;
		dwr.util.byId("totalrow").innerHTML = totalR;

	});

}

// chon so dong hien thi
function getDisplayRow() {
	numberDisplay = DWRUtil.getValue("selectPC");
	end = begin + numberDisplay;
	fillTable(0, numberDisplay)
	displayPage();
}

// hien thi so trang
// so trang = tong so dong tim kiem chia cho so dong hien thi
// neu so du khac 0 thi them 1 vao so trang lam tron

function displayPage() {
	var pageInfo = "";
	//goi ham lay tong dong
	ViewActionCareerClient.totalRecord(valueFilter, valueKeyWord, function(
			totalR) {

		if (totalR % numberDisplay == 0) {
			page = (totalR / numberDisplay);
		} else {
			page = (Math.floor(totalR / numberDisplay)) + 1;
		}

		for (i = 0; i < page; i++) {
			var k = numberDisplay * i;	// k : vi tri bat dau do du lieu
			var z = numberDisplay * (i + 1);	// z : vi tri ket thuc

			pageInfo += "<span onclick=fillTable(" + k + "," + z + ") style='cursor: pointer;'>&nbsp;&nbsp;"
					+ (i + 1) + "</span>";

		}

		dwr.util.byId("numberPage").innerHTML = pageInfo;
	});
}
// phan filter
// hien thi ket qua trong trang dau
function filterData() {
	fillTable(0, 5);
	displayPage();
	totalRow();
}

//kich hoat
//update active
function changeActive(eleid){
	//tableActive

	var career = careerCache[eleid.substring(15)]; //lay doi tuong trong mang careerCache
	condition = "update";
	var valueActive = "";
	if(career.active == "1"){
		//DWRUtil.setValue(eleid,"0")
		document.getElementById(eleid).innerHTML = "<img src='" + "/html/images/unchecked.gif' />";
		valueActive = "0";
		
	}
	else{
		document.getElementById(eleid).innerHTML = "<img src='" + "/html/images/checked.gif' />";
		//DWRUtil.setValue(eleid,"1");
		valueActive = "1";
	}
	
	dwr.engine.beginBatch();// mo transaction
	
	//goi phuong thuc de update doi tuong career
	ViewActionCareerClient.update(condition, career.careerId, career.careerCode, career.careerName,
			career.description, valueActive);
	career.active = valueActive;
	careerCache[eleid.substring(15)] = career;

	dwr.engine.endBatch(); //dongtransaction
}

function cancelCareer(){
	dwr.util.byId("editandaddcarrer").style.display = "none";
}