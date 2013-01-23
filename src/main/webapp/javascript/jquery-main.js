$(document).ready(function(){
	$('#checkout').click(function(){
		var now = new Date();
		var dateString = now.toDateString();
		$('#my-text').val(dateString);
		var multipleValues = $('#multipleSelect').val() || [];
		var list = 'target=';
		for(var i = 0; i < multipleValues.length; i++){
			if(i == 0){
				list += '/tmp/repos-test/' + multipleValues[i];
			}else{
				list += '&&target=/tmp/repos-test/' + multipleValues[i];
			}
		}
		$('#checkedOut').dialog({
			resizable: false,
			height: 300,
			modal: true,
			buttons: {
			'OK': function() {
				var folderName = $('#my-text').val();
				if(folderName === "")
					folderName = dateString;
				$.post("http://localhost:8088/repos/work/"+ folderName +"/checkout?"+ list);
				$(this).dialog('close');
			},
        	'Cancel': function() {
         		$(this).dialog('close');
     		}
		}});
	});
});
