//********** ajaxAnywhere 分页部分**********************
ajaxAnywhere.formName = "form1";
function ajaxPaginationInvoke(url) {
	document.form1.action = url;
	ajaxAnywhere.submitAJAX();
}
 ajaxAnywhere.getZonesToReload = function(){
         return "refreshZone";
   } 
ajaxAnywhere.onAfterResponseProcessing = function() {
}
//**************************************************