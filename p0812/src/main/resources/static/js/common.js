
//다음주소 api연결
function openZipSearch(){
    new daum.Postcode({
        oncomplete: function(data) {
            $("#f_postal").val(data.zonecode);
            $("#address1").val(data.address);
        }
    }).open();
}

//jquery 연결
$(function(){
	$(".mail_select").change(function(){
		alert("테스트");
		if($(this).val()==""){
			$("#mail_tail").val('');
			$("#mail_tail").prop("readonly",false);
		}else{
			$("#mail_tail").val($(this).val());
			$("#mail_tail").prop("readonly",true);
		}
	});
});
