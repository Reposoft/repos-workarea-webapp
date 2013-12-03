$(document).ready(function(){
	$('#commit').dialog({
    	resizable: false,
    	height:300,
    	modal: true,
    	buttons: {
        	'Commit files': function() {
        		$.post($('#commitFiles').text());
        		$(this).dialog('close');
        	},
        	Cancel: function() {
         		$(this).dialog('close');
     		}
     	}
     });	
});