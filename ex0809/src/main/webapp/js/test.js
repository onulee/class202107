

function startTime(){
	no = setInterval(setTime,1000);
}

function setTime(){
	var date = new Date();  //현재 날짜,시간을 가져오는 객체
	document.getElementById("timeScreen").innerHTML = date.toLocaleString();
	
	
}