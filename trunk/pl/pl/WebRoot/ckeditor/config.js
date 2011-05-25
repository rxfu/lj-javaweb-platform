/*
Copyright (c) 2003-2010, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

CKEDITOR.editorConfig = function( config )
{
config.language = 'zh-cn';
//本地使用
config.filebrowserBrowseUrl = '/../../../../../../pl/ckeditor/browse.jsp';
config.filebrowserImageBrowseUrl = '/../../../../../../pl/ckeditor/browse.jsp?type=Images';
config.filebrowserFlashBrowseUrl = '/../../../../../../pl/ckeditor/browse.jsp?type=Flashs';
config.filebrowserUploadUrl = '/../../../../../../pl/ckeditor/upload.jsp';
config.filebrowserImageUploadUrl = '/../../../../../../pl/ckeditor/upload.jsp?type=Images';
config.filebrowserFlashUploadUrl = '/../../../../../../pl/ckeditor/upload.jsp?type=Flashs';

//发布到服务器时候使用
//config.filebrowserBrowseUrl = '/../../../../../../ckeditor/browse.jsp';
//config.filebrowserImageBrowseUrl = '/../../../../../../ckeditor/browse.jsp?type=Images';
//config.filebrowserFlashBrowseUrl = '/../../../../../../ckeditor/browse.jsp?type=Flashs';
//config.filebrowserUploadUrl = '/../../../../../../ckeditor/upload.jsp';
//config.filebrowserImageUploadUrl = '/../../../../../../ckeditor/upload.jsp?type=Images';
//config.filebrowserFlashUploadUrl = '/../../../../../../ckeditor/upload.jsp?type=Flashs';

config.filebrowserWindowWidth = '640';
config.filebrowserWindowHeight = '480';
config.width = 800;
config.height = 2000;
};
