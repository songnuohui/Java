var time_cd = setInterval("countdown()",1000);
var cd = 600;
function $$(a){
	return document.getElementById(a);
}

//考试计时
function countdown(){
	cd = cd - 1;
	tamp = parseInt(cd/60);
	$$("exam_time").innerHTML = tamp;
	if(cd == 0){
		$$("exam_paper").submit();
	}
} 

//选择答案（单选singoselect）ss
function click_answer(n){

	for(var i=0;i<=3;i++){
		if(i != n ){
			this.parentNode.children[i].style.color = "#888888";
		}else{
			this.parentNode.children[i].style.color = "#65a2fd";
		}
	}
}

