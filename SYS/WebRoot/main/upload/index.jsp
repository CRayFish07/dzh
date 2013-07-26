<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
<title>SWFUpload 批量上传</title>

<link href="../main/upload/css/default.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="../css/admin/style.css" />
<script type="text/javascript" src="../main/upload/swfupload/swfupload.js"></script>
<script type="text/javascript" src="../main/upload/js/swfupload.queue.js"></script>
<script type="text/javascript" src="../main/upload/js/fileprogress.js"></script>
<script type="text/javascript" src="../main/upload/js/handlers.js"></script>
<script type="text/javascript">
		var swfu;
		window.onload = function() {
			var settings = {
				flash_url : "../main/upload/swfupload/swfupload.swf",
				upload_url: "upload!add.do",
				post_params: {"img.type" : ${img.type}},
				file_size_limit : "100 MB",
				file_types : "*.jpg;*.gif;*.jpeg;*.png",
				file_types_description : "All Files",
				file_upload_limit : 100,
				file_queue_limit : 0,
				custom_settings : {
					progressTarget : "fsUploadProgress",
					cancelButtonId : "btnCancel"
				},
				debug: false,

				// Button settings
				button_image_url: "../main/upload/images/TestImageNoText_65x29.png",
				button_width: "65",
				button_height: "29",
				button_placeholder_id: "spanButtonPlaceHolder",
				button_text: '<span class="theFont">上传</span>',
				button_text_style: ".theFont { font-size: 16; }",
				button_text_left_padding: 12,
				button_text_top_padding: 3,
				
				// The event handler functions are defined in handlers.js
				file_queued_handler : fileQueued,
				file_queue_error_handler : fileQueueError,
				file_dialog_complete_handler : fileDialogComplete,
				upload_start_handler : uploadStart,
				upload_progress_handler : uploadProgress,
				upload_error_handler : uploadError,
				upload_success_handler : uploadSuccess,
				upload_complete_handler : uploadComplete,
				queue_complete_handler : queueComplete	// Queue plugin event
			};

			swfu = new SWFUpload(settings);
	     };
	</script>
</head>
<body>
<div id="content">
	<div id="main" class="main">
	<div id="gamefeatures"><h2>批量照片上传</h2></div>
	<table class="GF-listTab">
		<form id="form1" action="" method="post" enctype="multipart/form-data">
			<p>上传队列</p>
	
				<div class="fieldset flash" id="fsUploadProgress">
				<span class="legend">Upload Queue</span>
				</div>
			<div id="divStatus">0 Files Uploaded</div>
				<div>
					<span id="spanButtonPlaceHolder"></span>
					<input id="btnCancel" type="button" value="取消上传" onclick="swfu.cancelQueue();" disabled="disabled" style="margin-left: 2px; font-size: 8pt; height: 29px;" />
				</div>
	
		</form>
	</table>
	</div>
</div>
</body>
</html>
