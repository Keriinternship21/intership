jQuery(function(t){var a={};t.fn.openPopupAlt=function(){t("#page-options").addClass("sp-pagebuilder-modal-overlay-after-open"),t("#page-options").find(".sp-pagebuilder-modal-content").addClass("sp-pagebuilder-modal-content-after-open"),t("body").addClass("sp-pagebuilder-modal-open"),t(".sp-pagebuilder-modal-alt .form-group").find(">input,>textarea,>select").each(function(){a[t(this).attr("id")]=t(this).val()})},t.fn.closePopupAlt=function(e){var o=t.extend({reset:!1},e);return t("#page-options").addClass("sp-pagebuilder-modal-overlay-before-close"),t("#page-options").find(".sp-pagebuilder-modal-content").addClass("sp-pagebuilder-modal-content-before-close"),t("#page-options").removeClass("sp-pagebuilder-modal-overlay-before-close sp-pagebuilder-modal-overlay-after-open"),t("#page-options").find(".sp-pagebuilder-modal-content").removeClass("sp-pagebuilder-modal-content-before-close sp-pagebuilder-modal-content-after-open"),t("body").removeClass("sp-pagebuilder-modal-open"),o.reset&&t(".sp-pagebuilder-modal-alt .form-group").find(">input,>textarea,>select").each(function(){t(this).val(a[t(this).attr("id")]),"jform_og_image"==t(this).attr("id")&&""!=a[t(this).attr("id")]&&t(this).prev(".sppb-media-preview").removeClass("no-image").attr("src",pagebuilder_base+a[t(this).attr("id")])}),this},t("#btn-page-options").on("click",function(e){e.preventDefault(),t().openPopupAlt()}),t(document).on("click",".sp-pagebuilder-modal-alt .sp-pagebuilder-modal-content-after-open",function(e){e.target===this&&t().closePopupAlt({reset:!0})}),t(document).on("click","#btn-cancel-page-options",function(e){e.preventDefault(),t().closePopupAlt({reset:!0})}),t(document).on("click","#btn-apply-page-options",function(e){t().closePopupAlt()}),t(document).on("click",".sp-pagebuilder-fontawesome-icon-input",function(e){e.preventDefault(),t(this).closest(".sp-pagebuilder-fontawesome-icon-chooser").toggleClass("open"),t(this).closest(".sp-pagebuilder-fontawesome-icon-chooser").hasClass("open")&&t(this).closest(".sp-pagebuilder-fontawesome-icon-chooser").find('input[type="text"]').focus()}),t(document).on("click",".sp-pagebuilder-fa-list-icon",function(e){e.preventDefault();var o=t(this),a=o.closest(".sp-pagebuilder-fontawesome-icon-chooser");t(this).closest("ul").find(">li").removeClass("active"),o.addClass("active"),a.find(".sp-pagebuilder-fontawesome-icon-input>span").html('<i class="fa '+o.data("fontawesome_icon")+'"></i> '+o.data("fontawesome_icon_name")),a.find(".sp-pagebuilder-addon-input-fa").val(o.data("fontawesome_icon_name")),a.addClass("sp-pagebuilder-has-fa-icon").removeClass("open")}),t(document).on("keyup",'.sp-pagebuilder-fontawesome-dropdown input[type="text"]',function(){var e=t(this).val(),o=new RegExp(".*?"+e+".*?","i");t(this).next(".sp-pagebuilder-fontawesome-icons").children().each(function(){var e=o.test(t("span",this).text());t(this).toggle(e)})}),t(document).on("click",".sp-pagebuilder-remove-fa-icon",function(e){e.stopPropagation(),e.preventDefault();var o=t(this).closest(".sp-pagebuilder-fontawesome-icon-chooser");o.removeClass("sp-pagebuilder-has-fa-icon"),o.find(".sp-pagebuilder-fontawesome-icon-input>span").html("--"+Joomla.JText._("COM_SPPAGEBUILDER_ADDON_ICON_SELECT")+"--"),o.find(".sp-pagebuilder-fontawesome-icons>li").removeClass("active"),o.find(".sp-pagebuilder-addon-input-fa").val("")}),0<t(".com_sppagebuilder #sp-pagebuilder-page-tools").length&&t(window).on("scroll",function(){if(220<t(window).scrollTop()){var e=t(".com_sppagebuilder #sp-pagebuilder-page-tools > div");t(".com_sppagebuilder #sp-pagebuilder-page-tools").addClass("fixed-sp-page-tools"),t(".com_sppagebuilder #sp-pagebuilder-page-tools").css({height:e.outerHeight()})}else t(".com_sppagebuilder #sp-pagebuilder-page-tools").removeClass("fixed-sp-page-tools"),t(".com_sppagebuilder #sp-pagebuilder-page-tools").css({height:"auto"})})});var proFeatureNotifySMS="This feature available on premium version.";function proFeatureNotice(){jQuery('<div class="notify-warning"><i class="fa fa-exclamation-triangle"></i> '+proFeatureNotifySMS+"</div>").css({opacity:0,"margin-top":-15,"margin-bottom":0}).animate({opacity:1,"margin-top":0,"margin-bottom":15},200).prependTo(".sp-pagebuilder-notifications"),jQuery(".sp-pagebuilder-notifications").find(">div").each(function(){var e=jQuery(this);setTimeout(function(){e.animate({opacity:0,"margin-top":-15,"margin-bottom":0},200,function(){e.remove()})},1200)})}