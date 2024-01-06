window.addEventListener('load',()=>{
    const myContent = document.querySelector('.my-content');
    //yeue cau 
    document.querySelector('#btn-yeu-cau').addEventListener('click', ()=>renderRequire(myContent))
    //design
    document.querySelector('#btn-thiet-ke').addEventListener('click', ()=>renderDesign(myContent))
})
const renderDesign = (content) =>{
    content.innerHTML = `
    <h2 class="text-center mb-2 text-decoration-underline">Thiết kế ban đầu</h2>
                   <div class="row justify-content-center mt-4">
                     <div class="col-5 ">
                        <h3 class="text-center">Thiết kế trên giấy</h3>
                        <div class="text-center"><a class="btn btn-success" href="./images/lab-08-paper.jpg" download>Tải ảnh</a></div>
                        <div class="text-center"><img id="thietKeTrenGiay" src="./images/lab-08-paper.jpg" class="img-fluid mt-2" alt="img"> </div>
                     </div>
                     <div class="col-5">
                         <h3 class="text-center">Thiết kế trên HTML</h3>
                        <div class='d-flex justify-content-center gap-2'>
                            <div class="text-center"><a class="btn btn-success" href="./images/lab-08-figma.png" download>Tải ảnh</a></div>
                            <div class="text-center"><a class="btn btn-danger" href="https://www.figma.com/community/file/1325451981299913481" target='_blank' download>Go to figma</a></div>
                        </div>
                        <div class="text-center"><img id="thietKeTrenHtml" src="./images/lab-08-figma.png" class="img-fluid mt-2" alt="img"> </div>
                     </div>
                   </div>
    `;
}
const renderRequire = (content) =>{
    content.innerHTML = `
    <h2 class="mt-2 text-decoration-underline">Yêu Cầu:</h2>
    <ul>
        <li>Tạo một trang Web có nội dung bất kỳ, sử dụng linh hoạt tất cả những phần sau: Input Controls,
            Navigation, Animations, Default Settings, Guided Actions</li>
            <li>Có biểu mẫu liên hệ</li>
            <li>Upload lên github</li>
    </ul>
    `;
}
