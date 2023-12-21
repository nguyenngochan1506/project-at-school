window.addEventListener('load', () => {
    //sự kiện sidebar
    document.querySelectorAll('.nav-sidebar .nav-link').forEach((ele, index) => ele.addEventListener('click', () => renderTab(index)))

    const content = document.querySelector('.my-content');
    //đề bài
    document.querySelector('#lab-6-debai').addEventListener('click', ()=>renderDeBai(content))
    // xử lý sự kiện cho ex1
    document.querySelector('#lab-6-ex-1').addEventListener('click', ()=>renderEx1(content))
    // xử lý sự kiện cho ex2
    document.querySelector('#lab-6-ex-2').addEventListener('click', ()=>renderEx2(content))
})
const renderDeBai = (content) =>{
    content.innerHTML=`
                     <h1 class="fst-italic text-decoration-underline mb-4">Yêu Cầu</h1>
                    <div class="container h5">
                        <p> - Trong menu Labs, tạo 1 menu Lab6 (file lab6.html) sau đó tạo 2 tab Ex1, Ex2 </p>
                        <p>- <strong>Ex1</strong>: Thiết kế một trang Web đơn giản sử dụng mẫu  <span class="text-decoration-underline fst-italic">F-pattern</span> ==> chuyển sang html (ex1.html)</p>
                        <p>- <strong>Ex2</strong>: Thiết kế một trang Web sử dụng mẫu <span class="text-decoration-underline fst-italic">Z-pattern</span> ==> chuyển sang html (ex2.html)</p>
                        <p>=> Với cả Ex1, Ex2: Tạo 2 tab <span class="text-decoration-underline fst-italic">Design</span> và <span class="text-decoration-underline fst-italic">Implementation</span>: </p>
                        <p class="ms-5">+ <strong>Design</strong>: chụp lại hình ảnh để có cái nhìn tổng quan về file thiết kế (thiết kế trên giấy và Figma), có nút Download để download file thiết kế về nếu muốn</p>
                        <p class="ms-5">+ <strong>Implementation</strong>: nội dung phần hiện thực trên html</p>
                    </div>
    `
}
const renderEx1 = (content)=>{
    content.innerHTML = `
    <h1 class="fst-italic text-decoration-underline mb-4 mt-3">Ex1 - chủ đề Anime</h1>
    <div class="row justify-content-evenly">
        <button class="col-3 btn btn-info">Design</button>
        <a href="./ex1.html" class="col-3 btn btn-success">Implementation</a>
    </div>
    <div class="row mt-3 ">
        <div class="col-6">
            <div class="d-flex mb-2 gap-2">
                <h3>Trên Giấy</h3>
            </div>
            <img class="img-fluid" src="./images/page-design-lab-06.jpg" alt="paper">
            <div class="text-center mt-2"> <a href="./images/page-design-lab-06.jpg" class="btn btn-success" download>tải về</a></div>
        </div>
        <div class="col-6">
            <div class="d-flex mb-2 gap-2">
                <h3>Trên Figma</h3>
                <a class="btn btn-info" href="https://www.figma.com/community/file/1318617176984043618/lab-6-ex1" target="_blank">Link</a>
            </div>
            <img class="img-fluid" src="./images/figma-design-lab-06.png" alt="figma">
            <div class="text-center mt-2"> <a href="./images/figma-design-lab-06.png" class="btn btn-success" download>tải về</a></div>
        </div>
    </div>
    `
}

const renderEx2 = (content)=>{
    content.innerHTML = `
    <h1 class="fst-italic text-decoration-underline mb-4 mt-3">Ex2 - chủ đề Calisthenics</h1>
    <div class="row justify-content-evenly">
        <button class="col-3 btn btn-info">Design</button>
        <a href="./ex2.html" class="col-3 btn btn-success">Implementation</a>
    </div>
    <div class="row mt-3 ">
        <div class="col-6">
            <div class="d-flex mb-2 gap-2">
                <h3>Trên Giấy</h3>
            </div>
            <img class="img-fluid" src="./images/page-design-lab-06-ex2.jpg" alt="paper">
            <div class="text-center mt-2"> <a href="./images/page-design-lab-06-ex2.jpg" class="btn btn-success" download>tải về</a></div>
        </div>
        <div class="col-6">
            <div class="d-flex mb-2 gap-2">
                <h3>Trên Figma</h3>
                <a class="btn btn-info" href="https://www.figma.com/community/file/1319656048065108062/lab-06-ex2" target="_blank">Link</a>
            </div>
            <img class="img-fluid" src="./images/figma-design-lab-06-ex2.png" alt="figma">
            <div class="text-center mt-2"> <a href="./images/figma-design-lab-06-ex2.png" class="btn btn-success" download>tải về</a></div>
        </div>
    </div>
    `
}

const renderTab = (n) => {
    const listElement = document.querySelectorAll('.nav-sidebar .nav-link');
    switch (n) {
        case 0:
            listElement.forEach((ele, index) => {
                if (index == 0) {
                    ele.classList.add('active')
                    ele.classList.remove('link-dark')
                } else {
                    ele.classList.remove('active')
                    ele.classList.add('link-dark')
                }
            })
            break;
        case 1:
            listElement.forEach((ele, index) => {
                if (index == 1) {
                    ele.classList.add('active')
                    ele.classList.remove('link-dark')
                } else {
                    ele.classList.remove('active')
                    ele.classList.add('link-dark')
                }
            })
            break;
        case 2:
            listElement.forEach((ele, index) => {
                if (index == 2) {
                    ele.classList.add('active')
                    ele.classList.remove('link-dark')
                } else {
                    ele.classList.remove('active')
                    ele.classList.add('link-dark')
                }
            })
            break;
    }
}