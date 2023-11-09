let arrSach = [{
    tenSach: 'Your Name',
    tacGia: 'Shinkai Makoto',
    quocGia: 'Nhật Bản',
    namXuatBan: 2011
},
{
    tenSach: 'Tôi thấy hoa vàng trên cỏ xanh',
    tacGia: 'Nguyễn Nhật Ánh',
    quocGia: 'Việt Nam',
    namXuatBan: 2010
},
{
    tenSach: 'Mắt Biết',
    tacGia: 'Nguyễn Nhật Ánh',
    quocGia: 'Việt Nam',
    namXuatBan: 2019
}
];
//lấy ra đối tượng
const content = document.querySelector(".my-content");
let myHtml = ``;
//xử lý logic chọn đối tượng
document.querySelector('#requirement').addEventListener('click', () => requirement())
const requirement = () => {
    //lấy ra tab requirement
    myHtml = `<div class="text-center mt-3">
        <h2>Requirement</h2>
             <div class="lead text-start" >
            <p ><strong>Yêu cầu:</strong><br>
                <p>- Chọn 1 đối tượng bất kỳ trong thế giới thực, ví dụ như
                    lớp môn học, giảng viên,…</p>
                    <p>- Thiết kế chức năng Quản lý đối tượng đó trên html bao gồm các tính năng
                        thêm, sửa, xóa, tìm kiếm cho đối tượng đó.</p>
                
                <p ><strong>Ví dụ:</strong><br></p>
                    <p>- Làm chức năng Quản lý Sinh viên, bao gôm tính năng
                        thêm, sửa, xóa, tìm kiếm.</p>
                        <p ><strong>Chú ý:</strong><br></p>
                <p>- Các thành viên trong lớp, trong nhóm không được chọn các đối tượng
                    giống nhau.</p>
             </div> 
         </div>`
    content.innerHTML = myHtml;
}
//design
document.querySelector('#design').addEventListener('click', () => design())
const design = () => {
    myHtml = ` <h2 class="text-center mb-2 text-decoration-underline">Thiết kế ban đầu</h2>
                   <div class="row justify-content-center mt-4">
                     <div class="col-5 ">
                        <h3 class="text-center">Thiết kế trên giấy</h3>
                        <div class="text-center"><a class="btn btn-success" href="images/header.png" download>Tải ảnh</a></div>
                        <img id="thietKeTrenGiay" src="./images/design2.png" class="img-fluid mt-2" alt="img"> 
                     </div>
                     <div class="col-5">
                         <h3 class="text-center">Thiết kế trên HTML</h3>
                        <div class='d-flex justify-content-center gap-2'>
                            <div class="text-center"><a class="btn btn-success" href="images/header.png" download>Tải ảnh</a></div>
                            <div class="text-center"><a class="btn btn-danger" href="https://www.figma.com/community/file/1304430921598702799" target='_blank' download>Go to figma</a></div>
                        </div>
                        <img id="thietKeTrenHtml" src="./images/design.png" class="img-fluid mt-2" alt="img"> 
                     </div>
                   </div>
    `;
    content.innerHTML = myHtml;
}


