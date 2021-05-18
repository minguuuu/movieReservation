	$(document).ready(function(){
 		$('.bxslider').bxSlider();
	});
	$(document).ready(function(){
		$('.slider2').slick({
			autoplay: true,
		 	autoplaySpeed: 2000,

	 		centerMode: true,
	  		centerPadding: '60px',
	  		slidesToShow: 3,
	  		responsive: [
	    		{
	      			breakpoint: 768,
	      			settings: {
	        			arrows: false,
	        			centerMode: true,
	        			centerPadding: '40px',
	        			slidesToShow: 3
	      			}
	    		},
	    		{
		     		breakpoint: 480,
		      		settings: {
			        	arrows: false,
			        	centerMode: true,
			        	centerPadding: '40px',
			        	slidesToShow: 1
		      		}
		    	}
	  		]
		});
	});
	$(function(){
		$(".sub_menu").hide();

		$(".main_menu").mouseover(function(){
			$(".sub_menu",this).slideDown(200);			
		});
		$(".main_menu").mouseleave(function(){
			$(".sub_menu").hide();			
		});
	});


	function join(){
		var Str="";
		var Str2=document.querySelectorAll('input[type=text], input[type=password], select')

		for(var i=0; i<Str2.length ; i++){
			if(Str2[i].value == '' || Str2[i].value=="이름을 입력하세요." || Str2[i].value=="년도" || Str2[i].value=="월" || Str2[i].value=="일" || Str2[i].value=="휴대폰번호를 입력하세요." || Str2[i].value=="SMS인증번호를 입력하세요." || Str2[i].value=="이메일 주소"){
				alert("정보를 입력해주세요.");
				Str2[i].value='';
				Str2[i].focus();
				return;
			}
			else if(Str2[1].value.length<5 || Str2[1].value=="아이디를 입력하세요."){
				alert("아이디는 5~13자리만 유효합니다.");
				Str2[1].value='';
				Str2[1].focus();
				return;
			}
			else if(Str2[2].value.length<8){
				alert("비밀번호는 8~16자 사이로 입력해주세요.");
				Str2[2].value='';
				Str2[2].focus();
				return;	
			}
			else if(Str2[2].value != Str2[3].value){
				alert("비밀번호가 일치하지 않습니다.");
				Str2[3].value='';
				Str2[3].focus();
				return;
			}
			else{
				if(i==0){
					Str += "1) 이름 : "+Str2[i].value+"\n";
				}
				else if(i==1){
					Str += "2) 아이디 : "+Str2[i].value+"\n";
				}
				else if(i==2){
					Str += "3) 비밀번호 : "+Str2[i].value+"\n";	
				}
				else if(i==4){
					Str += "4) 이메일 : "+Str2[i].value;
				}
				else if(i==5){
					Str += Str2[i].value+"\n";
				}
				else if(i==6){
					Str += "5) 생년월일 : "+Str2[i].value;
				}
				else if(i==7){
					Str += Str2[i].value;
				}
				else if(i==8){
					Str += Str2[i].value+"\n";
				}
				else if(i==9){
					Str += "6) 휴대폰번호 : "+Str2[i].value+"\n";
				}
				else if(i==10){
					Str += "7) 인증번호 : "+Str2[i].value+"\n";	
				}
				else{
				}
			}
		}
		alert(Str);
	}