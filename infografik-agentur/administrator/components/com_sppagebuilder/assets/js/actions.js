jQuery(function(o){o("#adminForm").on("submit",function(e){"page.cancel"!=o("#form_task").val()&&e.preventDefault()});window.onbeforeunload=function(e){if(void 0!==window.warningAtReload&&1==window.warningAtReload){var a="Do you want to lose unsaved data?";return(e=e||window.event)&&(e.returnValue=a),a}return null},o("#btn-save-page, #sp-pagebuilder-btn-save, #btn-save-copy, #btn-save-new, #btn-save-close").on("click",function(t){t.preventDefault();var i=o(this),e=o("#adminForm"),a="page.apply";"btn-save-copy"==t.target.id&&(a="page.save2copy"),o("#form_task").val(a),o.ajax({type:"POST",url:pagebuilder_base+"administrator/index.php?option=com_sppagebuilder&task=page."+a,data:e.serialize(),beforeSend:function(){i.find(".fa-save").removeClass("fa-save").addClass("fa-spinner fa-spin")},success:function(e){try{var a=o.parseJSON(e);i.find(".fa").removeClass("fa-spinner fa-spin").addClass("fa-save");var n="success";if(!a.status)n="error";if(a.title&&o("#jform_title").val(a.title),a.id&&o("#jform_id").val(a.id),o('<div class="notify-'+n+'">'+a.message+"</div>").css({opacity:0,"margin-top":-15,"margin-bottom":0}).animate({opacity:1,"margin-top":0,"margin-bottom":15},200).prependTo(".sp-pagebuilder-notifications"),void 0!==window.warningAtReload&&1==window.warningAtReload&&(window.warningAtReload=!1),o(".sp-pagebuilder-notifications").find(">div").each(function(){var e=o(this);setTimeout(function(){e.animate({opacity:0,"margin-top":-15,"margin-bottom":0},200,function(){e.remove()})},3e3)}),!a.status)return;window.history.replaceState("","",a.redirect),a.frontend_editor_url&&(0===o("#btn-page-frontend-editor").length?o("#btn-page-options").parent().before('<div class="sp-pagebuilder-btn-group"><a id="btn-page-frontend-editor" target="_blank" href="'+a.frontend_editor_url+'" class="sp-pagebuilder-btn sp-pagebuilder-btn-info"><i class="fa fa-edit"></i> '+Joomla.JText._("COM_SPPAGEBUILDER_FRONTEND_EDITOR")+"</a></div>\n"):o("#btn-page-frontend-editor").attr("href",a.frontend_editor_url)),a.preview_url&&(0===o("#btn-page-preview").length?o("#btn-page-options").parent().before('<div class="sp-pagebuilder-btn-group"><a id="btn-page-preview" target="_blank" href="'+a.preview_url+'" class="sp-pagebuilder-btn sp-pagebuilder-btn-inverse"><i class="fa fa-eye"></i> '+Joomla.JText._("COM_SPPAGEBUILDER_PREVIEW")+"</a></div>\n"):o("#btn-page-preview").attr("href",a.preview_url)),"btn-save-new"==t.target.id&&(window.location.href="index.php?option=com_sppagebuilder&view=page&layout=edit"),"btn-save-close"==t.target.id&&(window.location.href="index.php?option=com_sppagebuilder&view=pages")}catch(e){window.location.href="index.php?option=com_sppagebuilder&view=pages"}}})})});