document.querySelector('#implement').addEventListener('click', () => implement())
//implement
const implement = () => {
    myHtml = `<div class="row gap-3">
            <input class="col-5 border-1" type="text" id="tenSach" placeholder="Tên sách"
                style="border-radius: 10px;" />
            <input class="col-5 border-1" type="text" id="tacGia" placeholder="Tác Giả"
                style="border-radius: 10px;" />
            <input class="col-5 border-1" type="text" id="quocGia" placeholder="Quốc Gia"
                style="border-radius: 10px;" />
            <input class="col-5 border-1" type="text" id="namXuatBan" placeholder="Năm Xuất Bản"
                style="border-radius: 10px;" />
            </div>
            <button class="btn btn-success mt-1" id="btn-them-sach">Thêm sách mới</button>
            <div class="row mt-3">
            <input class="col-5 border-1" type="text" id="timSach" data-search placeholder="Tìm sách"
                style="border-radius: 10px;" />
            </div>
            <table class="table mt-1">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Tên sách</th>
                    <th scope="col">Tác giả</th>
                    <th scope="col">Quốc gia</th>
                    <th scope="col">Năm xuất bản</th>
                    <th scope="col">Quản lý</th>
                </tr>
            </thead>
            <tbody>

            </tbody>
            </table>`;
    content.innerHTML = myHtml;

    //xử lý cho phẩn implement
    const btnThemSach = document.querySelector('#btn-them-sach');
    //xử lý thêm sách
    btnThemSach.addEventListener('click', () => themSach())
    //hàm tìm sách
    const searchInput = document.querySelector('[data-search]');
    searchInput.addEventListener('input', (e) => {
        const value = e.target.value.toLowerCase();
        const newArr = arrSach.filter((sach) => sach.tenSach.toLocaleLowerCase().includes(value)
            || sach.tacGia.toLocaleLowerCase().includes(value)
            || sach.quocGia.toLocaleLowerCase().includes(value)
            || sach.namXuatBan.toString().includes(value)
        );
        loadUpdateWithArr(newArr, document.querySelector('tbody'));
    })

    //xoá sách


    loadUpdateWithArr(arrSach, document.querySelector('tbody'));
}

const themSach = () => {
    let tenSach = document.querySelector('#tenSach').value;
    let tacGia = document.querySelector('#tacGia').value;
    let quocGia = document.querySelector('#quocGia').value;
    let namXuatBan = document.querySelector('#namXuatBan').value;
    if (tenSach && tacGia && quocGia && namXuatBan) {
        if (arrSach.every((sach) => sach.tenSach !== tenSach.trim())) {    //kiểm tra tên sách trước đó đã có trog arr hay chưa
            const sachMoi = {
                tenSach: tenSach.trim(),
                tacGia: tacGia.trim(),
                quocGia: quocGia.trim(),
                namXuatBan: namXuatBan.trim()
            };
            arrSach.unshift(sachMoi);

            //trả về rỗng cho các input
            document.querySelector('#tenSach').value = ``;
            document.querySelector('#tacGia').value = ``;
            document.querySelector('#quocGia').value = ``;
            document.querySelector('#namXuatBan').value = ``;
        } else {
            alert("Sách đã tồn tại!")
        }
    } else {
        alert(`Vui lòng nhập đầy đủ thông tin!`)
    }
    loadUpdateWithArr(arrSach, document.querySelector('tbody'));
}
//hàm xoá sách
const xoaSach = (tenSach) => {

    arrSach = arrSach.filter((sach) => sach.tenSach !== tenSach);
    loadUpdateWithArr(arrSach, document.querySelector('tbody'));
}

//hàm sửa sách
const suaSach = (tenSach, tacGia, quocGia, namXuatBan) => {
    //ý tưởng là ta sẽ xoá nó rồi đem tất cả thông tin vào ô thêm sách
    // xem ta xem như thêm nó lại từ đầu
    //b1: thêm các thông tin vào ô input
    document.querySelector('#tenSach').value = tenSach;
    document.querySelector('#tacGia').value = tacGia;
    document.querySelector('#quocGia').value = quocGia;
    document.querySelector('#namXuatBan').value = namXuatBan;
    //b2: xoá nó khỏi arr
    xoaSach(tenSach)

}
const loadUpdateWithArr = (arr, tbody) => {
    let main = arr.map((data, index) => {
        return `<tr>
                <th scope="row">${index + 1}</th>
                <td>${data.tenSach}</td>
                <td>${data.tacGia}</td>
                <td>${data.quocGia}</td>
                <td>${data.namXuatBan}</td>
                <td>
                    <button class="btn btn-danger" onclick="xoaSach('${data.tenSach}')">Xoá</button>
                    <button class="btn btn-primary" onclick="suaSach('${data.tenSach}', '${data.tacGia}', '${data.quocGia}', '${data.namXuatBan}')">Sửa</button>
                </td>
            </tr>`
    });

    tbody.innerHTML = main;
}

