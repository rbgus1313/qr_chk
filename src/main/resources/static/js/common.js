$(document).ready(function() {
	//태블릿 반응형
	var tbMql = window.matchMedia("screen and (max-width: 1023px)");

	if (tbMql.matches) {
		$("#menu").addClass('off');
	}
	$("#menu-btn").click(function(){
		$("#menu").toggleClass("off");
		$(window).trigger('resize');
	});

	// gnb
	$("nav > ul > li.has_sub > a").click(function(e) {
		if ($(this).parent().has("> ul")) {
			e.preventDefault();
		}

		if (!$(this).hasClass("on")) {
			$(this).next("ul").stop().slideDown(200);
			$(this).addClass("on");
			$(this).parent().siblings().find(" > a").removeClass("on").end().find(" > ul").stop().slideUp(200);
		} else if ($(this).hasClass("on")) {
			$(this).removeClass("on");
			$(this).next("ul").stop().slideUp(200);
		}
	});


	// sheet js 엑셀파일 다운로드
	const excelDownload = document.querySelector('#printBtn');

	function exportExcel(){
	  var wb = XLSX.utils.book_new();
	  var newWorksheet = excelHandler.getWorksheet();
	  XLSX.utils.book_append_sheet(wb, newWorksheet, excelHandler.getSheetName());
	  var wbout = XLSX.write(wb, {bookType:'xlsx',  type: 'binary'});
	  saveAs(new Blob([s2ab(wbout)],{type:"application/octet-stream"}), excelHandler.getExcelFileName());
	}

	excelDownload.addEventListener('click', exportExcel);

	var excelHandler = {
	    getExcelFileName : function(){
	        return '참여자 목록.xlsx';	//파일명
	    },
	    getSheetName : function(){
	        return '참여자 목록';//시트명
	    },
	    getExcelData : function(){
	        return document.getElementById('listData');
	    },
	    getWorksheet : function(){
	        return XLSX.utils.table_to_sheet(this.getExcelData());
	    }
	}

	function s2ab(s) {
	  var buf = new ArrayBuffer(s.length); //convert s to arrayBuffer
	  var view = new Uint8Array(buf);  //create uint8array as viewer
	  for (var i=0; i<s.length; i++) view[i] = s.charCodeAt(i) & 0xFF; //convert to octet
	  return buf;
	}



	// cm_list
	$(".cm_list > div > a").click(function() {
		var submenu = $(this).next("div.hide_view");
		if (submenu.is(":visible")) {
			submenu.removeClass("open");
		} else {
			submenu.addClass("open");
		}
	});

	// 댓글
	$(".cm_re_info > button").click(function() {
		var submenu = $(this).parent().next("div.hide_view");
		if (submenu.is(":visible")) {
			submenu.removeClass("open");
		} else {
			submenu.addClass("open");
		}
	});

	// 첨부파일
	$(".file_input input[type='file']").on('change', function() {
		var fileName = $(this).val().split('/').pop().split('\\').pop();
		$(this).parent().siblings("input[type='text']").val(fileName);
	});
	// 파일업로드 미리보기
	$('.file_upload input[type=file]').change(function(event) {
		var tmppath = URL.createObjectURL(event.target.files[0]);
		$(this).parent('label').parent('.file_upload').parent('.file_preview').find("img").attr('src', tmppath);
	});
});

// 레이어 팝업(기본)
function layerPop(popName) {
	var $layer = $("#" + popName);
	$layer.fadeIn(500).css('display', 'inline-block').wrap('<div class="overlay_t"></div>');
	$('body').css('overflow', 'hidden');
}
function layerPopClose() {
	$(".popLayer").hide().unwrap('');
	$('body').css('overflow', 'auto');
	$(".popLayer video").each(function() { this.pause(); this.load(); });
}
function layerPopClose2(popName) {
	$("#" + popName).hide().unwrap('');
	$('body').css('overflow', 'auto');
}

// 클릭시 새창 팝업 띄우기
function popup_win(str, id, w, h, scrollchk) {
	var pop = window.open(str, id, "width=" + w + ",height=" + h + ",scrollbars=" + scrollchk + ",resize=no,location=no ");
	pop.focus();
}