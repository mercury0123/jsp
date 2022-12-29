async function getCommentListFromServer(bno){	//서버(controller) 에 list를 요청
	try {
		const resp = await fetch('/cmt/list/'+bno); //cmt/list/260
		const cmtList = await resp.json();
		return cmtList;
	} catch (error) {
		console.log(error);
	}
}

function spreadCommentList(result) {	//전체 댓글. list로 출력	. 최종단계
	let div = document.getElementById("accordionExample");
	div.innerHTML = '';
	for (let i=0; i<result.length; i++){
		let html = '<div class="accordion-item">';
		html += `<h2 class="accordion-header" id="heading${i}">`;
		html += `<button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapse${i}" aria-expanded="true" aria-controls="collapse${i}">`;
		html += `${result[i].cno}, ${result[i].bno}, ${result[i].writer}</button></h2>`;
	    html += `<div id="collapse${i}" class="accordion-collapse collapse show" aria-labelledby="heading${i}" data-bs-parent="#accordionExample">`;
	    html += `<div class="accordion-body">`;
	    html += `<button type="button" data-cno="${result[i].cno}"
				class="btn btn-sm btn-outline-warning cmtModBtn">수정</button>`;	
		html +=	`<button type="button" data-cno="${result[i].cno}"
				class="btn btn-sm btn-outline-danger cmtDelBtn">삭제</button>`;
		html += `<input type="text" class="form-control" id="cmtText1" value="${result[i].content}">`; //댓글내용
		html += `${result[i].reg_at}`;	
		html += `</div></div></div>`;
		div.innerHTML += html;	//누적해서 담아주기위한 +=
	}
}

async function removeCommentFromServer(cnoVal){
	try {
		const url = '/cmt/remove/' + cnoVal;
		const config={
			method :'post'
		}
		const resp = await fetch(url,config);
		const result = await resp.text();
		return result;
	} catch (error) {
		console.log(error);
	}
}

async function updateCommentFromServer(cnoVal,cmtText1){
	try {
		const url = '/cmt/modify/';
		const config={
			method :'post',
			headers : {
				'Content-Type':'application/json; charset=utf-8'	//json형태로 보내겠다
			},
			body: JSON.stringify({cno:cnoVal, content:cmtText1})
		}
		const resp = await fetch(url,config);
		const result = resp.text();
		return result;
	} catch (error) {
		console.log(error);
	}
}

document.addEventListener('click', (e)=>{
	
	if(e.target.classList.contains('cmtDelBtn')){	//삭제버튼클릭
		let cnoVal = e.target.dataset.cno;
		console.log(cnoVal);
		removeCommentFromServer(cnoVal).then(result => {
			if(result > 0){
				alert("댓글삭제 성공!!!");
				printCommentList(bnoVal);
			}
		})
	}
	
	if(e.target.classList.contains('cmtModBtn')){	//수정버튼클릭
		let cnoVal = e.target.dataset.cno;		
		console.log(cnoVal);
		let div = e.target.closest('div');	//타겟을 기준으로 가장 가까운 div 찾기
		let cmtText1 = div.querySelector('#cmtText1').value;
		
		updateCommentFromServer(cnoVal,cmtText1).then(result => {
			if(result > 0){
				alert("댓글수정 성공!!!");
				printCommentList(bnoVal);
			}
		})
	}
})

function printCommentList(bno){
	getCommentListFromServer(bno).then(result=>{	//cmtList
		console.log(result);
		if(result.length >0) {
			//화면에 뿌리는 실제 로직 호출
			spreadCommentList(result);
		}	else {
			let div = document.getElementById("accordionExample");
			div.innerText = "comment 가 없습니다"
		}
	})
}

async function postCommentToServer(cmtData){
	try{
		const url ="/cmt/post";
		const config={	//이게 url에 들어가는값
			method:'post',
			headers:{
				'Content-Type':'application/json; charset=utf-8'	//json형태로 보내겠다
			},
			body: JSON.stringify(cmtData)	//cmtData 를 String 형태로 바디에
		};
		const resp = await fetch(url, config);	//config를 url위치("/cmt/post"" CommentController)로 가서  resp에 담음
		const result = await resp.text();	//resp를 text형태로 result에 , out.pring(isOk)값
		return result;	//postCommentToServer(cmtData).then(result 로 감
	} catch(error){
		console.log(error);
	}
}

//버튼 클릭했을 때, 
document.getElementById('cmtAddBtn').addEventListener('click',()=>{
	const cmtText = document.getElementById('cmtText').value;
	console.log(cmtText);
	if(cmtText == null || cmtText==''){	//댓글없으면
		alert('댓글을 입력해주세요.');
		return false;
	}else{	//댓글있으면
		let cmtData = {
			bno : bnoVal,
			writer : document.getElementById('cmtWriter').value,
			content : cmtText
		};
		postCommentToServer(cmtData).then(result => {
			if(result > 0){
				alert("댓글등록 성공!!!");
				document.getElementById('cmtText').value = "";	//댓글성공하면 다음 댓글값위해 댓글입력창비워둠
			}
			printCommentList(cmtData.bno);	//댓글리스트 불러오기 printCommentList로 감
		})
	}
})