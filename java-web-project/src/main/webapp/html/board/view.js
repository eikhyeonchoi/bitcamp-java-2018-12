// view.js를 게시물 등록, 게시물 조회에서 form을 공유하기 때문에
// location.href 즉, 
// 1) URL에서 qs가 있으면 게시물 조회로 간주하고 게시물 조회에 맞는
//    버튼을 활성화 시키고 
// 2) URL에서 qs가 없으면 게시물 등록으로 간주하고 그에 맞는
//    버튼을 활성화 시킨다
var param = location.href.split('?')[1];
if (param) {
  document.querySelector('h1').innerHTML = "게시물 조회"
  loadData(param.split('=')[1])
  var el = document.querySelectorAll('.bit-new-item');
  for (e of el) {
    e.style.display = 'none';
  }
} else {
  document.querySelector('h1').innerHTML = "새 글"
  var el = document.querySelectorAll('.bit-view-item');
  for (e of el) {
    e.style.display = 'none';
  }
}

// add 버튼을 누르면 json형식으로 서버에게 보낸다
// 그럼 서버(json/board/add)는 성공했으면 success, 실패했으면 fail을
// json 형식으로 return 해준다
document.querySelector('#add-btn').onclick = () => {
  var xhr = new XMLHttpRequest()
  xhr.onreadystatechange = function() {
    if (xhr.readyState != 4 || xhr.status != 200)
      return;
    
    var data = JSON.parse(xhr.responseText);
    
    if (data.status == 'success') {
      location.href = "index.html"
        
    } else {
      alert('등록 실패입니다!\n' + data.message)
    }
  };
  xhr.open('POST', '../../app/json/board/add', true)
  xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
  
  var contents = document.querySelector('#contents').value;
  
  xhr.send("contents=" + encodeURIComponent(contents));
};

// add 와 마찬가지로 성공하면 success, 실패하면 fail return
// 프론트앤드와 백앤드는 json으로 데이터를 주고받을 뿐이다
document.querySelector('#delete-btn').onclick = () => {
  var xhr = new XMLHttpRequest()
  xhr.onreadystatechange = function() {
    if (xhr.readyState != 4 || xhr.status != 200)
      return;
    
    var data = JSON.parse(xhr.responseText);
    
    if (data.status == 'success') {
      location.href = "index.html"
        
    } else {
      alert('삭제 실패입니다!\n' + data.message)
    }
  };
  var no = document.querySelector('#no').value;
  xhr.open('GET', '../../app/json/board/delete?no=' + no, true)
  xhr.send();
};

document.querySelector('#update-btn').onclick = () => {
  var xhr = new XMLHttpRequest()
  xhr.onreadystatechange = function() {
    if (xhr.readyState != 4 || xhr.status != 200)
      return;
    
    var data = JSON.parse(xhr.responseText);
    
    if (data.status == 'success') {
      location.href = "index.html"
        
    } else {
      alert('변경 실패입니다!\n' + data.message)
    }
  };
  xhr.open('POST', '../../app/json/board/update', true)
  xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
  
  var no = document.querySelector('#no').value;
  var contents = document.querySelector('#contents').value;
  
  var qs = 'contents=' + encodeURIComponent(contents) +
    '&no=' + no;
  
  xhr.send(qs);
};

// index.html에서 테이블의 각 항목의 제목을 누르면 view.html에 qs로 
// 번호를 보낸다, 그 번호를 받으면 즉 index.html에서 보낸 qs가 있으면
// 서버(json/board/detail?no=숫자)로 요청한 뒤 서버는 json으로 
// 클라쪽에게 데이터를 보내준다 그 json데이터를 input항목에 넣는 것
function loadData(no) {
  var xhr = new XMLHttpRequest()
  xhr.onreadystatechange = function() {
    if (xhr.readyState != 4 || xhr.status != 200)
      return;
    
    var data = JSON.parse(xhr.responseText);
    console.log(data);
    document.querySelector('#no').value = data.no;
    document.querySelector('#contents').value = data.contents;
    document.querySelector('#createdDate').value = data.createdDate;
    document.querySelector('#viewCount').value = data.viewCount;
  };
  xhr.open('GET', '../../app/json/board/detail?no=' + no, true)
  xhr.send()
}







