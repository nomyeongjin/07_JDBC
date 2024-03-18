// 목록으로 버튼 동작
const goToList = document.querySelector("#goToList");

goToList.addEventListener("click", () =>{

    location.href="/"; // 메인 페이지

});

/////////////////////////////////////////////////////////////////////////////////////

//  Update-btn 버튼 클릭시
const updateBtn = document.querySelector("#updateBtn");

updateBtn.addEventListener("click",e =>{

    const gameNo = e.target.dataset.gameNo;

    location.href = `/game/update?gameNo=${gameNo}`;



});



//  delete-btn 버튼 클릭시
const deleteBtn = document.querySelector("#deleteBtn");


deleteBtn.addEventListener("click",e =>{

    const gameNo = e.target.dataset.gameNo;
    const gameTitle = document.querySelector("#gameTitle").innerText;

    console.log(gameNo,gameTitle);
    
    if(confirm(`${gameTitle}을/를 리스트에서 삭제하시겠습니까?`)){

    //location.href = `/game/delete?gameNo=${e.target.dataset.gameNo}`;
    
        const form = document.createElement("form");
        form.action = "/game/delete";
        form.method = "POST";

        const input = document.createElement("input");
        input.type = "hidden";
        input.value = gameNo;
        input.name = "gameNo";

        // form 자식으로 input 추가
        form.append(input);

        // body태그 제일 밑에 form 추가
        document.querySelector("body").append(form);

         // 화면에 추가된 form 제출하기
         form.submit();


    }else{
            // 취소 클릭시
            alert("삭제 취소");
        }
    

});