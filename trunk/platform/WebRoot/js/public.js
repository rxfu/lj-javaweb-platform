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
//********** selectBox******************************
  
/* slectBox全选
  * @param {Object} controlObj 控制的selectBox
  * @param {String} selectObjName 被控制的selectBox 名称
  * @memberOf {TypeName} 
  */
function selectBoxSelectAll(controlObj,selectObjName){
	if(controlObj.checked){
		$("input[name="+selectObjName+"]").each(function(){
			this.checked=true;
		});
	}else{
		$("input[name="+selectObjName+"]").each(function(){
			this.checked=false;
		});
	}
}

//**************************************************
