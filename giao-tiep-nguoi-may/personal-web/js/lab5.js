//nút
document.querySelector('#btn-hien-thuc').addEventListener('click', () => hienThiHienThuc())
document.querySelector('#btn-yeu-cau').addEventListener('click', () => hienThiYeuCau())
document.querySelector('#btn-thiet-ke').addEventListener('click', () => hienThiThietKe())

//lấy ra phần content
const myContent = document.querySelector('.my-content');

const hienThiThietKe = () =>{
myContent.innerHTML = `
<h2 class="mt-2 text-decoration-underline">Thiết Kế:</h2>
            <h3>- User Scenario</h3>
            <h3>- <a href="https://www.figma.com/community/file/1310594430141576426" target="_blank">File Figma</a></h3>
            <img src="./images/user-scenario.jpg" class="img-fluid" alt="user-scenario">
`
}

const hienThiHienThuc = () => {
    myContent.innerHTML = `
    <div class="d-flex justify-content-center ">
    <div class="w-75 border border-1 custom-fitness">
        <h2 class="fit-title text-center">Ăn Bao Nhiêu Là Đủ?</h2>
        <div class="row text-center mt-3">
            <span class="col-3 fs-5">Tuổi:</span>
            <div class="w-75">
                <input id="tuoi" type="number" step="1" class="form-control"
                    aria-label="Recipient's username" aria-describedby="basic-addon2">
            </div>
        </div>
        <div class="row text-center mt-3">
            <span class="col-3 fs-5">Giới Tính:</span>
            <div class="col-3 d-flex gap-5 ms-5 align-items-center">
                <div class="form-check ">
                    <input class="form-check-input" checked type="radio" name="flexRadioDefault" id="nam">
                    <label class="form-check-label"  for="nam">
                        Nam
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="flexRadioDefault" id="nu">
                    <label class="form-check-label" for="nu">
                        Nữ
                    </label>
                </div>
            </div>
        </div>
        <div class="row text-center mt-3">
            <div class="col-3 fs-5">Chiều Cao:</div>
            <div class="input-group mb-3 w-75">
                <input id="chieu-cao" type="number" step="0.1" class="form-control"
                    aria-label="Recipient's username" aria-describedby="basic-addon2">
                <span class="input-group-text fw-bold" id="basic-addon2">cm</span>
            </div>
        </div>
        <div class="row text-center mt-1">
            <div class="col-3 fs-5">Cân Nặng:</div>
            <div class="input-group mb-3 w-75">
                <input id="can-nang" type="number" step="0.1" class="form-control"
                    aria-label="Recipient's username" aria-describedby="basic-addon2">
                <span class="input-group-text fw-bold" id="basic-addon2">kg</span>
            </div>
        </div>
        <div class="row text-center mt-1">
            <div class="col-3 fs-5">Khả Năng Vận Động</div>
            <div class="input-group mb-3 w-75">
                <select class="form-select" id="inputGroupSelect01">
                    <option value="1.2">Nếu bạn chỉ thực hiện các chức năng cơ bản = thở, tuần hoàn, sản xuất
                        tế bào</option>
                    <option value="1.375">Nếu bạn ít vận động = ít hoặc không tập thể dục trong một ngày
                    </option>
                    <option value="1.55">Nếu bạn vận động nhẹ = tập thể dục / thể thao nhẹ nhàng 1-3 ngày /
                        tuần</option>
                    <option value="1.725">Nếu bạn sinh hoạt điều độ = tập thể dục / thể thao vừa phải 3-5 ngày /
                        tuần</option>
                    <option value="1.9">Nếu bạn rất năng động = chăm chỉ tập thể dục / thể thao 6-7 ngày một
                        tuần</option>
                </select>
            </div>
        </div>
        <div class="row justify-content-center mb-4 mt-2">
            <button class="btn btn-outline-primary col-3 " onClick="tinhToan()">Tính Toán</button>
        </div>
        <hr class="m-0">
        <div class="mt-0 pt-3 pb-5 text-center fs-4 fw-bold"  id="ket-qua" style="background-color: #F7F7F7;">
            
        </div>
    </div>
</div>
    `;
}

const hienThiYeuCau = () => {
    myContent.innerHTML = `
    <h2 class="mt-2 text-decoration-underline">Yêu Cầu:</h2>
            <p>(1) Tạo ra một user scenario</p>
            <p>(2) Chọn 1 bước trong user scenario để thiết kế 1 form giao diện Web trên công cụ thiết kế đã chọn. Sau đó thiết kế trên Figma rồi chuyển sang html tương ứng cho thiết kế này</p>
            <p>Upload lên github: trong file html có chèn hình ảnh của user scenario ở (1) và đường dẫn của file thiết kế ở (2).</p>
    `
}
const tinhToan = () => {
    const tuoi = document.querySelector('#tuoi').value;
    const canNang = document.querySelector('#can-nang').value;
    const chieuCao = document.querySelector('#chieu-cao').value;
    const gioiTinh = document.querySelector('#nu').checked ? "Nữ" : "Nam";
    const tdee = document.querySelector('#inputGroupSelect01').value; // Mức độ vận động
    //    BMR là công thức để tính tỷ lệ trao đổi chất cơ bản.
    /**
     * Theo phương trình Mifflin-St Jeor ta có: 
             Nam giới: BMR = 10W + 6.25H - 5A +5
            Nữ giới: BMR = 10W + 6.25H - 5A - 161
            note: W là cân nặng theo ibs
     */
    if (tuoi && canNang && chieuCao && gioiTinh && tdee) {
        let brm = (gioiTinh === "Nam") ? (10 * canNang + 6.25 * chieuCao - 5 * tuoi + 5) : (10 * canNang + 6.25 * chieuCao - 5 * tuoi - 161);
        const ketQua = brm * tdee;
        document.querySelector('#ket-qua').innerHTML = `
    <p>Bạn Cần Tiêu Thụ</p>
    <span class="fs-3">${ketQua} Calories/ngày</span>
    `
    } else {
        document.querySelector('#ket-qua').innerHTML = `
    <p>Vui lòng nhập đầy đủ thông tin!</p>`
    }
}