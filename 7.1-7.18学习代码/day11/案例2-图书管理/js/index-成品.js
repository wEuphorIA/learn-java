//--------------------------1. 查询图书列表---------------------------
let loginUser = 'itheima'  //登录成功的用户名，默认itheima
//1 定义方法，查询图书列表
function queryBookList() {
  //2 在方法中使用axios从服务器获取图书列表数据
  axios.get(`https://hmajax.itheima.net/api/books?creator=${loginUser}`).then((result) => {
    //3 获取将服务器响应回来的图书列表数据
    let bookList = result.data.data
    //4 遍历图书数据，拼接每一行的html代码
    let trs = ``;
    for (let index = 0; index < bookList.length; index++) {
      const book = bookList[index];
      trs += `<tr>
                        <td>${book.id}</td>
                        <td>${book.bookname}</td>
                        <td>${book.author}</td>
                        <td>${book.publisher}</td>
                        <td>
                            <button type="button" class="btn btn-outline-warning btn-sm" onClick="deleteBook(${book.id})" >删除</button>
                            <button type="button" class="btn btn-outline-primary btn-sm" onClick="toEdit(${book.id})">编辑</button>
                        </td>
                    </tr>`
    }
    //5 将拼接好的html代码设置到表格中
    document.querySelector('.list').innerHTML = trs
  }).catch((err) => {
    alert('图书查询失败')
  });
}
//6 定义完方法之后就调用方法，页面加载成功就查询所有图书
queryBookList()

//--------------------------2. 新增图书---------------------------
//2.1 获取新增弹出框元素对象，创建模态框对象--->去bootstrap模态框中找
let addModalEle = document.querySelector('.add-modal')
var addModal = new bootstrap.Modal(addModalEle, {})
//2.1 显示新增对话框(模态框)----------
//1 给右上角"添加"按钮绑定click单击事件
document.querySelector('.plus-btn').addEventListener('click', () => {
  //2 在事件函数中显示新增对话框(模态框)
  addModal.show();
})

//2.2 保存新图书----------------------
//1 给保存按钮绑定点击事件
document.querySelector('.add-btn').addEventListener('click', () => {
  //2 在事件函数中获取用户输入的图书数据
  let bookname = document.querySelector('.add-modal .bookname').value
  let author = document.querySelector('.add-modal .author').value
  let publisher = document.querySelector('.add-modal .publisher').value
  //3 判断输入框内容非空，如果为空则不保存
  if (!bookname || !author || !publisher) {
    showAlertMessage(false, '请输入图书信息')
    return
  }
  //4 使用axios将图书数据提交给服务器
  let data = { bookname, author, publisher, creator: loginUser }
  axios.post('https://hmajax.itheima.net/api/books', data).then((result) => {
    //5 处理服务器返回的结果：重新查询所有图书，隐藏弹出框
    //5.1 重新加载图书列表数据
    queryBookList()
    //5.2 隐藏弹出框
    addModal.hide()
  }).catch((err) => {
    alert('添加图书失败！')
  });
})

//--------------------------3. 删除图书---------------------------
function deleteBook(bookId) {
  //1. 提示用户是否确认删除图书
  let isConfirm = confirm('是否确认删除图书？')
  if (!isConfirm) { //用户取消删除
    return
  }
  //2. 调用服务器删除指定图书
  axios.delete(`https://hmajax.itheima.net/api/books/${bookId}`)
    .then((result) => {
      //3. 处理服务器返回的数据
      //3.1 提示用户操作结果
      alert(result.data.message)
      //3.2 重新加载图书列表
      queryBookList();
    }).catch((err) => {
      alert('删除图书失败！')
    });
}
//--------------------------4. 编辑图书---------------------------
//4.1 回显图书信息---------------------
//2 获取编辑弹出框元素对象，创建模态框对象--->去bootstrap模态框中找
let editModalEle = document.querySelector('.edit-modal')
var editModal = new bootstrap.Modal(editModalEle, {})
//回显图书信息的事件函数
function toEdit(bookId) {
  //3 显示编辑图书的弹框
  editModal.show()
  //4 使用axios发送请求，根据图书id获取图书详情数据
  axios.get(`https://hmajax.itheima.net/api/books/${bookId}`).then((result) => {
    //5 将服务器返回的数据显示到编辑弹框中
    let book = result.data.data
    document.querySelector('.edit-modal .bookname').value = book.bookname
    document.querySelector('.edit-modal .author').value = book.author
    document.querySelector('.edit-modal .publisher').value = book.publisher
    document.querySelector('.edit-modal .id').value = book.id
  }).catch((err) => {
    alert('查询图书详情失败');
  });
}

//4.2 保存图书信息，用户修改完毕点击修改按钮, 将最新的数据发送给服务器
//1 给"弹出框"中的修改按钮绑定单击事件
document.querySelector('.edit-btn').addEventListener('click', () => {
  //2 获取用户输入的数据(修改后的表单数据)
  let bookname = document.querySelector('.edit-modal .bookname').value
  let author = document.querySelector('.edit-modal .author').value
  let publisher = document.querySelector('.edit-modal .publisher').value
  let bookId = document.querySelector('.edit-modal .id').value
  //3 将表单数据封装成对象
  let data = { bookname, author, publisher, "creator": loginUser }
  //4 使用axios发送请求，将修改后的数据发送给服务器
  axios.put(`https://hmajax.itheima.net/api/books/${bookId}`, data).then((result) => {
    //5 处理服务器的返回结果
    alert(result.data.message);
    //5.1 隐藏编辑弹框
    editModal.hide()
    //5.2 重新加载数据
    queryBookList()
  }).catch((err) => {
    alert('修改图书失败')
  });
})
