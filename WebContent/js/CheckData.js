function CheckData(){
	var flag = true;
	if(isNumber(document.postData.height.value)==false){ 
		flag = false;
	}
	else if(isNumber(document.postData.weight.value)==false){ 
		flag = false;
	}
	
	if(flag==true){
		window.alert('診断します');
		return true;
	}
	else{
		window.alert('数値を入力してください');
		return false;
	}
}

function isNumber(value){
	var pattern = /^[-]?([1-9]\d*|0)(\.\d+)?$/;
	return pattern.test(value);
}